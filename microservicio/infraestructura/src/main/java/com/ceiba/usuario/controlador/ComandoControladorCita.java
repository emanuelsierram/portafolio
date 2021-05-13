/*

package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoCita;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearCita;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(tags = { "Controlador comando usuario"})
public class ComandoControladorCita {

    private final ManejadorCrearCita manejadorCrearCita;
    private final ManejadorEliminarUsuario manejadorEliminarUsuario;
    private final ManejadorActualizarUsuario manejadorActualizarUsuario;

    @Autowired
    public ComandoControladorCita(ManejadorCrearCita ManejadorCrearCita,
                                  ManejadorEliminarUsuario manejadorEliminarUsuario,
                                  ManejadorActualizarUsuario manejadorActualizarUsuario) {
        this.manejadorCrearCita = ManejadorCrearCita;
        this.manejadorEliminarUsuario = manejadorEliminarUsuario;
        this.manejadorActualizarUsuario = manejadorActualizarUsuario;
    }

    @PostMapping
    @ApiOperation("Crear Cita")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCita comandoCita, @PathVariable String metodo) {
       comandoCita.getUsuario().setMetodoPago(metodo);
        return manejadorCrearCita.ejecutar(comandoCita);
    }


    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Usuario")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarUsuario.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Usuario")
    public void actualizar(@RequestBody ComandoUsuario comandoUsuario,@PathVariable Long id) {
        comandoUsuario.setId(id);
        manejadorActualizarUsuario.ejecutar(comandoUsuario);
    }


}


 */