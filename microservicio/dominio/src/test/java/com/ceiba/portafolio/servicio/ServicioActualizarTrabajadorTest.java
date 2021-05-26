package com.ceiba.portafolio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.portafolio.modelo.entidad.Trabajador;
import com.ceiba.portafolio.puerto.repositorio.RepositorioTrabajador;
import com.ceiba.portafolio.servicio.testdatabuilder.TrabajadorTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioActualizarTrabajadorTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Trabajador trabajador = new TrabajadorTestDataBuilder().conId(2L).build();
        RepositorioTrabajador repositorioTrabajador = Mockito.mock(RepositorioTrabajador.class);
        Mockito.when(repositorioTrabajador.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarTrabajador servicioActualizarTrabajador = new ServicioActualizarTrabajador(repositorioTrabajador);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarTrabajador.ejecutar(trabajador), ExcepcionDuplicidad.class,"El trabajador ya existe en el sistema");
    }
}
