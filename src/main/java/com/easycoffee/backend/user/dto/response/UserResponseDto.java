package com.easycoffee.backend.user.dto.response;

import com.easycoffee.backend.user.entity.User;
import com.easycoffee.backend.user.enumeration.UserRoleType;
import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record UserResponseDto(Long id, String name, String nickname, String email, UserRoleType userRoleType, LocalDateTime create_at, LocalDateTime update_at) {


    public static UserResponseDto from (User user) {
       return UserResponseDto.builder().
               id(user.getId()).
               name(user.getName()).
               nickname(user.getNickname()).
               email(user.getEmail()).
               userRoleType(user.getUserRoleType()).
               create_at(user.getCreateDate()).
               update_at(user.getUpdateDate()).
               build();
    }
}
