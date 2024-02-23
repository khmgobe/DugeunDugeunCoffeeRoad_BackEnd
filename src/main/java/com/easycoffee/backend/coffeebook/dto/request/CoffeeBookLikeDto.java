package com.easycoffee.backend.coffeebook.dto.request;

import com.easycoffee.backend.coffeebook.entity.CoffeeBookLike;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CoffeeBookLikeDto(Long id, CoffeeBookDto coffeeBookDto, LocalDateTime create_at, LocalDateTime update_at) {

    public static CoffeeBookLikeDto of(CoffeeBookLike coffeeBookLike) {
        return CoffeeBookLikeDto.builder().
                id(coffeeBookLike.getId()).
                coffeeBookDto(coffeeBookLike.getCoffeeBook().toBasicDto()).
                create_at(coffeeBookLike.getCreateDate()).
                update_at(coffeeBookLike.getUpdateDate()).
                build();
    }

    public  CoffeeBookLike toEntity() {
        return CoffeeBookLike.builder().coffeeBook(coffeeBookDto().toEntity()).build();
    }
}
