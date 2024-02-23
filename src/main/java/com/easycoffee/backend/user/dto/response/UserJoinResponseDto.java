package com.easycoffee.backend.user.dto.response;

import com.easycoffee.backend.user.entity.User;
import com.easycoffee.backend.user.enumeration.UserRoleType;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserJoinResponseDto(Long id, String name, String password, String nickname, UserRoleType userRoleType, LocalDateTime create_at) {

    public static UserJoinResponseDto from (User user) {
       return UserJoinResponseDto.builder().
               id(user.getId()).
               name(user.getName()).
               password(user.getPassword()).
               nickname(user.getNickname()).
               userRoleType(user.getUserRoleType()).
               create_at(user.getCreateDate()).
               build();
    }
}
