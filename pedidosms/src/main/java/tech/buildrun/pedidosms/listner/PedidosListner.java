package tech.buildrun.pedidosms.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tech.buildrun.pedidosms.listner.dto.PedidosEvent;
import tech.buildrun.pedidosms.service.PedidoService;

import static tech.buildrun.pedidosms.config.RabbitMqConfig.pedidos_created_queue;

@Component
public class PedidosListner {

    private final Logger logger = LoggerFactory.getLogger(PedidosListner.class);

    private final PedidoService pedidoService;

    public PedidosListner(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @RabbitListener(queues = pedidos_created_queue)
    public void listen(Message<PedidosEvent> message){
        logger.info("Mensagem consumida: {}", message);

        pedidoService.salvar(message.getPayload());
    }
}
