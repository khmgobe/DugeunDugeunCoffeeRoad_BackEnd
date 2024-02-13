package com.easycoffee.backend.coffeebook.dto.request;

import com.easycoffee.backend.coffee.dto.CoffeeSaveDto;
import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.enumeration.Category;
import lombok.Builder;

@Builder
public record CoffeeBookUpdateDto (Long id, String title, String content, Category category, Boolean deleted, CoffeeSaveDto coffeeSaveDto){

    public CoffeeBook toEntity() {
        return CoffeeBook.builder().
                id(id).
                title(title).
                content(content).
                category(category).
                build();
    }
}
