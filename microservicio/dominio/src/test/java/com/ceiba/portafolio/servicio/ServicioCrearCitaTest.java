package com.ceiba.portafolio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.portafolio.modelo.dto.DtoTrabajador;
import com.ceiba.portafolio.modelo.entidad.Cita;
import com.ceiba.portafolio.puerto.repositorio.RepositorioCita;
import com.ceiba.portafolio.puerto.repositorio.RepositorioTrabajador;
import com.ceiba.portafolio.servicio.ServicioCrearCita;
import com.ceiba.trabajador.servicio.testdatabuilder.CitaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioCrearCitaTest {

    private RepositorioCita repositorioCita;
    private RepositorioTrabajador repositorioTrabajador;
    private ServicioCrearCita servicioCrearCita;


    @Before
    public void setup() throws Exception{
        repositorioCita = Mockito.mock(RepositorioCita.class);
        repositorioTrabajador = Mockito.mock(RepositorioTrabajador.class);
        servicioCrearCita = new ServicioCrearCita(repositorioCita, repositorioTrabajador);
    }

    @Test
    public void validarCitaExistenciaPreviaTest() {
        // arrange
        Cita cita = new CitaTestDataBuilder().build();
        Mockito.when(repositorioCita.existe(cita.getFechaInicio())).thenReturn(true);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDuplicidad.class,"Ya existe cita en el horario establecido");
    }

    @Test
    public void validarValorAcordadoAntesDeLaCitaTest(){
        Cita cita = new CitaTestDataBuilder().build();
        Mockito.when(repositorioTrabajador.listarPorId(cita.getIdTrabajador())).thenReturn(new DtoTrabajador(
                1L,
                "Ema",
                "3122078455",
                "Crédito"));
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita, repositorioTrabajador);
        assertEquals(cita.getValorAcordado()-(cita.getValorAcordado()*0.07), servicioCrearCita.valorAcordadoPorMetodoDePago(cita));
    }

    @Test
    public  void validarDuracionMinimaTest(){
        Cita cita = new CitaTestDataBuilder().conFechas(
                LocalDateTime.of(2021,04,20,15,00),
                LocalDateTime.of(2021,04,20,15,30)).build();
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionValorInvalido.class, "Cita minima de una hora");
    }

    @Test
    public void validarIntervaloTest(){
        Cita cita = new CitaTestDataBuilder().conFechas(
                LocalDateTime.of(2021,04,20,05,00),
                LocalDateTime.of(2021,04,20,23,30)).build();
        BasePrueba.assertThrows(()-> servicioCrearCita.ejecutar(cita), ExcepcionValorInvalido.class, "horario tomado no se encuentra en el horario establecido: 6:00 am - 10:00pm");
    }




}