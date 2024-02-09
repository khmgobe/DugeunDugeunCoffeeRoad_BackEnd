package com.easycoffee.backend.coffeebook.dto.request;

import com.easycoffee.backend.coffee.dto.CoffeeUpdateDto;
import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.enumeration.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class CoffeeBookUpdateDto {

    private Long id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private Category category;

    public CoffeeBook toEntity() {
        return CoffeeBook.builder().
                id(id).
                title(title).
                content(content).
                category(category).
                build();
    }

    public void updateBook(CoffeeBookUpdateDto coffeeBookUpdateDto) {
        this.title = coffeeBookUpdateDto.getTitle();
        this.content = coffeeBookUpdateDto.getContent();
        this.category = coffeeBookUpdateDto.getCategory();
    }
}
