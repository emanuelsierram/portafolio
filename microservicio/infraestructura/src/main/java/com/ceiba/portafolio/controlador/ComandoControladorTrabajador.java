
package com.ceiba.portafolio.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.portafolio.comando.ComandoTrabajador;
import com.ceiba.portafolio.comando.manejador.ManejadorActualizarTrabajador;
import com.ceiba.portafolio.comando.manejador.ManejadorCrearTrabajador;
import com.ceiba.portafolio.comando.manejador.ManejadorEliminarTrabajador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/trabajadors")
@Api(tags = { "Controlador comando trabajador"})
public class ComandoControladorTrabajador {

    private final ManejadorCrearTrabajador manejadorCrearTrabajador;
	private final ManejadorEliminarTrabajador manejadorEliminarTrabajador;
	private final ManejadorActualizarTrabajador manejadorActualizarTrabajador;

    @Autowired
    public ComandoControladorTrabajador(ManejadorCrearTrabajador manejadorCrearTrabajador,
									 ManejadorEliminarTrabajador manejadorEliminarTrabajador,
									 ManejadorActualizarTrabajador manejadorActualizarTrabajador) {
        this.manejadorCrearTrabajador = manejadorCrearTrabajador;
		this.manejadorEliminarTrabajador = manejadorEliminarTrabajador;
		this.manejadorActualizarTrabajador = manejadorActualizarTrabajador;
    }

    @PostMapping
    @ApiOperation("Crear trabajador")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTrabajador comandotrabajador) {
        return manejadorCrearTrabajador.ejecutar(comandotrabajador);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar trabajador")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarTrabajador.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar trabajador")
	public void actualizar(@RequestBody ComandoTrabajador comandotrabajador, @PathVariable Long id) {
		comandotrabajador.setId(id);
		manejadorActualizarTrabajador.ejecutar(comandotrabajador);
	}


}

