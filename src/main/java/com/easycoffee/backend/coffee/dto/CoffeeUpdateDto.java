package com.easycoffee.backend.coffee.dto;

import com.easycoffee.backend.coffee.entity.Coffee;
import com.easycoffee.backend.coffee.enumeration.BeverageType;
import com.easycoffee.backend.coffee.enumeration.SensationType;
import com.easycoffee.backend.coffee.enumeration.TasteType;
import lombok.Getter;

@Getter
public class CoffeeUpdateDto {


    private Long id;

    private String name;

    private TasteType tasteType;

    private SensationType sensationType;

    private BeverageType beverageType;

    private String company;

    public Coffee toEntity() {
        return Coffee.builder().
               name(name).
                tasteType(tasteType).
                sensationType(sensationType).
                beverageType(beverageType).
                company(company).
                build();
    }
}
