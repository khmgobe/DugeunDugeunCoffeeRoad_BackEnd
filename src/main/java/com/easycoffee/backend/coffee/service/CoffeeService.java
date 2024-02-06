package com.easycoffee.backend.coffee.service;

import com.easycoffee.backend.coffee.dto.CoffeeResponseDto;
import com.easycoffee.backend.coffee.dto.CoffeeSaveDto;
import com.easycoffee.backend.coffee.dto.CoffeeUpdateDto;
import com.easycoffee.backend.coffee.entity.Coffee;
import com.easycoffee.backend.coffee.repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;


    public CoffeeResponseDto save(CoffeeSaveDto coffeeSaveDto){
        Coffee coffee = coffeeSaveDto.toEntity();
        coffeeRepository.save(coffee);
        return CoffeeResponseDto.response(coffee);
    }

    public CoffeeResponseDto findById(Long id) {
        Coffee coffee = coffeeRepository.findById(id);
        return CoffeeResponseDto.response(coffee);
    }

    public List<CoffeeResponseDto> find() {
        List<Coffee> coffeeList = coffeeRepository.find();
        return coffeeList.stream().map(CoffeeResponseDto::response).toList();
    }

    public CoffeeResponseDto update(CoffeeUpdateDto coffeeUpdateDto) {
        Coffee coffee = coffeeRepository.findById(coffeeUpdateDto.getId());
        coffee.updateCoffee(coffeeUpdateDto);
        coffeeRepository.update(coffee);
        return CoffeeResponseDto.response(coffee);
    }

    public Long remove(Long id) {
        Coffee coffee = coffeeRepository.findById(id);
        coffeeRepository.remove(id);
        return id;
    }
}
