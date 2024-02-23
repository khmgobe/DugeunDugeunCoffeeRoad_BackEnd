package com.easycoffee.backend.common.util;

import com.easycoffee.backend.common.enumeration.CommonResponseType;
import com.easycoffee.backend.common.exception.BadRequestException;
import com.easycoffee.backend.common.exception.DuplicatedException;
import com.easycoffee.backend.common.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class CommonControllerAdvice {
    private final ErrorAttributes errorAttributes;

    /** 잘못된 요청 예외 반환 */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> BadRequestException(BadRequestException badRequestException, HttpServletRequest request) {
        return CommonErrorResponse(badRequestException.getCommonResponseType(), request);
    }

    /** 찾을 수 없음 예외 반환 */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(NotFoundException notFoundException, HttpServletRequest request) {
        return CommonErrorResponse(notFoundException.getCommonResponseType(), request);
    }

    /** 중복 예외 반환 */
    @ExceptionHandler(DuplicatedException.class)
    public ResponseEntity<?> DuplicatedException(DuplicatedException duplicatedException, HttpServletRequest request) {
        return CommonErrorResponse(duplicatedException.getCommonResponseType(), request);
    }

    private ResponseEntity<?> CommonErrorResponse(CommonResponseType commonResponseType, HttpServletRequest request) {
        Map<String, Object> errorAttributes = getErrorAttributes(request, ErrorAttributeOptions(request));
        responseStatus(errorAttributes, commonResponseType);

        return ResponseEntity.status(commonResponseType.getHttpStatus()).body(errorAttributes);
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, ErrorAttributeOptions options) {
        WebRequest webRequest = new ServletWebRequest(request);
        return errorAttributes.getErrorAttributes(webRequest, options);
    }

    private ErrorAttributeOptions ErrorAttributeOptions(HttpServletRequest request) {
        return ErrorAttributeOptions.defaults();
    }

    private void responseStatus(Map<String, Object> errorAttributes, CommonResponseType commonResponseType) {
        errorAttributes.put("timestamp", LocalDateTime.now());
        errorAttributes.put("status", commonResponseType.getHttpStatus());
        errorAttributes.put("error", commonResponseType.getDescription());
        errorAttributes.put("type", commonResponseType);
    }
}
