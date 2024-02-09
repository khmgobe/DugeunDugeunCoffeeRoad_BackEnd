package com.easycoffee.backend.coffeebook.dto.request;

import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.enumeration.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import static lombok.AccessLevel.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class CoffeeBookSaveDto {


    private Long id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Schema(defaultValue = "false", description = "삭제 여부", hidden = true)
    private Boolean deleted;

    public CoffeeBook toEntity() {
        return CoffeeBook.builder().
                title(title).
                content(content).
                category(category).
                deleted(false).
                build();
    }
}
