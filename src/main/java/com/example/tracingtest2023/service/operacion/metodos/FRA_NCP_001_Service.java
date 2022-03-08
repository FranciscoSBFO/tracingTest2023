package com.example.tracingtest2023.service.operacion.metodos;

import com.example.tracingtest2023.model.operacion.metodos.fra06ncp.FRA_NCP_001;
import com.example.tracingtest2023.repository.operacion.metodos.fra06ncp.FRA_NCP_001_Repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FRA_NCP_001_Service {
    @Autowired
    private FRA_NCP_001_Repository fra_ncp_001_repository;

    private static final Logger LOGGER = LoggerFactory.getLogger("info");

    private static final Logger APP = LoggerFactory.getLogger("info");

    public FRA_NCP_001 save(FRA_NCP_001 fra_ncp_001) {
        return fra_ncp_001_repository.save(fra_ncp_001);
    }

    public List<FRA_NCP_001> findAll() {
        return fra_ncp_001_repository.findAll();
    }

    public FRA_NCP_001 findById(Long id) {
        return fra_ncp_001_repository.findByIdFRANCP(id);
    }

    public FRA_NCP_001 findByIdInternoMuestra(String id) {
        return fra_ncp_001_repository.findByIdInternoMuestra(id);
    }

    public void delete(Long id) {
        fra_ncp_001_repository.deleteById(id);
    }

    public long contar() {
        return fra_ncp_001_repository.count();
    }
}
