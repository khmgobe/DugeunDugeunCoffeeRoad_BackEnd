package com.easycoffee.backend.coffeebean.service;

import com.easycoffee.backend.coffeebean.dto.CoffeeBeanResponseDto;
import com.easycoffee.backend.coffeebean.dto.CoffeeBeanSaveDto;
import com.easycoffee.backend.coffeebean.entity.CoffeeBean;
import com.easycoffee.backend.coffeebean.repository.CoffeeBeanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CoffeeBeanService {

    private final CoffeeBeanRepository coffeeBeanRepository;

    public CoffeeBeanResponseDto save(CoffeeBeanSaveDto coffeeBeanSaveDto) {
        CoffeeBean coffeeBean = coffeeBeanSaveDto.toEntity();
        coffeeBeanRepository.save(coffeeBean);
        return CoffeeBeanResponseDto.response(coffeeBean);
    }
}
