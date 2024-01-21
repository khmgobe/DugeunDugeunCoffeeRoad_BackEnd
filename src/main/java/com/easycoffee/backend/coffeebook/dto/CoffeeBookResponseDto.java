package com.easycoffee.backend.coffeebook.dto;

import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.enumeration.BookType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CoffeeBookResponseDto {

    private Long id;
    private String title;
    private String content;
    private BookType bookType;
    private LocalDateTime create_at;
    private LocalDateTime update_at;

    public static CoffeeBookResponseDto response(CoffeeBook coffeeBook) {
        return CoffeeBookResponseDto.builder().
                id(coffeeBook.getId()).
                title(coffeeBook.getTitle()).
                content(coffeeBook.getContent()).
                bookType(coffeeBook.getBookType()).
                create_at(coffeeBook.getCreate_at()).
                update_at(coffeeBook.getUpdate_at()).
                build();
    }
}
