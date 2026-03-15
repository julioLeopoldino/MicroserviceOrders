package tech.buildrun.pedidosms.controller.dto;

import java.util.List;

public record ApiResponse<T>(List<T> data, PaginationReponse pagination) {
}
