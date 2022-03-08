package com.example.tracingtest2023.repository;

import com.example.tracingtest2023.model.Folios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FoliosRepository extends JpaRepository<Folios, Long>{
    Folios findByFolioId(Long idFolios);
    Folios findByNombreFolio(String nombre);
}
