

package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoCita;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarCita;
import com.ceiba.usuario.comando.manejador.ManejadorCrearCita;
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

    @Autowired
    public ComandoControladorCita(ManejadorCrearCita ManejadorCrearCita, ManejadorActualizarCita manejadorActualizarCita) {
        this.manejadorCrearCita = ManejadorCrearCita;
       this.manejadorActualizarCita = manejadorActualizarCita;
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


}





