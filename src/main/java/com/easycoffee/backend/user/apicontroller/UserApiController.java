package com.easycoffee.backend.user.apicontroller;

import com.easycoffee.backend.user.dto.request.UserJoinRequestDto;
import com.easycoffee.backend.user.dto.response.UserJoinResponseDto;
import com.easycoffee.backend.user.dto.response.UserResponseDto;
import com.easycoffee.backend.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(description = "두근두근 커피로드 회원 API 페이지", name = "회원")
@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @Operation(summary = "회원을 등록합니다.")
    @PostMapping("/api/easycoffee/users")
    public UserJoinResponseDto save(@RequestBody UserJoinRequestDto userJoinRequestDto) {
        return userService.save(userJoinRequestDto);
    }

    @Operation(summary = "전체 회원을 조회합니다.")
    @GetMapping("/api/v1/easycoffee/users")
    public List<UserResponseDto> find() {
        return userService.find();
    }

    @Operation(summary = "회원을 한 명 조회합니다.")
    @GetMapping("/api/v1/easycoffee/users/{id}")
    public UserResponseDto findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @Operation(summary = "전체 회원이 몇 명인지 조회합니다.")
    @GetMapping("/api/v1/easycoffee/users/count")
    public Long findUserCount() {
        return userService.userCount();
    }
}