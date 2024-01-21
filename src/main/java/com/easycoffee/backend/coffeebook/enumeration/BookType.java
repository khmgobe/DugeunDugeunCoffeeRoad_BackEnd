package com.easycoffee.backend.coffeebook.enumeration;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.*;

@Getter
@AllArgsConstructor(access = PROTECTED)
public enum BookType {
    HANDDRIP, ESPRESSO
}
