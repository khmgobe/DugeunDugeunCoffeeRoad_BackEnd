package com.easycoffee.backend.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CommonErrorType {

    NO_ELEMENT(HttpStatus.BAD_REQUEST.value(), "삭제 할 요소가 없습니다.");

    Integer status;
    String description;

}
