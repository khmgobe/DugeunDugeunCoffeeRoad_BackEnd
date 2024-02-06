package com.easycoffee.backend.coffeebean.dto;

import com.easycoffee.backend.coffee.entity.Coffee;
import com.easycoffee.backend.coffee.enumeration.BeverageType;
import com.easycoffee.backend.coffee.enumeration.SensationType;
import com.easycoffee.backend.coffeebean.entity.CoffeeBean;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CoffeeBeanResponseDto {


    private Long id;

    private String name;

    private String country;

    private String variety;

    private String note;

    private String distribution;


    public static CoffeeBeanResponseDto response(CoffeeBean coffeeBean) {
        return CoffeeBeanResponseDto.builder().
                id(coffeeBean.getId()).
                name(coffeeBean.getName()).
                country(coffeeBean.getCountry()).
                variety(coffeeBean.getVariety()).
                note(coffeeBean.getNote()).
                distribution(coffeeBean.getDistribution()).
                build();
    }
}
