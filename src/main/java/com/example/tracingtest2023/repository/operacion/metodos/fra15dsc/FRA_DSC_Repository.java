package com.example.tracingtest2023.repository.operacion.metodos.fra15dsc;

import com.example.tracingtest2023.model.operacion.metodos.fra15dsc.FRA_DSC;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FRA_DSC_Repository extends JpaRepository<FRA_DSC, Long>{
    FRA_DSC findByIdFRADSC(Long id);
    FRA_DSC findByMetodoMuestra_MetodoMuestraId(Long id);
    FRA_DSC findByIdInternoMuestra(String id);
}
