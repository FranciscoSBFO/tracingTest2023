package com.example.tracingtest2023.service.operacion.metodos;

import com.example.tracingtest2023.model.operacion.metodos.fra13eaxe.FRA_EAXE_013;
import com.example.tracingtest2023.repository.operacion.metodos.fra13eaxe.FRA_EAXE_013_Repository;
import com.example.tracingtest2023.repository.operacion.metodos.fra13eaxe.datas.FRA_EAXE_013_DATA_Repository;
import com.example.tracingtest2023.utils.EstructuraNombres;

import java.util.List;

import com.example.tracingtest2023.utils.FormatoFechas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FRA_EAXE_013_Service {

    @Autowired
    private FRA_EAXE_013_Repository fra_eaxe_013_repository;

    @Autowired
    private FRA_EAXE_013_DATA_Repository fra_eaxe_013_data_repository;

    EstructuraNombres estructuraNombres = new EstructuraNombres();
    FormatoFechas formatoFechas = new FormatoFechas();

    private static final Logger LOGGER = LoggerFactory.getLogger("info");

    private static final Logger APP = LoggerFactory.getLogger("info");

    public FRA_EAXE_013 save(FRA_EAXE_013 fra_eaxe_013) {
        return fra_eaxe_013_repository.save(fra_eaxe_013);
    }

    public List<FRA_EAXE_013> findAll() {
        return fra_eaxe_013_repository.findAll();
    }

    public FRA_EAXE_013 findById(Long id) {
        return fra_eaxe_013_repository.findByIdFRAEAXE(id);
    }

    public FRA_EAXE_013 findByFolio(String folio) {
        return fra_eaxe_013_repository.findByFolioTecnica(folio);
    }

    public void delete(Long id) {
        fra_eaxe_013_repository.deleteById(id);
    }

    public long contar() {
        return fra_eaxe_013_repository.count();
    }


}
