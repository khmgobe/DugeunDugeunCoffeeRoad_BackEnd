package com.easycoffee.backend.coffeebean.entity;

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
    private Long id;

    @Column(name = "bean_name")
    private String name;

    @Column(name = "bean_country")
    private String country;

    @Column(name = "bean_variety")
    private String variety;

    @Column(name = "bean_note")
    private String note;

    @Column(name = "bean_roasting_level")
    private String distribution;

}
