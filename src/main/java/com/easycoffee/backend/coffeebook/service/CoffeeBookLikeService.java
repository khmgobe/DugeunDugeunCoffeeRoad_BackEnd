package com.easycoffee.backend.coffeebook.service;

import com.easycoffee.backend.coffeebook.dto.request.CoffeeBookLikeDto;
import com.easycoffee.backend.coffeebook.dto.response.CoffeeBookLikeResponseDto;
import com.easycoffee.backend.coffeebook.entity.CoffeeBookLike;
import com.easycoffee.backend.coffeebook.repository.CoffeeBookLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CoffeeBookLikeService {

    private final CoffeeBookLikeRepository coffeeBookLikeRepository;

    public CoffeeBookLikeDto save(CoffeeBookLikeDto coffeeBookLikeDto) {

        CoffeeBookLike coffeeBookLike = coffeeBookLikeDto.toEntity();
        coffeeBookLikeRepository.save(coffeeBookLike);
        return CoffeeBookLikeDto.of(coffeeBookLike);

    }

    public List<CoffeeBookLikeResponseDto> find() {
        List<CoffeeBookLike> coffeeBookLikeList = coffeeBookLikeRepository.find();
        return coffeeBookLikeList.stream().map(CoffeeBookLikeResponseDto::response).toList();
    }
}
