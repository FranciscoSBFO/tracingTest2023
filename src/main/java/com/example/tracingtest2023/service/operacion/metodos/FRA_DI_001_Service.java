package com.example.tracingtest2023.service.operacion.metodos;

import com.example.tracingtest2023.model.operacion.metodos.fra02di.FRA_DI_001;
import com.example.tracingtest2023.repository.operacion.metodos.fra02di.FRA_DI_001_Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FRA_DI_001_Service {

    @Autowired
    private FRA_DI_001_Repository fra_di_001_repository;

    private static final Logger LOGGER = LoggerFactory.getLogger("info");

    private static final Logger APP = LoggerFactory.getLogger("info");

    public FRA_DI_001 save(FRA_DI_001 fra_di_001) {
        return fra_di_001_repository.save(fra_di_001);
    }

    public List<FRA_DI_001> findAll() {
        return fra_di_001_repository.findAll();
    }

    public FRA_DI_001 findById(Long id) {
        return fra_di_001_repository.findByIdFRADI(id);
    }

    public FRA_DI_001 findByIdInternoMuestra(String id) {
        return fra_di_001_repository.findByIdInternoMuestra(id);
    }

    public FRA_DI_001 findByMuestra(Long id) {
        return fra_di_001_repository.findByMetodoMuestra_MetodoMuestraId(id);
    }

    public void delete(Long id) {
        fra_di_001_repository.deleteById(id);
    }

    public long contar() {
        return fra_di_001_repository.count();
    }
}