package com.easycoffee.backend.user.service;

import com.easycoffee.backend.common.exception.DuplicatedException;
import com.easycoffee.backend.common.exception.NotFoundException;
import com.easycoffee.backend.user.dto.request.UserJoinRequestDto;
import com.easycoffee.backend.user.dto.response.UserJoinResponseDto;
import com.easycoffee.backend.user.dto.response.UserResponseDto;
import com.easycoffee.backend.user.entity.User;
import com.easycoffee.backend.user.enumeration.UserRoleType;
import com.easycoffee.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.easycoffee.backend.common.enumeration.CommonResponseType.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 회원가입을 합니다. 현재는 회원가입에 대한 부가적인 기능들이 추가로 필요하지 않아 데이터베이스에 등록만 하며
     * 이후, 기능개발 이후 Spring Security 로 회원가입을 시도하여 처리하도록 전환 예정입니다.
     * @param userJoinRequestDto
     * @return
     */
    @Transactional
    public UserJoinResponseDto save(UserJoinRequestDto userJoinRequestDto) {
        User user = userJoinRequestDto.toEntity();
        checkValidity(userJoinRequestDto.nickname(), userJoinRequestDto.email());
        userRepository.save(user);
        return UserJoinResponseDto.from(user);
    }


    /**
     * 전체 회원을 조회합니다.
     * @return 전체 회원 리스트를 반환합니다.
     */
    @Transactional(readOnly = true)
    public List<UserResponseDto> find() {
        return userRepository.findAll().stream().map(UserResponseDto::from).toList();
    }

    /**
     * 전체 회원 중 특정 회원을 한 명 조회합니다.
     * @param id 회원 조회에 필요한 아이디입니다.
     * @return 회원을 한 명 조회하며 존재하지 않는다면 NotFoundException 예외를 반환합니다.
     */
    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(UserResponseDto::from).
                orElseThrow(() -> new NotFoundException(NOT_FOUND_USER));
    }

    /**
     * 회원가입 시 유저의 닉네임과 이메일이 실제로 존재하는지 확인하고 존재한다면 중복 예외를 발생시킵니다.
     * 임시로 작성된 것이며 이후 Exception 위임이 꼭 필요하지 않은 경우, validation @unique 처리하도록 변경합니다
     * @param nickname 유저 닉네임
     * @param email 유저 이메일
     */
    private void checkValidity(String nickname, String email) {
        if (userRepository.existsByNickname(nickname)) {
            throw new DuplicatedException(DUPLICATED_NICKNAME);
        }

        if (userRepository.existsByEmail(email)) {
            throw new DuplicatedException(DUPLICATED_EMAIL);
        }
    }

    public Long userCount() {
        return userRepository.count();
    }
}
