package com.example.tracingtest2023.repository;

import com.example.tracingtest2023.model.DocumentOrdenServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DocumentOrdenServicioRepository extends JpaRepository<DocumentOrdenServicio,Long> {
    DocumentOrdenServicio findByOrdenServicioId(Long id);
}
