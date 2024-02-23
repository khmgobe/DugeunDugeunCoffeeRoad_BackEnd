package com.easycoffee.backend.coffeebook.dto.response;

import com.easycoffee.backend.coffeebook.entity.CoffeeBookLike;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CoffeeBookLikeResponseDto(Long id, LocalDateTime create_at, LocalDateTime update_at) {

    public static CoffeeBookLikeResponseDto response(CoffeeBookLike coffeeBookLike) {
        return CoffeeBookLikeResponseDto.builder().
                id(coffeeBookLike.getId()).
                create_at(coffeeBookLike.getCreateDate()).
                update_at(coffeeBookLike.getUpdateDate()).
                build();
    }
}
