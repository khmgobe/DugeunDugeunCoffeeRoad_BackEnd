package com.easycoffee.backend.coffee.dto;

import com.easycoffee.backend.coffee.entity.Coffee;
import com.easycoffee.backend.coffee.enumeration.BeverageType;
import com.easycoffee.backend.coffee.enumeration.SensationType;
import com.easycoffee.backend.coffeebean.entity.CoffeeBean;
import lombok.Getter;
import java.util.List;

@Getter
public class CoffeeSaveDto {


    private Long id;

    private String name;

    private List<String> tasteType;

    private SensationType sensationType;

    private List<String> flavor;

    private BeverageType beverageType;

    private String company;

    private CoffeeBean coffeeBean;

    public Coffee toEntity() {
        return Coffee.builder().
                name(name).
                tasteType(tasteType).
                flavor(flavor).
                sensationType(sensationType).
                beverageType(beverageType).
                company(company).
                coffeeBean(coffeeBean).
                build();
    }
}
