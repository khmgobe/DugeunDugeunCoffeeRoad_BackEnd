package com.easycoffee.backend.coffeebook.service;

import com.easycoffee.backend.coffeebook.dto.CoffeeBookResponseDto;
import com.easycoffee.backend.coffeebook.dto.CoffeeBookSaveDto;
import com.easycoffee.backend.coffeebook.dto.CoffeeBookUpdateDto;
import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.repository.CoffeeBookRepository;
import com.easycoffee.backend.coffeebook.enumeration.DeleteResponse;
import com.easycoffee.backend.common.exception.BadRequestException;
import com.easycoffee.backend.common.enumeration.CommonErrorType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CoffeeBookService {

    private final CoffeeBookRepository coffeeBookRepository;


    /**
     * 커피 도감을 저장합니다.
     * @param coffeeBookSaveDto 커피 도감 저장 Dto 객체입니다.
     * @return 커피 도감을 저장한 정보를 반환합니다.
     */
    public CoffeeBookResponseDto save(CoffeeBookSaveDto coffeeBookSaveDto) {
        CoffeeBook coffeeBook = coffeeBookSaveDto.toEntity();
        coffeeBookRepository.save(coffeeBook);
        return CoffeeBookResponseDto.response(coffeeBook);
    }

    /**
     * 커피 도감을 한 건 찾습니다.
     * @param coffeeBookId
     * @return
     */
    public CoffeeBookResponseDto findById(Long coffeeBookId) {
        CoffeeBook coffeeBook = coffeeBookRepository.findById(coffeeBookId);
        return CoffeeBookResponseDto.response(coffeeBook);
    }

    /**
     * 커피 도감의 전체 목록을 가져옵니다.
     * @return 커피 도감의 응답 반환 객체를 리스트로 반환합니다.
     */
    public List<CoffeeBookResponseDto> find() {
        List<CoffeeBook> coffeeBookList = coffeeBookRepository.find();
        return coffeeBookList.stream().map(CoffeeBookResponseDto::response).toList();
    }
    /**
     * 커피 도감을 수정합니다.
     * @param coffeeBookUpdateDto 커피 도감 수정 Dto 객체입니다.
     * @return
     */
    public CoffeeBookResponseDto update(CoffeeBookUpdateDto coffeeBookUpdateDto) {
        CoffeeBook coffeeBook = coffeeBookRepository.findById(coffeeBookUpdateDto.getId());
        coffeeBook.updateBook(coffeeBookUpdateDto);
        coffeeBookRepository.update(coffeeBook);
        return CoffeeBookResponseDto.response(coffeeBook);
    }


    /**
     * 커피 도감을 삭제합니다.
     * 실패 케이스 구현 필요
     * @param coffeeBookId 커피 도감 아이디입니다.
     * @return 삭제 시 HttpStatus 응답코드 200번과 "SUCCESS"를 반환합니다.
     */
    public ResponseEntity<DeleteResponse> remove(Long coffeeBookId) {
        Optional.ofNullable(coffeeBookId).orElseThrow(() -> new BadRequestException(CommonErrorType.NO_ELEMENT));
        coffeeBookRepository.remove(coffeeBookId);
        return ResponseEntity.status(HttpStatus.OK).body(DeleteResponse.SUCCESS);
    }
}
