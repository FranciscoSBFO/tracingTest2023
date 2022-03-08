package com.example.tracingtest2023.repository;

import com.example.tracingtest2023.model.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, Long>{
    AppUser findByUserId(Long userId);
    AppUser findByUserName(String userName);
    List<AppUser> findAllByVisible(Integer a);
}
