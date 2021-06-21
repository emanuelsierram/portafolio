

package com.ceiba.portafolio.controlador;

import com.ceiba.portafolio.modelo.dto.DtoCita;
import com.ceiba.portafolio.consulta.ManejadorListarCitas;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
@Api(tags={"Controlador consulta cita"})
public class ConsultaControladorCita {

    private final ManejadorListarCitas manejadorListarCitas;

    public ConsultaControladorCita(ManejadorListarCitas manejadorListarCitas) {
        this.manejadorListarCitas = manejadorListarCitas;
    }

    @GetMapping("/{id}")
    @ApiOperation("Listar citas")
    public List<DtoCita> listar(@PathVariable Integer id) {
        return this.manejadorListarCitas.ejecutar(id);
    }



}
