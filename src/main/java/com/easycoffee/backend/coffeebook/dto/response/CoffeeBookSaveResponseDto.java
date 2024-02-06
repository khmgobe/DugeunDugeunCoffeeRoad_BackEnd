package com.easycoffee.backend.coffeebook.dto.response;

import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.enumeration.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CoffeeBookSaveResponseDto {

    private Long id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private Category category;

    private LocalDateTime create_date;

    private LocalDateTime update_date;


    public static CoffeeBookSaveResponseDto response(CoffeeBook coffeeBook) {
        return CoffeeBookSaveResponseDto.builder().
                id(coffeeBook.getId()).
                title(coffeeBook.getTitle()).
                content(coffeeBook.getContent()).
                category(coffeeBook.getCategory()).
                create_date(coffeeBook.getCreateDate()).
                update_date(coffeeBook.getUpdateDate()).
                build();
    }
}
