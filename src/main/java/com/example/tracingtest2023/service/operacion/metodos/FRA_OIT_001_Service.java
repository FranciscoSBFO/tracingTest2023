package com.example.tracingtest2023.service.operacion.metodos;

import com.example.tracingtest2023.model.operacion.metodos.fra14oit.FRA_OIT_001;
import com.example.tracingtest2023.repository.operacion.MetodoMuestraRepository;
import com.example.tracingtest2023.repository.operacion.RecepcionVerificacionRegistroCodificacionRepository;
import com.example.tracingtest2023.repository.operacion.metodos.fra14oit.FRA_OIT_001_Repository;
import com.example.tracingtest2023.utils.EstructuraNombres;

import java.util.List;

import com.example.tracingtest2023.utils.FormatoFechas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FRA_OIT_001_Service {

    @Autowired
    private FRA_OIT_001_Repository fra_oit_001_repository;

    @Autowired
    private MetodoMuestraRepository metodoMuestraRepository;

    @Autowired
    private RecepcionVerificacionRegistroCodificacionRepository recepcionVerificacionRegistroCodificacionRepository;

    EstructuraNombres estructuraNombres = new EstructuraNombres();
    FormatoFechas formatoFechas = new FormatoFechas();

    private static final Logger LOGGER = LoggerFactory.getLogger("info");

    private static final Logger APP = LoggerFactory.getLogger("info");

    public FRA_OIT_001 save(FRA_OIT_001 fra_oit_001) {
        return fra_oit_001_repository.save(fra_oit_001);
    }

    public List<FRA_OIT_001> findAll() {
        return fra_oit_001_repository.findAll();
    }

    public FRA_OIT_001 findById(Long id) {
        return fra_oit_001_repository.findByIdFRAOIT(id);
    }

    public FRA_OIT_001 findByIdInternoMuestra(String id) {
        return fra_oit_001_repository.findByIdInternoMuestra(id);
    }

    public FRA_OIT_001 findByFolio(String folio) {
        return fra_oit_001_repository.findByFolioTecnica(folio);
    }

    public FRA_OIT_001 findByMuestra(Long id) {
        return fra_oit_001_repository.findByMetodoMuestra_MetodoMuestraId(id);
    }

    public void delete(Long id) {
        fra_oit_001_repository.deleteById(id);
    }

    public long contar() {
        return fra_oit_001_repository.count();
    }




}
