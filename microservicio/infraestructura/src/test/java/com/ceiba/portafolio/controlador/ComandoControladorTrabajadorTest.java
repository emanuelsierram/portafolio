package com.ceiba.portafolio.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.portafolio.comando.ComandoTrabajador;
import com.ceiba.portafolio.servicio.testdatabuilder.ComandoTrabajadorTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoTrabajador.class)
public class ComandoControladorTrabajadorTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crearTrabajadorTest() throws Exception{
        // arrange
        ComandoTrabajador trabajador = new ComandoTrabajadorTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/trabajadores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(trabajador)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

    @Test
    public void actualizarTrabajadorTest() throws Exception{
        // arrange
        Long id = 2L;
        ComandoTrabajador trabajador = new ComandoTrabajadorTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/trabajadores/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(trabajador)))
                .andExpect(status().isOk());
    }


}
