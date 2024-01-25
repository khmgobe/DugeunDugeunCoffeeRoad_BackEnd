package com.easycoffee.backend.coffeebook.apicontroller;

import com.easycoffee.backend.coffeebook.dto.CoffeeBookResponseDto;
import com.easycoffee.backend.coffeebook.dto.CoffeeBookSaveDto;
import com.easycoffee.backend.coffeebook.dto.CoffeeBookUpdateDto;
import com.easycoffee.backend.coffeebook.service.CoffeeBookService;
import com.easycoffee.backend.coffeebook.enumeration.DeleteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CoffeeBookApiController {

    private final CoffeeBookService coffeeBookService;

    @GetMapping("/easycoffee/coffeebook/{coffeeBookId}")
    public CoffeeBookResponseDto findById(@PathVariable("coffeeBookId") Long coffeeBookId) {
        return coffeeBookService.findById(coffeeBookId);
    }

    @GetMapping("/easycoffee/coffeebook/find")
    public List<CoffeeBookResponseDto> find() {
        return coffeeBookService.find();
    }

    @PostMapping("/easycoffee/coffeebook/save")
    public CoffeeBookResponseDto save(@RequestBody CoffeeBookSaveDto coffeeBookSaveDto) {
        return coffeeBookService.save(coffeeBookSaveDto);
    }

    @DeleteMapping("/easycoffee/coffeebook/remove/{coffeeBookId}")
    public ResponseEntity<DeleteResponse> remove(@PathVariable("coffeeBookId") Long coffeeBookId) {
        return coffeeBookService.remove(coffeeBookId);
    }

    @PatchMapping("/easycoffee/coffeebook/update")
    public CoffeeBookResponseDto update(@RequestBody CoffeeBookUpdateDto coffeeBookUpdateDto) {
        return coffeeBookService.update(coffeeBookUpdateDto);
    }
}
