package com.easycoffee.backend.coffee.entity;

import com.easycoffee.backend.coffee.dto.CoffeeResponseDto;
import com.easycoffee.backend.coffee.dto.CoffeeUpdateDto;
import com.easycoffee.backend.coffee.enumeration.BeverageType;
import com.easycoffee.backend.coffee.enumeration.SensationType;
import com.easycoffee.backend.coffeebean.entity.CoffeeBean;
import com.easycoffee.backend.common.util.BaseEntity;
import com.easycoffee.backend.common.util.ListConverter;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "커피 아이디", hidden = true)
    private Long id;

    @Column(name = "coffee_name")
    @Schema(description = "커피 이름")
    private String name;

    @Enumerated(STRING)
    @Schema(description = "커피 온도 유형")
    @Column(name = "coffee_sensation_type")
    private SensationType sensationType;

    @Column(name = "coffee_flavor")
    @Schema(description = "커피 맛 형태")
    @Convert(converter = ListConverter.class)
    private List<String> flavor;

    @Column(name = "coffee_beverage_type")
    @Enumerated(STRING)
    @Schema(description = "커피 제조 유형")
    private BeverageType beverageType;

    @Column(name = "coffee_company", nullable = true)
    @Schema(description = "커피 회사")
    private String company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bean_id")
    @Schema(description = "원두")
    private CoffeeBean coffeeBean;


    public void updateCoffee(CoffeeUpdateDto coffeeUpdateDto) {
        this.name = coffeeUpdateDto.getName();
        this.sensationType = coffeeUpdateDto.getSensationType();
        this.flavor =coffeeUpdateDto.getFlavor();
        this.beverageType = coffeeUpdateDto.getBeverageType();
        this.company = coffeeUpdateDto.getCompany();
    }

    public CoffeeResponseDto toDto() {
        return CoffeeResponseDto.builder().
                name(name).
                sensationType(sensationType).
                flavor(flavor).
                beverageType(beverageType).
                company(company).
                create_date(getCreateDate()).
                update_date(getUpdateDate()).
                coffeeBean(coffeeBean.toDto()).
                build();
    }

}