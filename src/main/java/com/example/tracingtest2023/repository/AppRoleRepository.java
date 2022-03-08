package com.example.tracingtest2023.repository;

import com.example.tracingtest2023.model.AppRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AppRoleRepository extends JpaRepository<AppRole, Long>{
    AppRole findByRoleId(Long roleId);
}
