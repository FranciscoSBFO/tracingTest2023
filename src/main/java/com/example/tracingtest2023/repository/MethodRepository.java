package com.example.tracingtest2023.repository;

import com.example.tracingtest2023.model.Method;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MethodRepository extends JpaRepository<Method, Long>{
    Method findByMethodId(Long idMethod);
    Method findByCodigoMetodo(String codigoMetodo);
}
