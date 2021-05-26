package com.ceiba.portafolio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.portafolio.modelo.entidad.Trabajador;
import com.ceiba.portafolio.puerto.repositorio.RepositorioTrabajador;
import com.ceiba.portafolio.servicio.testdatabuilder.TrabajadorTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioCrearTrabajadorTest {

   

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Trabajador trabajador = new TrabajadorTestDataBuilder().build();
        RepositorioTrabajador repositorioTrabajador = Mockito.mock(RepositorioTrabajador.class);
        Mockito.when(repositorioTrabajador.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearTrabajador servicioCrearUsuario = new ServicioCrearTrabajador(repositorioTrabajador);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(trabajador), ExcepcionDuplicidad.class,"El trabajador ya existe en el sistema");
    }
}
