package com.example.tracingtest2023.repository.operacion.metodos.fra11eat;

import com.example.tracingtest2023.model.operacion.metodos.fra11eat.FRA_EAT_001;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FRA_EAT_001_Repository extends JpaRepository<FRA_EAT_001, Long>{
    FRA_EAT_001 findByIdFRAEAT(Long id);
    FRA_EAT_001 findByFolioTecnica(String folio);
    FRA_EAT_001 findByMetodoMuestra_MetodoMuestraId(Long id);
}
