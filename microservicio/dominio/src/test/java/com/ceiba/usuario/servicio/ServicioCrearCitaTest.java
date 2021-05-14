package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Cita;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioCita;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearCitaTest {


  /*  @Test
    public void validarClaveLongitudMenor4Test() {
        // arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conTelefono("124");
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }
*/




    @Test
    public void validarCitaExistenciaPreviaTest() {
        // arrange
        Cita cita = new CitaTestDataBuilder().build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);

        Mockito.when(repositorioCita.existe(cita.getDescripcion())).thenReturn(true);
      ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);

        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDuplicidad.class,"La cita ya existe en el sistema");
    }





}
