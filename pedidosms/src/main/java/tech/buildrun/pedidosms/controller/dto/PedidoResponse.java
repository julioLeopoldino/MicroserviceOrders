package tech.buildrun.pedidosms.controller.dto;

import tech.buildrun.pedidosms.entity.PedidoEntity;

import java.math.BigDecimal;

public record PedidoResponse(Long pedidoId, Long clienteId, BigDecimal total) {


    public static PedidoResponse fromEntity(PedidoEntity entity){
        return new PedidoResponse(entity.getPedidoId(), entity.getClienteId(), entity.getTotal());
    }
}
