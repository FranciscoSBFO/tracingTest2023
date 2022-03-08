package com.example.tracingtest2023.repository.operacion.metodos;

import com.example.tracingtest2023.model.operacion.metodos.FRA_PO_001;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FRA_PO_001_Repository extends JpaRepository<FRA_PO_001, Long>{
    FRA_PO_001 findByIdFRAPO(Long id);
    FRA_PO_001 findByMetodoMuestra_MetodoMuestraId(Long id);
}
