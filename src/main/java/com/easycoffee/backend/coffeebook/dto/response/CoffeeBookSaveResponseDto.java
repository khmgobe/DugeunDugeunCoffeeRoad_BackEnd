package com.easycoffee.backend.coffeebook.dto.response;

import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.enumeration.BookType;
import com.easycoffee.backend.common.util.ListConverter;
import jakarta.persistence.Convert;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class CoffeeBookSaveResponseDto {

    private Long id;
    private String title;
    private String content;
    private BookType bookType;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @Convert(converter = ListConverter.class)
    private List<String> flavor;

    public static CoffeeBookSaveResponseDto response(CoffeeBook coffeeBook) {
        return CoffeeBookSaveResponseDto.builder().
                id(coffeeBook.getId()).
                title(coffeeBook.getTitle()).
                content(coffeeBook.getContent()).
                bookType(coffeeBook.getBookType()).
                createDate(coffeeBook.getCreateDate()).
                flavor(coffeeBook.getFlavor()).build();
    }
}
