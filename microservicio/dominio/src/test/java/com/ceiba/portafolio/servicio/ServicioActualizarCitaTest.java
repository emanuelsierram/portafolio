package com.ceiba.portafolio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.portafolio.modelo.dto.DtoCita;
import com.ceiba.portafolio.modelo.entidad.Cita;
import com.ceiba.portafolio.servicio.ServicioActualizarCita;
import com.ceiba.portafolio.puerto.repositorio.RepositorioCita;
import com.ceiba.portafolio.servicio.testdatabuilder.CitaTestDataBuilder;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ServicioActualizarCitaTest {

    private final static Double VALOR_ACORDADO_CON_DESCUENTO_POR_RETRASO=180.0;


    @Test
    public void valorAcordadoDespuesDeTerminarLaCitaTest(){
        Cita cita = new CitaTestDataBuilder().build();
        final ArgumentCaptor<Cita> citaCaptor = ArgumentCaptor.forClass(Cita.class);
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.listarPorId(Mockito.anyLong())).thenReturn(new
                DtoCita(1l,
                "Esta es una descripcion",
                LocalDateTime.of(2021,04,20,10,20),
                 LocalDateTime.of(2021,04,20,11, 20 ),
                200.0,
                  1));
        ServicioActualizarCita servicioActualizarCita = new ServicioActualizarCita(repositorioCita);
        servicioActualizarCita.ejecutar(cita);
        Mockito.verify(repositorioCita).actualizar(citaCaptor.capture());
        assertEquals(VALOR_ACORDADO_CON_DESCUENTO_POR_RETRASO, citaCaptor.getValue().getValorAcordado());

    }

    private static void  assertEquals(double valorEsperado, double valorFinal) {
   if(valorFinal!=valorEsperado){
       throw new ExcepcionValorInvalido(valorFinal+ " Es diferente al esperado "+ valorEsperado);
   }

    }
}
