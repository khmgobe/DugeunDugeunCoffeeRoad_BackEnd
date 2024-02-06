package com.easycoffee.backend.coffee.dto;

import com.easycoffee.backend.coffee.entity.Coffee;
import com.easycoffee.backend.coffee.enumeration.BeverageType;
import com.easycoffee.backend.coffee.enumeration.SensationType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class CoffeeResponseDto {

    private Long id;

    private String name;

    private List<String> tasteType;

    private SensationType sensationType;

    private BeverageType beverageType;

    private String company;

    private LocalDateTime create_date;

    private LocalDateTime update_date;

    public static CoffeeResponseDto response(Coffee coffee) {
        return CoffeeResponseDto.builder().
                id(coffee.getId()).
                name(coffee.getName()).
                tasteType(coffee.getTasteType()).
                sensationType(coffee.getSensationType()).
                beverageType(coffee.getBeverageType()).
                company(coffee.getCompany()).
                create_date(coffee.getCreateDate()).
                update_date(coffee.getUpdateDate()).
                build();
    }
}
