package com.ceiba.portafolio.servicio;

import com.ceiba.portafolio.modelo.dto.DtoCita;
import com.ceiba.portafolio.modelo.entidad.Cita;
import com.ceiba.portafolio.puerto.repositorio.RepositorioCita;

import static java.time.temporal.ChronoUnit.MINUTES;

public class ServicioActualizarCita {


    private final RepositorioCita repositorioCita;

    public ServicioActualizarCita(RepositorioCita repositorioCita){
        this.repositorioCita=repositorioCita;
    }
    public void ejecutar(Cita cita) {
        cita.setValorAcordado(valorAcordadoDespuesDeTerminarLaCita(cita));
        this.repositorioCita.actualizar(cita);
    }

    public double valorAcordadoDespuesDeTerminarLaCita(Cita cita){

        DtoCita citaExistente = repositorioCita.listarPorId(cita.getId());
        if(cita.getFechaFinal().isAfter(citaExistente.getFechaFinal())){
            int minutos= (int) MINUTES.between(citaExistente.getFechaFinal(), cita.getFechaFinal());
          double cantidadDe30MinutosPasados=Math.floor(minutos/30.0);
          return citaExistente.getValorAcordado()-(citaExistente.getValorAcordado()*((cantidadDe30MinutosPasados*5.0)/100.0));
        }
        return cita.getValorAcordado();
    }



}
