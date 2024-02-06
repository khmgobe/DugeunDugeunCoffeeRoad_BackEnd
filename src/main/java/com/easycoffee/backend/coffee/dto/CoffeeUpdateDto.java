package com.easycoffee.backend.coffee.dto;

import com.easycoffee.backend.coffee.entity.Coffee;
import com.easycoffee.backend.coffee.enumeration.BeverageType;
import com.easycoffee.backend.coffee.enumeration.SensationType;
import lombok.Getter;

import java.util.List;

@Getter
public class CoffeeUpdateDto {


    private Long id;

    private String name;

    private List<String> tasteType;

    private SensationType sensationType;

    private List<String> flavor;

    private BeverageType beverageType;

    private String company;

    public Coffee toEntity() {
        return Coffee.builder().
               name(name).
                sensationType(sensationType).
                beverageType(beverageType).
                company(company).
                build();
    }
}
