package com.easycoffee.backend.coffeebook.dto.request;

import com.easycoffee.backend.coffee.dto.CoffeeSaveDto;
import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.enumeration.Category;
import lombok.*;

@Builder
public record CoffeeBookSaveDto (Long id, String title, String content, Category category, Boolean deleted, CoffeeSaveDto coffeeSaveDto){

    public CoffeeBook toEntity() {
        return CoffeeBook.builder().
                title(title).
                content(content).
                category(category).
                deleted(false).
                coffee(coffeeSaveDto.toEntity()).
                build();
    }
}
