package tech.buildrun.pedidosms.listner.dto;

import java.math.BigDecimal;

public record ItemEvent(String produto,
                        Integer quantidade,
                        BigDecimal preco) {
}
