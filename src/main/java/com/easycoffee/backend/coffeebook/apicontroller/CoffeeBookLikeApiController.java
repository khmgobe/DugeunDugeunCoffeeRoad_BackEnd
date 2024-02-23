package com.easycoffee.backend.coffeebook.apicontroller;

import com.easycoffee.backend.coffeebook.dto.request.CoffeeBookLikeDto;
import com.easycoffee.backend.coffeebook.dto.response.CoffeeBookLikeResponseDto;
import com.easycoffee.backend.coffeebook.service.CoffeeBookLikeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "커피도감 좋아요", description = "커피도감 좋아요 API 컨트롤러 페이지")
@RestController
@RequiredArgsConstructor
public class CoffeeBookLikeApiController {


    private final CoffeeBookLikeService coffeeBookLikeService;


    @PostMapping("/api/v1/easycoffee/coffeebook-likes/save")
    public CoffeeBookLikeDto save(@RequestBody CoffeeBookLikeDto coffeeBookLikeDto) {
        return coffeeBookLikeService.save(coffeeBookLikeDto);
    }

    public List<CoffeeBookLikeResponseDto> find() {
        return coffeeBookLikeService.find();
    }
}
