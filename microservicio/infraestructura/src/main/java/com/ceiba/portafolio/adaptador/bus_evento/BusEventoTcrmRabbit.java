package com.ceiba.portafolio.adaptador.bus_evento;

import com.ceiba.portafolio.modelo.dto.DtoTcrm;
import com.ceiba.portafolio.puerto.bus_evento.BusEventoTcrm;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class BusEventoTcrmRabbit implements BusEventoTcrm {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void enviar(DtoTcrm dtoTcrm) {
        System.out.println(rabbitTemplate);
        rabbitTemplate.convertAndSend(queue.getName(),dtoTcrm);
    }
}
