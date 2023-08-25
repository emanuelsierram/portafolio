package com.ceiba.portafolio.consulta;


import com.ceiba.portafolio.modelo.dto.DtoTcrm;
import com.ceiba.portafolio.servicio.ServicioObtenerTcrm;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerTcrm {

    private final ServicioObtenerTcrm servicioObtenerTcrm;

    public ManejadorObtenerTcrm(ServicioObtenerTcrm servicioObtenerTcrm) {
        this.servicioObtenerTcrm = servicioObtenerTcrm;
    }


    public DtoTcrm ejecutar(){
        return this.servicioObtenerTcrm.ejecutar();
    }
}
