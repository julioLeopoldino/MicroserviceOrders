package tech.buildrun.pedidosms.service;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import tech.buildrun.pedidosms.entity.ItemPedido;
import tech.buildrun.pedidosms.entity.PedidoEntity;
import tech.buildrun.pedidosms.listner.dto.ItemEvent;
import tech.buildrun.pedidosms.listner.dto.PedidosEvent;
import tech.buildrun.pedidosms.repository.PedidoRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;


    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void salvar(PedidosEvent event){
        var entity = new PedidoEntity();
        entity.setPedidoId(event.codigoPedido());
        entity.setClienteId(event.codigoCliente());
        entity.setItens(getItemPedido(event));
        entity.setTotal(geTotal(event));

        pedidoRepository.save(entity);
    }

    private static List<ItemPedido> getItemPedido(PedidosEvent event) {
        return event.itens().stream()
                .map(a -> new ItemPedido(a.produto(),  a.quantidade(), a.preco())).toList();
    }

    private BigDecimal geTotal(PedidosEvent event) {
        return event.itens()
                .stream()
                .map(a -> a.preco().multiply(BigDecimal.valueOf(a.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
