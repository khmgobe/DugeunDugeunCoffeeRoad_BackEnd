package com.easycoffee.backend.coffeebook.service;

import com.easycoffee.backend.coffeebook.dto.response.CoffeeBookDeleteResponseDto;
import com.easycoffee.backend.coffeebook.dto.response.CoffeeBookResponseDto;
import com.easycoffee.backend.coffeebook.dto.request.CoffeeBookSaveDto;
import com.easycoffee.backend.coffeebook.dto.request.CoffeeBookUpdateDto;
import com.easycoffee.backend.coffeebook.dto.response.CoffeeBookSaveResponseDto;
import com.easycoffee.backend.coffeebook.dto.response.CoffeeBookUpdateResponseDto;
import com.easycoffee.backend.coffeebook.entity.CoffeeBook;
import com.easycoffee.backend.coffeebook.repository.CoffeeBookRepository;
import com.easycoffee.backend.common.exception.BadRequestException;
import com.easycoffee.backend.common.enumeration.CommonResponseType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

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
    public CoffeeBookSaveResponseDto save(CoffeeBookSaveDto coffeeBookSaveDto) {
        CoffeeBook coffeeBook = coffeeBookSaveDto.toEntity();
        coffeeBookRepository.save(coffeeBook);
        return CoffeeBookSaveResponseDto.response(coffeeBook);
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
    public CoffeeBookUpdateResponseDto update(CoffeeBookUpdateDto coffeeBookUpdateDto) {
        CoffeeBook coffeeBook = coffeeBookRepository.findById(coffeeBookUpdateDto.getId());
        coffeeBook.updateBook(coffeeBookUpdateDto);
        coffeeBookRepository.update(coffeeBook);
        return CoffeeBookUpdateResponseDto.response(coffeeBook);
    }


    /**
     * 커피 도감을 완전히 삭제합니다.
     * @param id 커피 도감 아이디입니다.
     * @return 삭제 시 HttpStatus와 응답 결과를 반환합니다.
     */
    public CoffeeBookDeleteResponseDto completelyDelete(Long id) {
        CheckIdDelete(id);
        coffeeBookRepository.completelyDelete(id);
        return CoffeeBookDeleteResponseDto.deleteResponse(id);
    }

    /**
     * 커피 도감을 삭제상태로 "업데이트"합니다.
     * @param id 커피 도감 아이디입니다.
     * @return 삭제 시 반환받는 HttpStatus와 응답 결과를 반환 받습니다.
     */
    public CoffeeBookDeleteResponseDto delete(Long id) {
        CheckIdDelete(id);
        coffeeBookRepository.delete(id);
        return CoffeeBookDeleteResponseDto.deleteResponse(id);
    }

    /**
     * 커피 도감 아이디가 있는지 확인 후 유효하지 않다(없다)면 NO_ELEMENT 응답 타입을 내립니다.
     * @param id 커피 도감 아이디입니다.
     */
    private void CheckIdDelete(Long id) {
        Optional.ofNullable(coffeeBookRepository.findById(id)).orElseThrow(() ->
                new BadRequestException(CommonResponseType.NO_ELEMENT));
    }
}
