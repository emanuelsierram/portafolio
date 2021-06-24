package com.ceiba.portafolio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.portafolio.modelo.dto.DtoCita;
import com.ceiba.portafolio.modelo.dto.DtoTrabajador;
import com.ceiba.portafolio.modelo.entidad.Cita;
import com.ceiba.portafolio.puerto.repositorio.RepositorioCita;
import com.ceiba.portafolio.puerto.repositorio.RepositorioTrabajador;

import java.time.LocalDateTime;
import java.util.List;


public class ServicioCrearCita{

    private static final String YA_EXISTE_CITA_EN_EL_HORARIO = "Ya existe cita en el horario establecido";
    private static final String METODO_PAGO_CREDITO = "credito";



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

        List<DtoCita> citasExistentes= this.repositorioCita.listarPorIdTrabajador(cita.getIdTrabajador());
        LocalDateTime fechaInicioIngresada = cita.getFechaInicio();
        LocalDateTime fechaFinalIngresada = cita.getFechaFinal();



        for (DtoCita dtoCita: citasExistentes) {

            LocalDateTime fechaInicioExistemte = dtoCita.getFechaInicio();
            LocalDateTime fechaFinalExistemte = dtoCita.getFechaFinal();

            if(fechaInicioIngresada.isAfter(fechaInicioExistemte) && fechaFinalIngresada.isBefore(fechaFinalExistemte)) {
                throw new ExcepcionDuplicidad(YA_EXISTE_CITA_EN_EL_HORARIO);
            }
            if(fechaInicioIngresada.isBefore(fechaInicioExistemte) && (fechaFinalIngresada.isBefore(fechaFinalExistemte)
                    && fechaFinalIngresada.isAfter(fechaInicioExistemte))){
                throw new ExcepcionDuplicidad(YA_EXISTE_CITA_EN_EL_HORARIO);
            }
            if((fechaInicioIngresada.isAfter(fechaInicioExistemte) && fechaInicioIngresada.isBefore(fechaFinalExistemte))
                    && fechaFinalIngresada.isAfter(fechaFinalExistemte)){
                throw new ExcepcionDuplicidad(YA_EXISTE_CITA_EN_EL_HORARIO);
            }
            if(fechaInicioIngresada.isBefore(fechaInicioExistemte) && fechaFinalIngresada.isAfter(fechaFinalExistemte)){
                throw new ExcepcionDuplicidad(YA_EXISTE_CITA_EN_EL_HORARIO);

            }

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
