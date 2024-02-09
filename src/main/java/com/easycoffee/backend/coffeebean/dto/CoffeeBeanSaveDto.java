package com.easycoffee.backend.coffeebean.dto;

import com.easycoffee.backend.coffeebean.entity.CoffeeBean;
import lombok.Getter;

@Getter
public class CoffeeBeanSaveDto {


    private Long id;

    private String name;
    private String note;

    private String distribution;


    public CoffeeBean toEntity() {
        return CoffeeBean.builder().
                name(name).
                note(note).
                distribution(distribution).
                build();
    }
}
