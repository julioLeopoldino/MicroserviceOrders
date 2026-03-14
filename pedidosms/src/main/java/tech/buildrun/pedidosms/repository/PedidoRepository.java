package tech.buildrun.pedidosms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.buildrun.pedidosms.entity.PedidoEntity;

public interface PedidoRepository extends MongoRepository<PedidoEntity, Long> {
}
