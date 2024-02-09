package com.easycoffee.backend.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum CommonResponseType {

    NO_ELEMENT(BAD_REQUEST, "삭제 할 요소가 없습니다."),

    SUCCESS(OK, "정상적으로 처리되었습니다.");


    private final HttpStatus httpStatus;
    private final String description;

}
