package com.easycoffee.backend.coffeebook.dto.response;

import com.easycoffee.backend.common.enumeration.CommonResponseType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Getter
@Builder

public class CoffeeBookDeleteResponseDto {

    private Long id;

    private HttpStatus httpStatus;

    private String description;

    private LocalDateTime delete_at;

    public static CoffeeBookDeleteResponseDto deleteResponse(Long id) {
        return CoffeeBookDeleteResponseDto.builder().
                id(id).
                httpStatus(CommonResponseType.SUCCESS.getHttpStatus()).
                description(CommonResponseType.SUCCESS.getDescription()).
                delete_at(LocalDateTime.now()).build();
    }
}
