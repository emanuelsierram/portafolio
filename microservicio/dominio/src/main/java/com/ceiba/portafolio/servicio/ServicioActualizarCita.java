package com.ceiba.portafolio.servicio;

import com.ceiba.portafolio.modelo.dto.DtoCita;
import com.ceiba.portafolio.modelo.entidad.Cita;
import com.ceiba.portafolio.puerto.repositorio.RepositorioCita;

import static java.time.temporal.ChronoUnit.MINUTES;

public class ServicioActualizarCita {
    
    private static final Double MEDIA_HORA=30.0;
    private static final Double DESCUENTO_POR_CADA_30_MINUTOS_QUE_PASAN=0.05;


    private final RepositorioCita repositorioCita;

    public ServicioActualizarCita(RepositorioCita repositorioCita){
        this.repositorioCita=repositorioCita;
    }
    public void ejecutar(Cita cita) {
        cita.setValorAcordado(valorAcordadoDespuesDeTerminarLaCita(cita));
        this.repositorioCita.actualizar(cita);
    }

    private double valorAcordadoDespuesDeTerminarLaCita(Cita cita){

        DtoCita citaExistente = repositorioCita.listarPorId(cita.getId());
        if(cita.getFechaFinal().isAfter(citaExistente.getFechaFinal())){
            int minutos= (int) MINUTES.between(citaExistente.getFechaFinal(), cita.getFechaFinal());
          double cantidadDeMediaHorasPasadas=Math.floor(minutos/MEDIA_HORA);
          return citaExistente.getValorAcordado()-(citaExistente.getValorAcordado()*(cantidadDeMediaHorasPasadas*DESCUENTO_POR_CADA_30_MINUTOS_QUE_PASAN));
        }
        return cita.getValorAcordado();
    }



}
