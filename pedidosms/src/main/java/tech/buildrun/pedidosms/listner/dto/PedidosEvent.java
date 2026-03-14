package tech.buildrun.pedidosms.listner.dto;

import java.math.BigDecimal;
import java.util.List;

public record PedidosEvent(Long codigoPedido,
                           Long codigoCliente,
                           List<ItemEvent> itens) {
}
