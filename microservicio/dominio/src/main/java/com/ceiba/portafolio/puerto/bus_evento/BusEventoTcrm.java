package com.ceiba.portafolio.puerto.bus_evento;

import com.ceiba.portafolio.modelo.dto.DtoTcrm;


public interface BusEventoTcrm {
    void enviar(DtoTcrm dtoTcrm);
}
