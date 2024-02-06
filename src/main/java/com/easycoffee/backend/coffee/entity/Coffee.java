package com.easycoffee.backend.coffee.entity;

import com.easycoffee.backend.coffee.dto.CoffeeUpdateDto;
import com.easycoffee.backend.coffee.enumeration.BeverageType;
import com.easycoffee.backend.coffee.enumeration.SensationType;
import com.easycoffee.backend.coffeebean.entity.CoffeeBean;
import com.easycoffee.backend.common.util.BaseEntity;
import com.easycoffee.backend.common.util.ListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.*;

@Entity
@Getter
@Builder
@Table(name = "COFFEE")
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
public class Coffee extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coffee_id")
    private Long id;

    @Column(name = "coffee_name")
    private String name;

    @Column(name = "coffee_tasteType")
    @Convert(converter = ListConverter.class)
    private List<String> tasteType;

    @Column(name = "coffee_sensation_type")
    @Enumerated(STRING)
    private SensationType sensationType;

    @Column(name = "coffee_flavor")
    @Convert(converter = ListConverter.class)
    private List<String> flavor;

    @Column(name = "coffee_beverage_type")
    @Enumerated(STRING)
    private BeverageType beverageType;

    @Column(name = "coffee_company", nullable = true)
    private String company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bean_id")
    private CoffeeBean coffeeBean;


    public void updateCoffee(CoffeeUpdateDto coffeeUpdateDto) {
        this.name = coffeeUpdateDto.getName();
        this.tasteType = coffeeUpdateDto.getTasteType();
        this.sensationType = coffeeUpdateDto.getSensationType();
        this.flavor =coffeeUpdateDto.getFlavor();
        this.beverageType = coffeeUpdateDto.getBeverageType();
        this.company = coffeeUpdateDto.getCompany();
    }
}