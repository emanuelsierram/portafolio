package com.ceiba.portafolio.modelo.entidad;


import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static java.time.temporal.ChronoUnit.MINUTES;

@Getter
@Setter
public class Cita{

    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar la descripcion";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIO = "Se debe ingresar la fecha de inicio";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_FINAL = "Se debe ingresar la fecha final";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_ACORDADO= "Se debe ingresar el valor acordado";
    private static final String NO_SE_PUEDE_AGENDAR_EN_DIA_SABADO = "No se puede agendar el dia sabado";
    private static final String LA_FECHA_FINAL_NO_DEBE_SER_MENOR = "La fecha final no debe ser mayor a la fecha inicial";
    private static final String CITA_MINIMA_DE_UNA_HORA = "Cita minima de una hora";
    private static final String NO_ESTA_EN_EL_INTERVALO_DE_TIEMPO = "horario tomado no se encuentra en el horario establecido: 6:00 am - 10:00pm";

    private static final String SATURDAY = "SATURDAY";
    private static final int DURACION_MINIMA_CITA = 60;


    private Long id;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private Double valorAcordado;
    private Integer idTrabajador;


    public Cita(Long id,String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFinal, Double valorAcordado, Integer idTrabajador) {
       validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION);
       validarObligatorio(fechaInicio, SE_DEBE_INGRESAR_LA_FECHA_INICIO);
       validarObligatorio(fechaFinal, SE_DEBE_INGRESAR_LA_FECHA_FINAL);
       validarObligatorio(valorAcordado, SE_DEBE_INGRESAR_EL_VALOR_ACORDADO);

        this.id = id;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.valorAcordado = valorAcordado;
        this.idTrabajador = idTrabajador;

        validarIngresoDeFechas();
        validarNoAgendarDiaSabado();
        validarDuracionMinima();
        validarIntervaloDeCita();
    }

    private  void validarNoAgendarDiaSabado(){
        if(SATURDAY.equals(this.fechaInicio.getDayOfWeek().name())) {
            throw new ExcepcionValorInvalido(NO_SE_PUEDE_AGENDAR_EN_DIA_SABADO);
        }

    }

    private void validarIngresoDeFechas(){
        if(this.fechaFinal.isBefore(this.fechaInicio)){
            throw new ExcepcionValorInvalido(LA_FECHA_FINAL_NO_DEBE_SER_MENOR);
        }

    }

    private void validarDuracionMinima() {
        int minutos= (int) MINUTES.between(this.fechaInicio, this.fechaFinal);
        if(minutos<=DURACION_MINIMA_CITA) {
            throw new ExcepcionValorInvalido(CITA_MINIMA_DE_UNA_HORA);
        }
    }

    private void validarIntervaloDeCita(){
        LocalTime tiempoInicioMinimo= LocalTime.of(6,0,0);
        LocalTime tiempoFinalMaximo = LocalTime.of(22,0,0);
        LocalDate fechaInicio = this.fechaInicio.toLocalDate();
        LocalDate fechaFinal = this.fechaFinal.toLocalDate();

        if(this.fechaInicio.isBefore(LocalDateTime.of(fechaInicio, tiempoInicioMinimo)) && this.fechaFinal.isAfter(LocalDateTime.of(fechaFinal, tiempoFinalMaximo))) {
            throw new ExcepcionValorInvalido(NO_ESTA_EN_EL_INTERVALO_DE_TIEMPO);
        }

    }

}
