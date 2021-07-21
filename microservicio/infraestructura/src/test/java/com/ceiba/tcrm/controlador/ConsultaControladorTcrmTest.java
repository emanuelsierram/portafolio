package com.ceiba.tcrm.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.portafolio.controlador.ConsultaControladorTrabajador;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorTrabajador.class)
public class ConsultaControladorTcrmTest {

    @Autowired
    private MockMvc mocMvc;



    @Test
    public void obtenerTcrmTest() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform( MockMvcRequestBuilders
                .get("/tcrm")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.unidad").value("COP"));
    }



}
