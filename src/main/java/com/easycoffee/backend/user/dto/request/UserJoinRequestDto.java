package com.easycoffee.backend.user.dto.request;

import com.easycoffee.backend.user.entity.User;
import com.easycoffee.backend.user.enumeration.UserRoleType;
import lombok.*;

@Builder
public record UserJoinRequestDto(Long id, String name, String password, String email, String nickname, UserRoleType userRoleType) {



    public UserJoinRequestDto from (User user) {
      return UserJoinRequestDto.builder().
                id(user.getId()).
                nickname(user.getNickname()).
                name(user.getName()).
                password(user.getPassword()).
                userRoleType(userRoleType).
                build();
    }

    public User toEntity() {
        return User.builder().
                name(name).
                password(password).
                email(email).
                nickname(nickname).
                userRoleType(userRoleType).
                build();
    }
}
