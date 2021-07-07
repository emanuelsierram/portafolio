package com.ceiba.portafolio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.portafolio.puerto.repositorio.RepositorioCita;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarCitaTest {

    private static final Long VALOR_INVALIDO=0L;


    @Test
    public void eliminarCitaTest(){
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        ServicioEliminarCita servicioEliminarCita = new ServicioEliminarCita(repositorioCita);
        BasePrueba.assertThrows(() -> servicioEliminarCita.ejecutar(VALOR_INVALIDO), ExcepcionValorInvalido.class,"Valor del id invalido");
    }
}
