package com.easycoffee.backend.coffeebook.dto.response;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder

public class CoffeeBookDeleteResponseDto {

    private Long id;

    public static CoffeeBookDeleteResponseDto deleteResponse(Long id) {
        return CoffeeBookDeleteResponseDto.builder().id(id).build();
    }
}
