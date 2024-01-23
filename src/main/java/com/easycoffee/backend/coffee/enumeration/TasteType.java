package com.easycoffee.backend.coffee.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TasteType {

     SWEETNESS("단맛"),
     NUTTY("고소한맛"),
     SOUR("신맛");
     String description;
}
