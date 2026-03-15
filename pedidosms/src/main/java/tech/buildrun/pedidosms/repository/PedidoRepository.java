package tech.buildrun.pedidosms.repository;

import com.fasterxml.jackson.datatype.jdk8.WrappedIOException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import tech.buildrun.pedidosms.controller.dto.PedidoResponse;
import tech.buildrun.pedidosms.entity.PedidoEntity;

public interface PedidoRepository extends MongoRepository<PedidoEntity, Long> {

    Page<PedidoEntity> findAllByClienteId(Long clienteId, PageRequest pageResquest);
}
