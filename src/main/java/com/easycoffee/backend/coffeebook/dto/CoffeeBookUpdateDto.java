package com.easycoffee.backend.coffeebook.dto;

import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.enumeration.BookType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

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

    @CreatedDate
    private LocalDateTime create_at;

    @LastModifiedDate
    private LocalDateTime update_at;


    public CoffeeBook toEntity() {
        return CoffeeBook.builder().
                title(title).
                content(content).
                bookType(bookType).
                create_at(create_at).
                update_at(update_at).
                build();
    }
}
