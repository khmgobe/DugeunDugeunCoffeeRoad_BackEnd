package com.easycoffee.backend.coffeebook.apicontroller;

import com.easycoffee.backend.coffeebook.dto.response.CoffeeBookDeleteResponseDto;
import com.easycoffee.backend.coffeebook.dto.response.CoffeeBookResponseDto;
import com.easycoffee.backend.coffeebook.dto.request.CoffeeBookSaveDto;
import com.easycoffee.backend.coffeebook.dto.request.CoffeeBookUpdateDto;
import com.easycoffee.backend.coffeebook.dto.response.CoffeeBookSaveResponseDto;
import com.easycoffee.backend.coffeebook.dto.response.CoffeeBookUpdateResponseDto;
import com.easycoffee.backend.coffeebook.service.CoffeeBookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "커피도감", description = "커피도감 API 컨트롤러 페이지")
public class CoffeeBookApiController {

    private final CoffeeBookService coffeeBookService;

    @Operation(summary = "커피도감 1건을 조회합니다.")
    @GetMapping("/easycoffee/coffeebooks/{id}")
    public CoffeeBookResponseDto findById(@PathVariable("id") Long id) {
        return coffeeBookService.findById(id);
    }

    @Operation(summary = "모든 커피도감을 다 조회합니다.")
    @GetMapping("/easycoffee/coffeebooks/find")
    public List<CoffeeBookResponseDto> find() {
        return coffeeBookService.find();
    }

    @Operation(summary = "커피도감을 저장합니다.")
    @PostMapping("/easycoffee/coffeebooks/save")
    public CoffeeBookSaveResponseDto save(@RequestBody CoffeeBookSaveDto coffeeBookSaveDto) {
        return coffeeBookService.save(coffeeBookSaveDto);
    }

    @DeleteMapping("/easycoffee/coffeebooks/remove")
    public CoffeeBookDeleteResponseDto remove(@RequestParam(value = "id", required = false) Long id) {
        return coffeeBookService.remove(id);
    }

    @PatchMapping("/easycoffee/coffeebooks/update")
    public CoffeeBookUpdateResponseDto update(@RequestBody CoffeeBookUpdateDto coffeeBookUpdateDto) {
        return coffeeBookService.update(coffeeBookUpdateDto);
    }
}
