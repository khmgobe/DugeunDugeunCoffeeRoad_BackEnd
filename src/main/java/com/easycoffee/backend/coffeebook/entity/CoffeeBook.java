package com.easycoffee.backend.coffeebook.entity;

import com.easycoffee.backend.coffee.entity.Coffee;
import com.easycoffee.backend.coffeebook.dto.request.CoffeeBookSaveDto;
import com.easycoffee.backend.coffeebook.dto.request.CoffeeBookUpdateDto;
import com.easycoffee.backend.coffeebook.enumeration.Category;
import com.easycoffee.backend.common.util.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "제목")
    private String title;

    @Column(name = "book_content")
    @Schema(description = "내용")
    private String content;

    @Column(name = "book_category")
    @Schema(description = "카테고리")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "book_deleted")
    @Schema(defaultValue = "false", description = "삭제 여부", hidden = true)
    private Boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @Schema(description = "원두")
    @JoinColumn(name = "coffee_id")
    private Coffee coffee;

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
