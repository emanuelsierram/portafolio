package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Cita;
import com.ceiba.usuario.puerto.repositorio.RepositorioCita;
import static java.time.temporal.ChronoUnit.MINUTES;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;

public class ServicioCrearCita{

    private static final String YA_EXISTE_CITA_EN_EL_HORARIO = "Ya existe cita en el horario establecido";
    private static final String NO_SE_PUEDE_AGENDAR_EN_DIA_SABADO = "No se puede agendar el dia sabado";
    private static final String CITA_MINIMA_DE_UNA_HORA = "Cita minima de una hora";
    private static final String NO_ESTA_EN_EL_INTERVALO_DE_TIEMPO = "horario tomado no se encuentra en el horario establecido: 6:00 am - 10:00pm";



    private final RepositorioCita repositorioCita;

    public ServicioCrearCita(RepositorioCita repositorioCita){
        this.repositorioCita=repositorioCita;
    }

    public Long ejecutar(Cita cita, String metodo){
        validarFecha(cita.getFechaInicio());
        validarDuracion(cita.getFechaInicio(), cita.getFechaFinal());
        validarIntervalo(cita.getFechaInicio(), cita.getFechaFinal());
        if(metodo.equals("credito"))
            cita.setValorAcordado(cita.getValorAcordado()-(cita.getValorAcordado()*0.07));
        return this.repositorioCita.crear(cita);
    }

    public void validarFecha(LocalDateTime fecha){
      LocalDateTime fechaExistente = repositorioCita.consultar(fecha);
        if(fechaExistente.isEqual(fecha) || fechaExistente.isBefore(fecha))
            throw new ExcepcionDuplicidad(YA_EXISTE_CITA_EN_EL_HORARIO);
        if(fechaExistente.getDayOfWeek().name().equals("SATURDAY"))
            throw new ExcepcionDuplicidad(NO_SE_PUEDE_AGENDAR_EN_DIA_SABADO);
    }

    public void validarDuracion(LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
        int minutos= (int) MINUTES.between(fechaInicio, fechaFinal);
        if(minutos<60)
            throw new ExcepcionDuplicidad(CITA_MINIMA_DE_UNA_HORA);

    }

    public void validarIntervalo(LocalDateTime fechaInicio, LocalDateTime fechaFinal){
       LocalTime tiempoInicio= LocalTime.of(06,00,00);
       LocalTime tiempoFinal = LocalTime.of(22,00,00);
       if(fechaInicio.isBefore(ChronoLocalDateTime.from(tiempoInicio)))
           throw new ExcepcionDuplicidad(NO_ESTA_EN_EL_INTERVALO_DE_TIEMPO);
       if(fechaFinal.isAfter(ChronoLocalDateTime.from(tiempoFinal)))
           throw new ExcepcionDuplicidad(NO_ESTA_EN_EL_INTERVALO_DE_TIEMPO);

    }






}
