package com.ceiba.portafolio.adaptador.api.soap;

import com.ceiba.infraestructura.api.soap.ConsumerSoap;
import com.ceiba.portafolio.modelo.dto.DtoTcrm;
import com.ceiba.portafolio.puerto.api.soap.SoapTcrm;
import jdk.internal.net.http.common.FlowTube;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        Float value = Float.parseFloat(xml.substring(posicionValue+6,posicionValue+13));
        return new DtoTcrm(unit, value);
    }


}