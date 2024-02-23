package com.easycoffee.backend.common.enumeration;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;

@Getter

public enum CommonResponseType {

    NO_ELEMENT(BAD_REQUEST, "요소가 없습니다."),

    SUCCESS(OK, "정상적으로 처리되었습니다."),

    NOT_FOUND_USER(NOT_FOUND, "회원을 찾을 수 없습니다."),

    DUPLICATED_NICKNAME(CONFLICT, "중복된 닉네임입니다."),

    DUPLICATED_EMAIL(CONFLICT, "중복된 이메일입니다.");


    private final HttpStatus httpStatus;
    private final String description;

    CommonResponseType(HttpStatus httpStatus, String description) {
        this.httpStatus = httpStatus;
        this.description = description;
    }
}
