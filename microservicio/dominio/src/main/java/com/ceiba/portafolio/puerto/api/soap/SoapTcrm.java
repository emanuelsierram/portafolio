package com.ceiba.portafolio.puerto.api.soap;

import com.ceiba.portafolio.modelo.dto.DtoTcrm;

public interface SoapTcrm {

    /**
     * Permite obtener tcrm en cop
     * @return tcrm del día
     */
    DtoTcrm obtenerTcrm();
}
