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
    public void validarEspecificacionesDelTrabajador() {
        // arrange
        TrabajadorTestDataBuilder trabajadorTestDataBuilder = new TrabajadorTestDataBuilder().conTelefono("3017768234");
        // act - assert
        BasePrueba.assertThrows(() -> trabajadorTestDataBuilder.build(), ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }

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
