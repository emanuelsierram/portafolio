package com.ceiba.usuario.modelo.entidad;


import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Cita{

    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar la descripcion";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIO = "Se debe ingresar la fecha de inicio";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_FINAL = "Se debe ingresar la fecha final";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_ACORDADO= "Se debe ingresar el valor acordado";
    private static final String NO_SE_PUEDE_AGENDAR_EN_DIA_SABADO = "No se puede agendar el dia sabado";


    private static final String SATURDAY = "sabado";


    private Long id;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private Double valorAcordado;
    private Integer idUsuario;


    public Cita(Long id,String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFinal, Double valorAcordado, Integer idUsuario) {
      validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION);
       validarObligatorio(fechaInicio, SE_DEBE_INGRESAR_LA_FECHA_INICIO);
       validarObligatorio(fechaFinal, SE_DEBE_INGRESAR_LA_FECHA_FINAL);
        validarObligatorio(valorAcordado, SE_DEBE_INGRESAR_EL_VALOR_ACORDADO);

        this.id = id;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.valorAcordado = valorAcordado;
        this.idUsuario = idUsuario;
        validarNoAgendarDiaSabado();
    }

    private  void validarNoAgendarDiaSabado(){
        if(SATURDAY.equals(this.fechaInicio.getDayOfWeek().name())) {
            throw new ExcepcionValorInvalido(NO_SE_PUEDE_AGENDAR_EN_DIA_SABADO);
        }

    }

}
