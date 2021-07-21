package com.ceiba.portafolio.controlador;

import com.ceiba.portafolio.consulta.ManejadorObtenerTcrm;
import com.ceiba.portafolio.modelo.dto.DtoTcrm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tcrm")
@Api(tags = { "Controlador comando TCRM"})
public class ConsultaControladorTcrm {

    private final ManejadorObtenerTcrm manejadorObtenerTcrm;

    public ConsultaControladorTcrm(ManejadorObtenerTcrm manejadorObtenerTcrm) {
        this.manejadorObtenerTcrm = manejadorObtenerTcrm;
    }

    @GetMapping
    @ApiOperation("Obtener TCRM")
    public DtoTcrm obtener(){
        return manejadorObtenerTcrm.ejecutar();
    }
}
