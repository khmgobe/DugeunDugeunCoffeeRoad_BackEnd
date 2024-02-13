package com.easycoffee.backend.coffeebook.dto.response;

import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.enumeration.Category;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CoffeeBookSaveResponseDto(Long id, String title, String content, Category category, Boolean deleted, LocalDateTime create_date, LocalDateTime update_date) {

    public static CoffeeBookSaveResponseDto response(CoffeeBook coffeeBook) {
        return CoffeeBookSaveResponseDto.builder().
                id(coffeeBook.getId()).
                title(coffeeBook.getTitle()).
                content(coffeeBook.getContent()).
                category(coffeeBook.getCategory()).
                deleted(false).
                create_date(coffeeBook.getCreateDate()).
                update_date(coffeeBook.getUpdateDate()).
                build();
    }
}
