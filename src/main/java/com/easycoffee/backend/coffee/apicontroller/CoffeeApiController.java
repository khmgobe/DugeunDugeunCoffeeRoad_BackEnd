package com.easycoffee.backend.coffee.apicontroller;

import com.easycoffee.backend.coffee.dto.CoffeeResponseDto;
import com.easycoffee.backend.coffee.dto.CoffeeSaveDto;
import com.easycoffee.backend.coffee.dto.CoffeeUpdateDto;
import com.easycoffee.backend.coffee.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CoffeeApiController {

    private final CoffeeService coffeeService;

    @PostMapping("/easycoffee/coffee/create")
    public CoffeeResponseDto create(@RequestBody CoffeeSaveDto coffeeSaveDto) {
        return coffeeService.save(coffeeSaveDto);
    }

    @GetMapping("/easycoffee/coffee/find{id}")
    public CoffeeResponseDto find(@PathVariable(name = "id", required = false) Long id) {
        return coffeeService.find(id);
    }

    @PatchMapping("/easycoffee/coffee/update")
    public CoffeeResponseDto update(@RequestBody CoffeeUpdateDto coffeeUpdateDto) {
        return coffeeService.update(coffeeUpdateDto);
    }

    @DeleteMapping("/easycoffee/coffee/remove/{id}")
    public Long remove(@PathVariable(name = "id", required = false) Long id) {
        return coffeeService.remove(id);
    }
}
