package com.easycoffee.backend.common.util;

import com.easycoffee.backend.common.enumeration.CommonErrorType;
import com.easycoffee.backend.common.exception.BadRequestException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class CommonControllerAdvice {
        private final ErrorAttributes errorAttributes;

        /** 잘못된 요청 예외 반환 **/
        @ExceptionHandler(BadRequestException.class)
        public ResponseEntity<?> BadRequestException(BadRequestException badRequestException, HttpServletRequest request) {
            return CommonErrorResponse(badRequestException.getCommonErrorType(), request);
        }


        private ResponseEntity<?> CommonErrorResponse(CommonErrorType commonErrorType, HttpServletRequest request) {
            Map<String, Object> errorAttributes = getErrorAttributes(request, ErrorAttributeOptions(request));
            responseStatus(errorAttributes, commonErrorType);

            return ResponseEntity.status(commonErrorType.getStatus()).body(errorAttributes);
        }

        private Map<String, Object> getErrorAttributes(HttpServletRequest request, ErrorAttributeOptions options) {
            WebRequest webRequest = new ServletWebRequest(request);
            return errorAttributes.getErrorAttributes(webRequest, options);
        }

        private ErrorAttributeOptions ErrorAttributeOptions(HttpServletRequest request) {
            return ErrorAttributeOptions.defaults();
        }

        private void responseStatus(Map<String, Object> errorAttributes, CommonErrorType commonErrorType) {
            errorAttributes.put("status", commonErrorType.getStatus());
            errorAttributes.put("error", commonErrorType.getDescription());
            errorAttributes.put("type", commonErrorType);
        }
    }
