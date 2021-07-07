package com.ceiba.portafolio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.portafolio.puerto.repositorio.RepositorioCita;

public class ServicioEliminarCita {

    private final RepositorioCita repositorioCita;

    private static final String VALOR_INVALIDO = "Valor del id invalido";


    public ServicioEliminarCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public void ejecutar(Long id) {
        validarValorIdValido(id);
        this.repositorioCita.eliminar(id);
    }

    private void validarValorIdValido(Long id){
        if(id<1L){
            throw new ExcepcionValorInvalido(VALOR_INVALIDO);
        }
    }
}
