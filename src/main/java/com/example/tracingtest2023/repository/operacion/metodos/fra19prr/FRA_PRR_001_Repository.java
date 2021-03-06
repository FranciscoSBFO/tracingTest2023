package com.example.tracingtest2023.repository.operacion.metodos.fra19prr;

import com.example.tracingtest2023.model.operacion.metodos.fra19prr.FRA_PRR_001;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FRA_PRR_001_Repository extends JpaRepository<FRA_PRR_001, Long>{
    FRA_PRR_001 findByIdFRAPRR(Long id);
    FRA_PRR_001 findByFolioTecnica(String folio);
    FRA_PRR_001 findByMetodoMuestra_MetodoMuestraId(Long id);
    FRA_PRR_001 findByIdInternoMuestra(String id);
}
