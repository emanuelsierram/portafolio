package com.ceiba.portafolio.servicio;


import com.ceiba.portafolio.modelo.dto.DtoTcrm;
import com.ceiba.portafolio.puerto.api.soap.SoapTcrm;
import com.ceiba.portafolio.puerto.bus_evento.BusEventoTcrm;



public class ServicioObtenerTcrm {

    private final BusEventoTcrm busEventoTcrm;
    private final SoapTcrm soapTcrm;


    public ServicioObtenerTcrm(BusEventoTcrm busEventoTcrm, SoapTcrm soapTcrm) {
        this.busEventoTcrm = busEventoTcrm;
        this.soapTcrm = soapTcrm;
    }

    public DtoTcrm ejecutar(){
        this.busEventoTcrm.enviar(this.soapTcrm.obtenerTcrm());
        return this.soapTcrm.obtenerTcrm();
    }
}
