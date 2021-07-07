package com.ceiba.portafolio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.portafolio.modelo.dto.DtoCita;
import com.ceiba.portafolio.modelo.entidad.Cita;
import com.ceiba.portafolio.puerto.repositorio.RepositorioCita;
import com.ceiba.portafolio.servicio.testdatabuilder.CitaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ServicioActualizarCitaTest {

    private RepositorioCita repositorioCita;
    private ServicioActualizarCita servicioActualizarCita;


    private final static Double VALOR_ACORDADO_CON_DESCUENTO_POR_RETRASO=180.0;
    private final static Double VALOR_ACORDADO_GRATIS =0.0;

    @Before
    public void setup() throws Exception{
        repositorioCita = Mockito.mock(RepositorioCita.class);
        servicioActualizarCita = new ServicioActualizarCita(repositorioCita);
    }


    @Test
    public void valorAcordadoDespuesDeTerminarLaCitaTest(){
        Cita cita = new CitaTestDataBuilder().build();
        final ArgumentCaptor<Cita> citaCaptor = ArgumentCaptor.forClass(Cita.class);
        Mockito.when(repositorioCita.listarPorId(Mockito.anyLong())).thenReturn(new
                DtoCita(1l,
                "Esta es una descripcion",
                LocalDateTime.of(2021,4,20,10,20),
                 LocalDateTime.of(2021,4,20,11, 20 ),
                200.0,
                  1));
        servicioActualizarCita.ejecutar(cita);
        Mockito.verify(repositorioCita).actualizar(citaCaptor.capture());
        assertEquals(VALOR_ACORDADO_CON_DESCUENTO_POR_RETRASO, citaCaptor.getValue().getValorAcordado());

    }

    @Test
    public void validarValorAcordadoGratis(){
        Cita cita = new CitaTestDataBuilder().conValorAcordado(-2.0).build();
        final ArgumentCaptor<Cita> citaCaptor = ArgumentCaptor.forClass(Cita.class);
        Mockito.when(repositorioCita.listarPorId(Mockito.anyLong())).thenReturn(new
                DtoCita(1l,
                "Esta es una descripcion",
                LocalDateTime.of(2021,4,20,10,20),
                LocalDateTime.of(2021,4,21,11, 20 ),
                200.0,
                1));
        servicioActualizarCita.ejecutar(cita);
        Mockito.verify(repositorioCita).actualizar(citaCaptor.capture());
        assertEquals(VALOR_ACORDADO_GRATIS, citaCaptor.getValue().getValorAcordado());

    }

    private static void  assertEquals(double valorEsperado, double valorFinal) {
    if(valorFinal!=valorEsperado){
       throw new ExcepcionValorInvalido(valorFinal+ " Es diferente al esperado "+ valorEsperado);
   }

    }
}
