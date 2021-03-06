package com.example.tracingtest2023.service.operacion.metodos;

import com.example.tracingtest2023.model.operacion.metodos.fra10ico.FRA_ICO_001;
import com.example.tracingtest2023.repository.operacion.metodos.fra10ico.datas.FRA_ICO_001_DATA_Repository;
import com.example.tracingtest2023.repository.operacion.metodos.fra10ico.FRA_ICO_001_Repository;
import com.example.tracingtest2023.utils.EstructuraNombres;

import java.util.List;

import com.example.tracingtest2023.utils.FormatoFechas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FRA_ICO_001_Service {

    @Autowired
    private FRA_ICO_001_Repository fra_ico_001_repository;

    @Autowired
    private FRA_ICO_001_DATA_Repository fra_ico_001_data_repository;

    EstructuraNombres estructuraNombres = new EstructuraNombres();
    FormatoFechas formatoFechas = new FormatoFechas();

    private static final Logger LOGGER = LoggerFactory.getLogger("info");

    private static final Logger APP = LoggerFactory.getLogger("info");

    public FRA_ICO_001 save(FRA_ICO_001 fra_ico_001) {
        return fra_ico_001_repository.save(fra_ico_001);
    }

    public List<FRA_ICO_001> findAll() {
        return fra_ico_001_repository.findAll();
    }

    public FRA_ICO_001 findById(Long id) {
        return fra_ico_001_repository.findByIdFRAICO(id);
    }

    public FRA_ICO_001 findByFolio(String folio){
        return fra_ico_001_repository.findByFolioTecnica(folio);
    }

    public FRA_ICO_001 findByIdInternoMuestra(String id) {
        return fra_ico_001_repository.findByIdInternoMuestra(id);
    }

    public void delete(Long id) {
        fra_ico_001_repository.deleteById(id);
    }

    public long contar() {
        return fra_ico_001_repository.count();
    }
}
