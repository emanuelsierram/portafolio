package com.ceiba.portafolio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.portafolio.modelo.dto.DtoCita;
import com.ceiba.portafolio.modelo.dto.DtoTrabajador;
import com.ceiba.portafolio.modelo.entidad.Cita;
import com.ceiba.portafolio.puerto.repositorio.RepositorioCita;
import com.ceiba.portafolio.puerto.repositorio.RepositorioTrabajador;
import com.ceiba.portafolio.servicio.ServicioCrearCita;
import com.ceiba.portafolio.servicio.testdatabuilder.CitaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioCrearCitaTest {

    private RepositorioCita repositorioCita;
    private RepositorioTrabajador repositorioTrabajador;
    private ServicioCrearCita servicioCrearCita;

    private final static Double VALOR_ACORDADO_CON_DESCUENTO_POR_CREDITO=186.0;


    @Before
    public void setup() throws Exception{
        repositorioCita = Mockito.mock(RepositorioCita.class);
        repositorioTrabajador = Mockito.mock(RepositorioTrabajador.class);
        servicioCrearCita = new ServicioCrearCita(repositorioCita, repositorioTrabajador);
    }

    @Test
    public void validarIngresoDeFechas(){
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conFechas(
                LocalDateTime.of(2021,04,20,13,30),
                LocalDateTime.of(2021,04,20,11,30)
        );
        BasePrueba.assertThrows(() -> citaTestDataBuilder.build(), ExcepcionValorInvalido.class, "La fecha final no debe ser mayor a la fecha inicial");
    }

    @Test
    public void validarNoAngendarDiaSabado(){
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conFecha(
                LocalDateTime.of(2019,04,20,20,15)
        );
        BasePrueba.assertThrows(()-> citaTestDataBuilder.build(), ExcepcionValorInvalido.class,"No se puede agendar el dia sabado");
    }

    @Test
    public void validarCitaExistenciaPreviaTest() {
        // arrange
        Cita cita = new CitaTestDataBuilder().conFechas(
                LocalDateTime.of(2021,04,20,10,00),
                 LocalDateTime.of(2021,04,20,13,0)
        ).build();

        ArrayList<DtoCita> listaExistente = new ArrayList<DtoCita>(){{ add(new DtoCita(1l,
                "Esta es una descripcion",
                LocalDateTime.of(2021,04,20,12,0),
                LocalDateTime.of(2021,04,20,14, 0 ),
                200.0,
                1));}};

        Mockito.when(repositorioCita.listarPorIdTrabajador(cita.getIdTrabajador())).thenReturn(listaExistente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDuplicidad.class,"Ya existe cita en el horario establecido");
    }



    @Test
    public void validarValorAcordadoAntesDeLaCitaTest(){
        Cita cita = new CitaTestDataBuilder().build();
        final ArgumentCaptor<Cita> citaCaptor = ArgumentCaptor.forClass(Cita.class);
        Mockito.when(repositorioTrabajador.listarPorId(cita.getIdTrabajador())).thenReturn(new DtoTrabajador(
                1L,
                "Ema",
                "3122078455",
                "credito"));
         ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita, repositorioTrabajador);
         servicioCrearCita.ejecutar(cita);
         Mockito.verify(repositorioCita).crear(citaCaptor.capture());
        assertEquals(VALOR_ACORDADO_CON_DESCUENTO_POR_CREDITO, citaCaptor.getValue().getValorAcordado());
    }

    @Test
    public  void validarDuracionMinimaTest(){
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conFechas(
                LocalDateTime.of(2021,04,20,15,0),
                LocalDateTime.of(2021,04,20,15,30)
        );
        BasePrueba.assertThrows(() -> citaTestDataBuilder.build(), ExcepcionValorInvalido.class, "Cita minima de una hora");
    }

    @Test
    public void validarIntervaloDeCitaTest(){
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conFechas(
                LocalDateTime.of(2021,04,20,23,0),
                LocalDateTime.of(2021,04,21,4,0)
        );
        BasePrueba.assertThrows(() -> citaTestDataBuilder.build(), ExcepcionValorInvalido.class, "horario tomado no se encuentra en el horario establecido: 6:00 am - 10:00pm");
    }




}