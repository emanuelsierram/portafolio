package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.dto.DtoCita;
import com.ceiba.usuario.modelo.entidad.Cita;
import com.ceiba.usuario.puerto.dao.DaoCita;
import com.ceiba.usuario.puerto.repositorio.RepositorioCita;
import com.ceiba.usuario.servicio.testdatabuilder.CitaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ServicioActualizarCitaTest {


    @Test
    public void valorAcordadoDespuesDeTerminarLaCitaTest(){
        Cita cita = new CitaTestDataBuilder().build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        DaoCita daoCita = Mockito.mock(DaoCita.class);
        Mockito.when(daoCita.listarPorId(Mockito.anyLong())).thenReturn(new
                DtoCita(1l,
                "Esta es una descripcion",
                LocalDateTime.of(2021,04,20,10,20),
                 LocalDateTime.of(2021,04,20,11, 20 ),
                200.0,
                 "Credito"));
        ServicioActualizarCita servicioActualizarCita = new ServicioActualizarCita(repositorioCita, daoCita);
        double valorEsperado=200.0-(200.0*0.10);
        assertEquals(valorEsperado, servicioActualizarCita.valorAcordadoDespuesDeTerminarLaCita(cita));

    }

    private static void  assertEquals(double valorEsperado, double valorFinal) {

   if(valorFinal!=valorEsperado){
       throw new ExcepcionValorInvalido(valorFinal+ " Es diferente al esperado "+ valorEsperado);
   }


    }
}
