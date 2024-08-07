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
    @GetMapping("/api/v1/easycoffee/coffeebooks/{id}")
    public CoffeeBookResponseDto findById(@PathVariable("id") Long id) {
        return coffeeBookService.findById(id);
    }

    @Operation(summary = "모든 커피도감을 다 조회합니다.")
    @GetMapping("/api/v1/easycoffee/coffeebooks/find")
    public List<CoffeeBookResponseDto> find() {
        return coffeeBookService.find();
    }

    @Operation(summary = "커피도감을 저장합니다.")
    @PostMapping("/api/v1/easycoffee/coffeebooks/save")
    public CoffeeBookSaveResponseDto save(@RequestBody CoffeeBookSaveDto coffeeBookSaveDto) {
        return coffeeBookService.save(coffeeBookSaveDto);
    }

    @DeleteMapping("/api/v1/easycoffee/coffeebooks/completelyDelete/{id}")
    public CoffeeBookDeleteResponseDto completelyDelete(@PathVariable(value = "id", required = false) Long id) {
        return coffeeBookService.completelyDelete(id);
    }

    @DeleteMapping("/api/v1/easycoffee/coffeebooks/delete{id}")
    public CoffeeBookDeleteResponseDto delete(@PathVariable(value = "id", required = false) Long id) {
        return coffeeBookService.delete(id);
    }

    @PatchMapping("/api/v1/easycoffee/coffeebooks/update")
    public CoffeeBookUpdateResponseDto update(@RequestBody CoffeeBookUpdateDto coffeeBookUpdateDto) {
        return coffeeBookService.update(coffeeBookUpdateDto);
    }
}
