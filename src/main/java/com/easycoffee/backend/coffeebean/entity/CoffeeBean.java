package com.easycoffee.backend.coffeebean.entity;

import com.easycoffee.backend.coffee.dto.CoffeeResponseDto;
import com.easycoffee.backend.coffeebean.dto.CoffeeBeanResponseDto;
import com.easycoffee.backend.coffeebean.dto.CoffeeBeanUpdateDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@Builder
@Table(name = "COFFEE_BEAN")
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
public class CoffeeBean {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bean_id")
    @Schema(description = "원두 아이디", hidden = true)
    private Long id;

    @Column(name = "bean_name")
    @Schema(description = "원두 이름")
    private String name;

    @Column(name = "bean_note")
    @Schema(description = "원두 노트")
    private String note;

    @Column(name = "bean_distribution")
    @Schema(description = "원두 배전도")
    private String distribution;


    public void updateCoffeeBean(CoffeeBeanUpdateDto coffeeBeanUpdateDto) {
        this.name = coffeeBeanUpdateDto.getName();
        this.note = coffeeBeanUpdateDto.getNote();
        this.distribution = coffeeBeanUpdateDto.getDistribution();
    }

    public CoffeeBeanResponseDto toDto() {
        return CoffeeBeanResponseDto.builder().
                name(name).
                note(note).
                distribution(distribution).
                build();
    }
}
