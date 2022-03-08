package com.example.tracingtest2023.repository.operacion.metodos;

import com.example.tracingtest2023.model.operacion.metodos.FRA_CST_001;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FRA_CST_001_Repository extends JpaRepository<FRA_CST_001, Long>{
    FRA_CST_001 findByCurvaSelladoId(Long id);
    FRA_CST_001 findByMetodoMuestra_MetodoMuestraId(Long id);
}
