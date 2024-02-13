package com.easycoffee.backend.coffeebook.dto.response;

import com.easycoffee.backend.common.enumeration.CommonResponseType;
import lombok.Builder;
import java.time.LocalDateTime;


@Builder

public record CoffeeBookDeleteResponseDto<T>(Long id, T httpStatus, String description, LocalDateTime delete_at) {

    public static CoffeeBookDeleteResponseDto deleteResponse(Long id) {
        return CoffeeBookDeleteResponseDto.builder().
                id(id).
                httpStatus(CommonResponseType.SUCCESS.getHttpStatus()).
                description(CommonResponseType.SUCCESS.getDescription()).
                delete_at(LocalDateTime.now()).build();
    }
}
