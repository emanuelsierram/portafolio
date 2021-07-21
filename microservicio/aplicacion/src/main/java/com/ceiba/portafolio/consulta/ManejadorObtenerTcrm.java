package com.ceiba.portafolio.consulta;


import com.ceiba.portafolio.modelo.dto.DtoTcrm;
import com.ceiba.portafolio.puerto.api.soap.SoapTcrm;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerTcrm {

    private final SoapTcrm soapTcrm;

    public ManejadorObtenerTcrm(SoapTcrm soapTcrm) {
        this.soapTcrm = soapTcrm;
    }

    public DtoTcrm ejecutar(){
        return this.soapTcrm.obtenerTcrm();
    }
}
