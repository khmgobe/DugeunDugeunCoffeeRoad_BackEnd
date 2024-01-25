package com.easycoffee.backend.coffee.dto;

import com.easycoffee.backend.coffee.entity.Coffee;
import com.easycoffee.backend.coffee.enumeration.BeverageType;
import com.easycoffee.backend.coffee.enumeration.SensationType;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CoffeeResponseDto {

    private Long id;

    @Column(name = "coffee_name")
    private String name;

    @Column(name = "coffee_taste_type")
    private List<String> tasteType;

    @Column(name = "coffee_sensation_type")
    private SensationType sensationType;

    @Column(name = "coffee_beverage_type")
    private BeverageType beverageType;

    @Column(name = "coffee_company", nullable = true)
    private String company;

    public static CoffeeResponseDto response(Coffee coffee) {
        return CoffeeResponseDto.builder().
                id(coffee.getId()).
                name(coffee.getName()).
                sensationType(coffee.getSensationType()).
                beverageType(coffee.getBeverageType()).
                company(coffee.getCompany()).
                build();
    }
}
