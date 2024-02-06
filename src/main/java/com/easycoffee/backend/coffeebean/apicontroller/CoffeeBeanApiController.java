package com.easycoffee.backend.coffeebean.apicontroller;

import com.easycoffee.backend.coffeebean.dto.CoffeeBeanResponseDto;
import com.easycoffee.backend.coffeebean.dto.CoffeeBeanSaveDto;
import com.easycoffee.backend.coffeebean.service.CoffeeBeanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CoffeeBeanApiController {

    private final CoffeeBeanService coffeeBeanService;

    @PostMapping("/easycoffee/coffeebean/save")
    public CoffeeBeanResponseDto save(@RequestBody CoffeeBeanSaveDto coffeeBeanSaveDto) {
        return coffeeBeanService.save(coffeeBeanSaveDto);
    }
}
