package com.easycoffee.backend.coffeebook.entity;

import com.easycoffee.backend.coffeebook.dto.request.CoffeeBookSaveDto;
import com.easycoffee.backend.coffeebook.dto.request.CoffeeBookUpdateDto;
import com.easycoffee.backend.coffeebook.enumeration.BookType;
import com.easycoffee.backend.common.util.BaseEntity;
import com.easycoffee.backend.common.util.ListConverter;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.EnumType.*;
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

    @Column(name = "book_type")
    @Enumerated(STRING)
    private BookType bookType;

    @Column(name = "coffee_flavor")
    @Convert(converter = ListConverter.class)
    private List<String> flavor;

    private LocalDateTime create_at;

    private LocalDateTime update_at;

    public CoffeeBookSaveDto toDto() {
        return CoffeeBookSaveDto.builder().
                title(title).
                content(content).
                bookType(bookType).
                build();
    }

    public void updateBook(CoffeeBookUpdateDto coffeeBookUpdateDto) {
        this.title = coffeeBookUpdateDto.getTitle();
        this.content = coffeeBookUpdateDto.getContent();
        this.bookType = coffeeBookUpdateDto.getBookType();
        this.bookType = coffeeBookUpdateDto.getBookType();
        this.flavor = coffeeBookUpdateDto.getFlavor();
        this.update_at = getUpdateDate();
    }
}
