
package com.ceiba.portafolio.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.portafolio.comando.ComandoTrabajador;
import com.ceiba.portafolio.comando.manejador.ManejadorActualizarTrabajador;
import com.ceiba.portafolio.comando.manejador.ManejadorCrearTrabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/trabajadores")
@Api(tags = { "Controlador comando trabajador"})
public class ComandoControladorTrabajador {

    private final ManejadorCrearTrabajador manejadorCrearTrabajador;
	private final ManejadorActualizarTrabajador manejadorActualizarTrabajador;

    @Autowired
    public ComandoControladorTrabajador(ManejadorCrearTrabajador manejadorCrearTrabajador, ManejadorActualizarTrabajador manejadorActualizarTrabajador) {
        this.manejadorCrearTrabajador = manejadorCrearTrabajador;
		this.manejadorActualizarTrabajador = manejadorActualizarTrabajador;
    }

    @PostMapping
    @ApiOperation("Crear trabajador")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTrabajador comandotrabajador) {
        return manejadorCrearTrabajador.ejecutar(comandotrabajador);
    }


	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar trabajador")
	public void actualizar(@RequestBody ComandoTrabajador comandotrabajador, @PathVariable Long id) {
		comandotrabajador.setId(id);
		manejadorActualizarTrabajador.ejecutar(comandotrabajador);
	}


}

