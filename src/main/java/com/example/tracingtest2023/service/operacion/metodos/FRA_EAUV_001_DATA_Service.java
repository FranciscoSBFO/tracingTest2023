package com.example.tracingtest2023.service.operacion.metodos;

import com.example.tracingtest2023.model.operacion.metodos.fra12eauv.datas.FRA_EAUV_001_DATA;
import com.example.tracingtest2023.repository.operacion.metodos.fra12eauv.datas.FRA_EAUV_001_DATA_Repository;
import com.example.tracingtest2023.utils.EstructuraNombres;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FRA_EAUV_001_DATA_Service {

    @Autowired
    private FRA_EAUV_001_DATA_Repository fra_eauv_001_data_repository;

    EstructuraNombres estructuraNombres = new EstructuraNombres();

    private static final Logger LOGGER = LoggerFactory.getLogger("info");

    private static final Logger APP = LoggerFactory.getLogger("info");

    public FRA_EAUV_001_DATA save(FRA_EAUV_001_DATA fra_eauv_001_data) {
        return fra_eauv_001_data_repository.save(fra_eauv_001_data);
    }

    public List<FRA_EAUV_001_DATA> findAll() {
        return fra_eauv_001_data_repository.findAll();
    }

    public List<FRA_EAUV_001_DATA> buscarPorEnsayo(Long id){
        return fra_eauv_001_data_repository.buscarTodosPorEnsayo(id);
    }

    public FRA_EAUV_001_DATA findById(Long id) {
        return fra_eauv_001_data_repository.findByIdFRAEAUVDATA(id);
    }

    public void delete(Long id) {
        fra_eauv_001_data_repository.deleteById(id);
    }

    public long contar() {
        return fra_eauv_001_data_repository.count();
    }
}
