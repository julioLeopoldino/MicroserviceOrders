package tech.buildrun.pedidosms.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.buildrun.pedidosms.controller.dto.ApiResponse;
import tech.buildrun.pedidosms.controller.dto.PaginationReponse;
import tech.buildrun.pedidosms.controller.dto.PedidoResponse;
import tech.buildrun.pedidosms.service.PedidoService;

@RestController
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/clientes/{clienteId}/pedidos")
    public ResponseEntity<ApiResponse<PedidoResponse>> listPedidos(@PathVariable("clienteId") Long clienteId, @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize){

        var pageResponse = PedidoService.buscaPedidosClienteId(clienteId, PageRequest.of(page, pageSize));
        return ResponseEntity.ok(new ApiResponse<>(
                pageResponse.getContent(),
                PaginationReponse.fromPage(pageResponse)

        ));
    }
}
