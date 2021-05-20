package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.entidad.Cita;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioCita;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioCrearCitaTest {

    @Test
    public void validarAgendamientoDiaSabado(){
    Cita cita = new CitaTestDataBuilder().conFecha(LocalDateTime.of(2019,04,20,10,00)).build();
    RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
    ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
    BasePrueba.assertThrows(() -> servicioCrearCita.ValidarNoAgendarDiaSabado(cita.getFechaInicio()), ExcepcionValorInvalido.class, "No se puede agendar el dia sabado");
    }


    @Test
    public void validarCitaExistenciaPreviaTest() {
        // arrange
       Cita usuario = new CitaTestDataBuilder().build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existe(usuario.getFechaInicio())).thenReturn(true);
        ServicioCrearCita servicioCrearUsuario = new ServicioCrearCita(repositorioCita);
        // act - assert

        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"Ya existe cita en el horario establecido");
    }

    @Test
    public void validarValorAcordadoAntesDeLaCitaTest(){
        Cita cita = new CitaTestDataBuilder().build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
       ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        assertEquals(cita.getValorAcordado()-(cita.getValorAcordado()*0.07), servicioCrearCita.valorAcordadoPorMetodoDePago(cita));
    }

    @Test
    public  void validarDuracionMinimaTest(){
        Cita cita = new CitaTestDataBuilder().conFechas(
                LocalDateTime.of(2021,04,20,15,00),
                LocalDateTime.of(2021,04,20,15,30)).build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        BasePrueba.assertThrows(() -> servicioCrearCita.validarDuracionMinima(cita.getFechaInicio(), cita.getFechaFinal()), ExcepcionValorInvalido.class, "Cita minima de una hora");

    }

    @Test
    public void validarIntervaloTest(){
        Cita cita = new CitaTestDataBuilder().conFechas(
                LocalDateTime.of(2021,04,20,05,00),
                LocalDateTime.of(2021,04,20,23,30)).build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);

        BasePrueba.assertThrows(()-> servicioCrearCita.validarIntervalo(cita.getFechaInicio(), cita.getFechaFinal()), ExcepcionValorInvalido.class, "horario tomado no se encuentra en el horario establecido: 6:00 am - 10:00pm");


    }




}