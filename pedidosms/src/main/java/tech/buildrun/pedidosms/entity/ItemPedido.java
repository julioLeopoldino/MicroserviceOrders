package tech.buildrun.pedidosms.entity;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

public class ItemPedido {

    private String produto;
    private Integer qtd;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal preco;

    public ItemPedido() {
    }

    public ItemPedido(String produto, Integer quantidade, BigDecimal preco) {
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
