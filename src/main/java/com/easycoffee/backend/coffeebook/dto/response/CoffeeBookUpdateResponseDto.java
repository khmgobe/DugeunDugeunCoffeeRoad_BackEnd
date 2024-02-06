package com.easycoffee.backend.coffeebook.dto.response;

import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.enumeration.Category;
import com.easycoffee.backend.common.util.ListConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class CoffeeBookUpdateResponseDto {

    private Long id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private Category category;

    private LocalDateTime updateDate;


    public static CoffeeBookUpdateResponseDto response(CoffeeBook coffeeBook) {
        return CoffeeBookUpdateResponseDto.builder().
                id(coffeeBook.getId()).
                title(coffeeBook.getTitle()).
                content(coffeeBook.getContent()).
                category(coffeeBook.getCategory()).
                updateDate(coffeeBook.getUpdateDate()).
                build();
    }
}
