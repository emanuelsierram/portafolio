package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.dto.DtoCita;
import com.ceiba.usuario.modelo.entidad.Cita;
import com.ceiba.usuario.puerto.dao.DaoCita;
import com.ceiba.usuario.puerto.repositorio.RepositorioCita;

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
