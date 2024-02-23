package com.easycoffee.backend.user.repository;

import com.easycoffee.backend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByNickname(String nickname);

    boolean existsByEmail(String email);

    List<User> findAll();
}
