package com.easycoffee.backend.coffeebean.dto;

import com.easycoffee.backend.coffeebean.entity.CoffeeBean;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CoffeeBeanResponseDto {

    private String name;


    private String note;

    private String distribution;


    public static CoffeeBeanResponseDto response(CoffeeBean coffeeBean) {
        return CoffeeBeanResponseDto.builder().
                name(coffeeBean.getName()).
                note(coffeeBean.getNote()).
                distribution(coffeeBean.getDistribution()).
                build();
    }
}
