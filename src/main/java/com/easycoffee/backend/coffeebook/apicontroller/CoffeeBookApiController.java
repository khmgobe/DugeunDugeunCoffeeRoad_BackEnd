package com.easycoffee.backend.coffeebook.apicontroller;

import com.easycoffee.backend.coffeebook.dto.CoffeeBookResponseDto;
import com.easycoffee.backend.coffeebook.dto.CoffeeBookSaveDto;
import com.easycoffee.backend.coffeebook.dto.CoffeeBookUpdateDto;
import com.easycoffee.backend.coffeebook.service.CoffeeBookService;
import com.easycoffee.backend.coffeebook.enumeration.DeleteResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Getter
@RestController
@RequiredArgsConstructor
public class CoffeeBookApiController {

    private final CoffeeBookService coffeeBookService;

    @GetMapping("/easycoffee/coffeebook/{coffeeBookId}")
    public CoffeeBookResponseDto find(@PathVariable("coffeeBookId") Long coffeeBookId) {
        return coffeeBookService.find(coffeeBookId);
    }

    @PostMapping("/easycoffee/coffeebook/save")
    public CoffeeBookResponseDto save(@RequestBody CoffeeBookSaveDto coffeeBookSaveDto) {
        return coffeeBookService.save(coffeeBookSaveDto);
    }

    @DeleteMapping("/easycoffee/coffeebook/{coffeeBookId}")
    public ResponseEntity<DeleteResponse> delete(@PathVariable("coffeeBookId") Long coffeeBookId) {
        return coffeeBookService.delete(coffeeBookId);
    }

    @PatchMapping("/easycoffee/coffeebook/update")
    public CoffeeBookResponseDto update(@RequestBody CoffeeBookUpdateDto coffeeBookUpdateDto) {
        return coffeeBookService.update(coffeeBookUpdateDto);
    }
}
