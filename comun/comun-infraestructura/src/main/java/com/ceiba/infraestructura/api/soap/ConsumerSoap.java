package com.ceiba.infraestructura.api.soap;

import com.ceiba.infraestructura.excepcion.ExcepcionTecnica;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class ConsumerSoap {

    private static final String URL="https://www.superfinanciera.gov.co/SuperfinancieraWebServiceTRM/TCRMServicesWebService/TCRMServicesWebService";
    private static final String ERROR_OBTENIENDO_EL_NOMBRE_Y_VALOR_DE_OBJETO = "Error obteniendo el nombre y valor de objeto";
    public String obtener(){
        try {
            URL obj = new URL(this.URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "text/xml"); //charset=utf-8
            String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                    "xmlns:act=\"http://action.trm.services.generic.action.superfinanciera.nexura.sc.com.co/\">\n" +
                    "<soapenv:Header/>\n" +
                    "<soapenv:Body>\n" +
                    "<act:queryTCRM>\n" +
                    "</act:queryTCRM>\n" +
                    "</soapenv:Body>\n" +
                    "</soapenv:Envelope>";
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(xml);
            wr.flush();
            wr.close();
           // String responseStatus = con.getResponseMessage();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
           // System.out.println("response:" + response.toString());
            return response.toString();
        } catch (Exception e) {
            throw new ExcepcionTecnica(ERROR_OBTENIENDO_EL_NOMBRE_Y_VALOR_DE_OBJETO, e);
        }
    }
}
