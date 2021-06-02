package com.ceiba.portafolio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.portafolio.modelo.dto.DtoTrabajador;
import com.ceiba.portafolio.modelo.entidad.Cita;
import com.ceiba.portafolio.puerto.repositorio.RepositorioCita;
import com.ceiba.portafolio.puerto.repositorio.RepositorioTrabajador;


import static java.time.temporal.ChronoUnit.MINUTES;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ServicioCrearCita{

    private static final String YA_EXISTE_CITA_EN_EL_HORARIO = "Ya existe cita en el horario establecido";
    private static final String METODO_PAGO_CREDITO = "Crédito";



    private final RepositorioCita repositorioCita;
    private  final RepositorioTrabajador repositorioTrabajador;

    public ServicioCrearCita(RepositorioCita repositorioCita, RepositorioTrabajador repositorioTrabajador){
        this.repositorioCita=repositorioCita;
        this.repositorioTrabajador=repositorioTrabajador;
    }

    public Long ejecutar(Cita cita) {
        validarExistenciaPrevia(cita);
        cita.setValorAcordado(valorAcordadoPorMetodoDePago(cita));
        return this.repositorioCita.crear(cita);
    }

    private void validarExistenciaPrevia(Cita cita) {
        boolean existe = this.repositorioCita.existe(cita.getFechaInicio());

        if(existe) {
            throw new ExcepcionDuplicidad(YA_EXISTE_CITA_EN_EL_HORARIO);
        }
    }

    private double valorAcordadoPorMetodoDePago(Cita cita){
        DtoTrabajador trabajador = repositorioTrabajador.listarPorId(cita.getIdTrabajador());
        if(METODO_PAGO_CREDITO.equalsIgnoreCase(trabajador.getMetodoDePago())){
            return cita.getValorAcordado()-(cita.getValorAcordado()*0.07);
        }
        return cita.getValorAcordado();
    }









}
