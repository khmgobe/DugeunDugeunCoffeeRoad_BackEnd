package com.easycoffee.backend.coffee.entity;

import com.easycoffee.backend.coffee.dto.CoffeeUpdateDto;
import com.easycoffee.backend.coffee.enumeration.BeverageType;
import com.easycoffee.backend.coffee.enumeration.SensationType;
import com.easycoffee.backend.coffee.enumeration.TasteType;
import com.easycoffee.backend.coffeebean.entity.CoffeeBean;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.*;

@Entity
@Getter
@Builder
@Table(name = "COFFEE")
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
public class Coffee {

    @Id @GeneratedValue
    @Column(name = "coffee_id")
    private Long id;

    @Column(name = "coffee_name")
    private String name;

    @Column(name = "coffee_taste_type")
    private TasteType tasteType;

    @Column(name = "coffee_sensation_type")
    private SensationType sensationType;

    @Column(name = "coffee_beverage_type")
    private BeverageType beverageType;

    @Column(name = "coffee_company", nullable = true)
    private String company;

    @ManyToOne
    @JoinColumn(name = "bean_id")
    private CoffeeBean coffeeBean;

    public void updateCoffee(CoffeeUpdateDto coffeeUpdateDto) {
        this.name = coffeeUpdateDto.getName();
        this.tasteType = coffeeUpdateDto.getTasteType();
        this.sensationType = coffeeUpdateDto.getSensationType();
        this.beverageType = coffeeUpdateDto.getBeverageType();
    }
}