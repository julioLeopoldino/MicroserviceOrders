package tech.buildrun.pedidosms.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import tech.buildrun.pedidosms.controller.dto.PedidoResponse;
import tech.buildrun.pedidosms.entity.ItemPedido;
import tech.buildrun.pedidosms.entity.PedidoEntity;
import tech.buildrun.pedidosms.listner.dto.PedidosEvent;
import tech.buildrun.pedidosms.repository.PedidoRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class PedidoService {

    private static PedidoRepository pedidoRepository;


    public PedidoService(PedidoRepository pedidoRepository,
                         MongoTemplate mongoTemplate) {
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

    public static Page<PedidoResponse> buscaPedidosClienteId(Long clienteId, PageRequest pageResquest){
        var pedidos = pedidoRepository.findAllByClienteId(clienteId, pageResquest);

        return pedidos.map(PedidoResponse::fromEntity);
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
