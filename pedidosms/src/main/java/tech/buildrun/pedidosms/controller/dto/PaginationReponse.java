package tech.buildrun.pedidosms.controller.dto;

import org.springframework.data.domain.Page;

public record PaginationReponse(Integer page, Integer pageSize, Long totalPedidos, Integer totalPages) {

    public static PaginationReponse fromPage(Page<?> page){
        return new PaginationReponse(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }
}
