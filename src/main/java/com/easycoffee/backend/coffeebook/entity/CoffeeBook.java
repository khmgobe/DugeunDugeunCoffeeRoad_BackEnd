package com.easycoffee.backend.coffeebook.entity;

import com.easycoffee.backend.coffeebook.dto.request.CoffeeBookSaveDto;
import com.easycoffee.backend.coffeebook.dto.request.CoffeeBookUpdateDto;
import com.easycoffee.backend.coffeebook.enumeration.Category;
import com.easycoffee.backend.common.util.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import static lombok.AccessLevel.*;

@Entity
@Getter
@Builder
@Table(name = "COFFEE_BOOK")
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
public class CoffeeBook extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_content")
    private String content;

    @Column(name = "book_category")
    @Enumerated(EnumType.STRING)
    private Category category;
    public CoffeeBookSaveDto toDto() {
        return CoffeeBookSaveDto.builder().
                title(title).
                content(content).
                build();
    }

    public void updateBook(CoffeeBookUpdateDto coffeeBookUpdateDto) {
        this.title = coffeeBookUpdateDto.getTitle();
        this.content = coffeeBookUpdateDto.getContent();
        this.category = coffeeBookUpdateDto.getCategory();
    }
}
