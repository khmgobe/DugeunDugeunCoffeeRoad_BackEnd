package com.easycoffee.backend.common.exception;

import com.easycoffee.backend.common.enumeration.CommonResponseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@AllArgsConstructor
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicatedException extends RuntimeException {

    private CommonResponseType commonResponseType;
}
