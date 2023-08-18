package com.ceiba.portafolio.adaptador.api.soap;
import com.ceiba.infraestructura.api.soap.ConsumerSoap;
import com.ceiba.portafolio.modelo.dto.DtoTcrm;
import com.ceiba.portafolio.puerto.api.soap.SoapTcrm;
import org.springframework.stereotype.Component;


@Component
public class SoapTcrmXML implements SoapTcrm {

    private final ConsumerSoap consumerSoap;

    public SoapTcrmXML(ConsumerSoap consumerSoap) {
        this.consumerSoap = consumerSoap;
    }

    @Override
    public DtoTcrm obtenerTcrm() {
        String xml=consumerSoap.obtener();
        int posicionUnit = xml.indexOf("unit");
        String unit = xml.substring(posicionUnit+5,posicionUnit+8);
        int posicionValue = xml.indexOf("value");
        Float value = Float.parseFloat(xml.substring(posicionValue+6,posicionValue+12));
        return new DtoTcrm(unit, value);
    }


}