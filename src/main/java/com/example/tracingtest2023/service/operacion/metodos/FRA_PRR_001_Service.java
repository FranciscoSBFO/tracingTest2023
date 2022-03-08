package com.example.tracingtest2023.service.operacion.metodos;

import com.example.tracingtest2023.utils.EstructuraNombres;
import com.example.tracingtest2023.utils.FormatoFechas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.tracingtest2023.model.operacion.metodos.fra19prr.FRA_PRR_001;
import com.example.tracingtest2023.repository.operacion.metodos.fra19prr.FRA_PRR_001_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FRA_PRR_001_Service {

    @Autowired
    private FRA_PRR_001_Repository fra_prr_001_repository;

    EstructuraNombres estructuraNombres = new EstructuraNombres();
    FormatoFechas formatoFechas = new FormatoFechas();

    private static final Logger LOGGER = LoggerFactory.getLogger("info");

    private static final Logger APP = LoggerFactory.getLogger("info");

    public FRA_PRR_001 save(FRA_PRR_001 fra_prr_001) {
        return fra_prr_001_repository.save(fra_prr_001);
    }

    public List<FRA_PRR_001> findAll() {
        return fra_prr_001_repository.findAll();
    }

    public FRA_PRR_001 findById(Long id) {
        return fra_prr_001_repository.findByIdFRAPRR(id);
    }

    public FRA_PRR_001 findByFolio(String folio){
        return fra_prr_001_repository.findByFolioTecnica(folio);
    }

    public FRA_PRR_001 findByIdInternoMuestra(String id) {
        return fra_prr_001_repository.findByIdInternoMuestra(id);
    }

    public void delete(Long id) {
        fra_prr_001_repository.deleteById(id);
    }

    public long contar() {
        return fra_prr_001_repository.count();
    }


}
