package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Cita;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioCita;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

import static java.time.temporal.ChronoUnit.MINUTES;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ServicioCrearCita{

    private static final String YA_EXISTE_CITA_EN_EL_HORARIO = "Ya existe cita en el horario establecido";
    private static final String CITA_MINIMA_DE_UNA_HORA = "Cita minima de una hora";
    private static final String NO_ESTA_EN_EL_INTERVALO_DE_TIEMPO = "horario tomado no se encuentra en el horario establecido: 6:00 am - 10:00pm";



    private final RepositorioCita repositorioCita;
    private  final RepositorioUsuario repositorioUsuario;

    public ServicioCrearCita(RepositorioCita repositorioCita, RepositorioUsuario repositorioUsuario){
        this.repositorioCita=repositorioCita;
        this.repositorioUsuario=repositorioUsuario;
    }

    public Long ejecutar(Cita cita) {
        validarExistenciaPrevia(cita);
        validarDuracionMinima(cita.getFechaInicio(), cita.getFechaFinal());
        validarIntervalo(cita.getFechaInicio(), cita.getFechaFinal());
       cita.setValorAcordado(valorAcordadoPorMetodoDePago(cita));
        return this.repositorioCita.crear(cita);
    }

    private void validarExistenciaPrevia(Cita cita) {
        boolean existe = this.repositorioCita.existe(cita.getFechaInicio());

        if(existe) {
            throw new ExcepcionDuplicidad(YA_EXISTE_CITA_EN_EL_HORARIO);
        }
    }

    public double valorAcordadoPorMetodoDePago(Cita cita){
        DtoUsuario usuario = repositorioUsuario.listarPorId(cita.getIdUsuario());
        if("credito".equalsIgnoreCase(usuario.getMetodoDePago())){
            return cita.getValorAcordado()-(cita.getValorAcordado()*0.07);
        }
        return cita.getValorAcordado();
    }

    private void validarDuracionMinima(LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
        int minutos= (int) MINUTES.between(fechaInicio, fechaFinal);
        if(minutos<60) {
            throw new ExcepcionValorInvalido(CITA_MINIMA_DE_UNA_HORA);
        }
    }

    private void validarIntervalo(LocalDateTime fechaInicioIngresada, LocalDateTime fechaFinalIngresada){
        LocalTime tiempoInicioNuevo= LocalTime.of(6,1,22);
        LocalTime tiempoFinalNuevo = LocalTime.of(22,1,22);
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
