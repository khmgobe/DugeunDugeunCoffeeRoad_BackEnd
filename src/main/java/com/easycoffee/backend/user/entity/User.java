package com.easycoffee.backend.user.entity;

import com.easycoffee.backend.common.util.BaseEntity;
import com.easycoffee.backend.user.enumeration.UserRoleType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_password")
    private String password;


    @Column(name = "user_email", unique = true)
    private String email;

    @Column(name = "user_nickname", unique = true)
    private String nickname;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRoleType userRoleType;


}
