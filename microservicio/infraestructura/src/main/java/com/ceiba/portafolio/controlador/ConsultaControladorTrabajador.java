

package com.ceiba.portafolio.controlador;

import java.util.List;

import com.ceiba.portafolio.modelo.dto.DtoTrabajador;
import com.ceiba.portafolio.consulta.ManejadorListarTrabajador;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/trabajadores")
@Api(tags={"Controlador consulta trabajador"})
public class ConsultaControladorTrabajador {

    private final ManejadorListarTrabajador manejadorListarTrabajador;

    public ConsultaControladorTrabajador(ManejadorListarTrabajador manejadorListarTrabajador) {
        this.manejadorListarTrabajador = manejadorListarTrabajador;
    }

    @GetMapping
    @ApiOperation("Listar trabajadores")
    public List<DtoTrabajador> listar() {
        return this.manejadorListarTrabajador.ejecutar();
    }

}
