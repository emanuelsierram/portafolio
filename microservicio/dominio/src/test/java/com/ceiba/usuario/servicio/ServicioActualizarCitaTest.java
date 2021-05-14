/*package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Cita;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioCita;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarCitaTest {

    @Test
    public void validarCitaExistenciaPreviaTest() {
        // arrange
        Cita cita = new CitaTestDataBuilder().conId(1L).build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarCita servicioActualizarCita = new ServicioActualizarCita(repositorioCita);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCita.ejecutar(cita), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }
}
*/