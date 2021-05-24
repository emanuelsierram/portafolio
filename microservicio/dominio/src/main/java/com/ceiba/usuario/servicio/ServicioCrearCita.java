package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.entidad.Cita;
import com.ceiba.usuario.puerto.repositorio.RepositorioCita;

import static java.time.temporal.ChronoUnit.MINUTES;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ServicioCrearCita{

    private static final String YA_EXISTE_CITA_EN_EL_HORARIO = "Ya existe cita en el horario establecido";
    private static final String NO_SE_PUEDE_AGENDAR_EN_DIA_SABADO = "No se puede agendar el dia sabado";
    private static final String CITA_MINIMA_DE_UNA_HORA = "Cita minima de una hora";
    private static final String NO_ESTA_EN_EL_INTERVALO_DE_TIEMPO = "horario tomado no se encuentra en el horario establecido: 6:00 am - 10:00pm";



    private final RepositorioCita repositorioCita;

    public ServicioCrearCita(RepositorioCita repositorioCita){
        this.repositorioCita=repositorioCita;
    }

    public Long ejecutar(Cita cita) {
        validarExistenciaPrevia(cita);
        validarNoAgendarDiaSabado(cita.getFechaInicio());
        validarDuracionMinima(cita.getFechaInicio(), cita.getFechaFinal());
        validarIntervalo(cita.getFechaInicio(), cita.getFechaFinal());
       cita.setValorAcordado(valorAcordadoPorMetodoDePago(cita));
        return this.repositorioCita.crear(cita);
    }

    public void validarExistenciaPrevia(Cita cita) {
        boolean existe = this.repositorioCita.existe(cita.getFechaInicio());

        if(existe) {

            throw new ExcepcionDuplicidad(YA_EXISTE_CITA_EN_EL_HORARIO);
        }
    }

    public  void validarNoAgendarDiaSabado(LocalDateTime fecha){
        if("SATURDAY".equals(fecha.getDayOfWeek().name())) {
            throw new ExcepcionValorInvalido(NO_SE_PUEDE_AGENDAR_EN_DIA_SABADO);
        }

    }

    public double valorAcordadoPorMetodoDePago(Cita cita){
        if("credito".equalsIgnoreCase(cita.getMetodoPago())){
            return cita.getValorAcordado()-(cita.getValorAcordado()*0.07);
        }
        return cita.getValorAcordado();
    }

    public void validarDuracionMinima(LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
        int minutos= (int) MINUTES.between(fechaInicio, fechaFinal);
        if(minutos<60) {
            throw new ExcepcionValorInvalido(CITA_MINIMA_DE_UNA_HORA);
        }


    }

    public void validarIntervalo(LocalDateTime fechaInicioIngresada, LocalDateTime fechaFinalIngresada){
        LocalTime tiempoInicioNuevo= LocalTime.of(06,01,22);
        LocalTime tiempoFinalNuevo = LocalTime.of(22,01,22);
        LocalDate fechaInicioNueva = fechaInicioIngresada.toLocalDate();
        LocalDate fechaFinalNueva = fechaFinalIngresada.toLocalDate();

        LocalDateTime fechaInicio = LocalDateTime.of(fechaInicioNueva, tiempoInicioNuevo);
        LocalDateTime fechaFinal = LocalDateTime.of(fechaFinalNueva, tiempoFinalNuevo);

        if(fechaInicioIngresada.isBefore(fechaInicio)) {
            throw new ExcepcionValorInvalido(NO_ESTA_EN_EL_INTERVALO_DE_TIEMPO);
        }
        if(fechaFinalIngresada.isAfter(fechaFinal)) {
            throw new ExcepcionValorInvalido(NO_ESTA_EN_EL_INTERVALO_DE_TIEMPO);
        }

    }







}
