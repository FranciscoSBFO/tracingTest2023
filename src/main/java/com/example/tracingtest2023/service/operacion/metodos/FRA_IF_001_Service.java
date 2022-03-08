package com.example.tracingtest2023.service.operacion.metodos;

import com.example.tracingtest2023.model.operacion.metodos.fra17if.FRA_IF_001;
import com.example.tracingtest2023.repository.operacion.metodos.fra17if.FRA_IF_001_Repository;
import com.example.tracingtest2023.utils.EstructuraNombres;

import java.util.List;

import com.example.tracingtest2023.utils.FormatoFechas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FRA_IF_001_Service {

    @Autowired
    private FRA_IF_001_Repository fra_if_001_repository;

    EstructuraNombres estructuraNombres = new EstructuraNombres();
    FormatoFechas formatoFechas = new FormatoFechas();

    private static final Logger LOGGER = LoggerFactory.getLogger("info");

    private static final Logger APP = LoggerFactory.getLogger("info");

    public FRA_IF_001 save(FRA_IF_001 fra_if_001) {
        return fra_if_001_repository.save(fra_if_001);
    }

    public List<FRA_IF_001> findAll() {
        return fra_if_001_repository.findAll();
    }

    public FRA_IF_001 findById(Long id) {
        return fra_if_001_repository.findByIdFRAIF(id);
    }

    public FRA_IF_001 findByIdInternoMuestra(String id) {
        return fra_if_001_repository.findByIdInternoMuestra(id);
    }

    public FRA_IF_001 findByFolio(String folio) {
        return fra_if_001_repository.findByFolioTecnica(folio);
    }

    public FRA_IF_001 findByMuestra(Long id) {
        return fra_if_001_repository.findByMetodoMuestra_MetodoMuestraId(id);
    }

    public void delete(Long id) {
        fra_if_001_repository.deleteById(id);
    }

    public long contar() {
        return fra_if_001_repository.count();
    }


}
