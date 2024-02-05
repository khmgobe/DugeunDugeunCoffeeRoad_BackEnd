package com.easycoffee.backend.coffeebook.dto.request;

import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.enumeration.BookType;
import com.easycoffee.backend.common.util.ListConverter;
import jakarta.persistence.Convert;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class CoffeeBookSaveDto {


    private Long id;

    private String title;

    private String content;

    private BookType bookType;

    @Convert(converter = ListConverter.class)
    private List<String> flavor;

    private LocalDateTime create_at;

    public CoffeeBook toEntity() {
        return CoffeeBook.builder().
                title(title).
                content(content).
                bookType(bookType).
                flavor(flavor).
                create_at(create_at).
                build();
    }
}
