package com.easycoffee.backend.coffeebook.entity;

import com.easycoffee.backend.coffeebook.dto.CoffeeBookSaveDto;
import com.easycoffee.backend.coffeebook.dto.CoffeeBookUpdateDto;
import com.easycoffee.backend.coffeebook.enumeration.BookType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import static jakarta.persistence.EnumType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@Builder
@Table(name = "COFFEE_BOOK")
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
public class CoffeeBook {

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

    /** baseEntity 사용 X **/
    @Column(name = "create_at")
    @CreatedDate
    private LocalDateTime create_at;

    @Column(name = "update_at")
    @LastModifiedDate
    private LocalDateTime update_at;



    public CoffeeBookSaveDto toDto() {
        return CoffeeBookSaveDto.builder().
                title(title).
                content(content).
                bookType(bookType).
                create_at(create_at).
                update_at(update_at).
                build();
    }

    public void updateBook(CoffeeBookUpdateDto coffeeBookUpdateDto) {
        this.title = coffeeBookUpdateDto.getTitle();
        this.content = coffeeBookUpdateDto.getContent();
        this.bookType = coffeeBookUpdateDto.getBookType();
        this.bookType = coffeeBookUpdateDto.getBookType();
        this.update_at = coffeeBookUpdateDto.getUpdate_at();
    }
}
