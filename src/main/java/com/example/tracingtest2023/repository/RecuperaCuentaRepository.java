package com.example.tracingtest2023.repository;

import com.example.tracingtest2023.model.RecuperaCuenta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RecuperaCuentaRepository extends JpaRepository<RecuperaCuenta, Long>{
    RecuperaCuenta findByCodigo(String codigo);
    RecuperaCuenta findByCorreo(String correo);
}
