package com.easycoffee.backend.coffeebook.dto.request;

import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.enumeration.BookType;
import com.easycoffee.backend.common.util.ListConverter;
import jakarta.persistence.Convert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class CoffeeBookUpdateDto {

    private Long id;

    private String title;

    private String content;

    private BookType bookType;

    @Convert(converter = ListConverter.class)
    private List<String> flavor;


    public CoffeeBook toEntity() {
        return CoffeeBook.builder().
                title(title).
                content(content).
                bookType(bookType).
                build();
    }
}
