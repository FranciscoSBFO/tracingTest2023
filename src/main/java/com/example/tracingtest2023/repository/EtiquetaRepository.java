package com.example.tracingtest2023.repository;

import com.example.tracingtest2023.model.Etiqueta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long>{
    Etiqueta findByEtiquetaId(Long id);
}
