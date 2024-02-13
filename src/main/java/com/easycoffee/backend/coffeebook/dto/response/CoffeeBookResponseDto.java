package com.easycoffee.backend.coffeebook.dto.response;

import com.easycoffee.backend.coffee.dto.CoffeeResponseDto;
import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.enumeration.Category;
import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record CoffeeBookResponseDto(Long id, String title, String content, Category category, LocalDateTime create_date, LocalDateTime update_date, Boolean deleted, CoffeeResponseDto coffeeResponseDto) {

    public static CoffeeBookResponseDto response(CoffeeBook coffeeBook) {
        return CoffeeBookResponseDto.builder().
                id(coffeeBook.getId()).
                title(coffeeBook.getTitle()).
                content(coffeeBook.getContent()).
                category(coffeeBook.getCategory()).
                create_date(coffeeBook.getCreateDate()).
                update_date(coffeeBook.getUpdateDate()).
                deleted(coffeeBook.getDeleted()).
                coffeeResponseDto(coffeeBook.getCoffee().toDto()).
                build();
    }
}
