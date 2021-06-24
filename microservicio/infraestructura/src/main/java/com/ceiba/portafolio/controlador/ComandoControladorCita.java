

package com.ceiba.portafolio.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.portafolio.comando.ComandoCita;
import com.ceiba.portafolio.comando.manejador.ManejadorActualizarCita;
import com.ceiba.portafolio.comando.manejador.ManejadorCrearCita;
import com.ceiba.portafolio.comando.manejador.ManejadorEliminarCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/citas")
@Api(tags = { "Controlador comando citas"})
public class ComandoControladorCita {

    private final ManejadorCrearCita manejadorCrearCita;
    private final ManejadorActualizarCita manejadorActualizarCita;
    private final ManejadorEliminarCita manejadorEliminarCita;

    @Autowired
    public ComandoControladorCita(ManejadorCrearCita manejadorCrearCita, ManejadorActualizarCita manejadorActualizarCita, ManejadorEliminarCita manejadorEliminarCita) {
        this.manejadorCrearCita = manejadorCrearCita;
        this.manejadorActualizarCita = manejadorActualizarCita;
        this.manejadorEliminarCita = manejadorEliminarCita;
    }

    @PostMapping
    @ApiOperation("Crear cita")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCita comandoCita) {
        return manejadorCrearCita.ejecutar(comandoCita);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Cita")
    public void actualizar(@RequestBody ComandoCita comandoCita, @PathVariable Long id) {
        comandoCita.setId(id);
        manejadorActualizarCita.ejecutar(comandoCita);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar cita")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarCita.ejecutar(id);
    }



}





