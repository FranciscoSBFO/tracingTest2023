package com.example.tracingtest2023.service.operacion.metodos;

import com.example.tracingtest2023.model.operacion.metodos.fra09tga.FRA_TGA_001;
import com.example.tracingtest2023.repository.operacion.metodos.fra09tga.FRA_TGA_001_Repository;
import com.example.tracingtest2023.utils.EstructuraNombres;

import java.util.List;

import com.example.tracingtest2023.utils.FormatoFechas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FRA_TGA_001_Service {

    @Autowired
    private FRA_TGA_001_Repository fra_tga_001_repository;

    EstructuraNombres estructuraNombres = new EstructuraNombres();
    FormatoFechas formatoFechas = new FormatoFechas();

    private static final Logger LOGGER = LoggerFactory.getLogger("info");

    private static final Logger APP = LoggerFactory.getLogger("info");

    public FRA_TGA_001 save(FRA_TGA_001 fra_tga_001) {
        return fra_tga_001_repository.save(fra_tga_001);
    }

    public List<FRA_TGA_001> findAll() {
        return fra_tga_001_repository.findAll();
    }

    public FRA_TGA_001 findById(Long id) {
        return fra_tga_001_repository.findByIdFRATGA(id);
    }

    public FRA_TGA_001 findByIdInternoMuestra(String id) {
        return fra_tga_001_repository.findByIdInternoMuestra(id);
    }

    public FRA_TGA_001 findByMuestra(Long id) {
        return fra_tga_001_repository.findByMetodoMuestra_MetodoMuestraId(id);
    }

    public void delete(Long id) {
        fra_tga_001_repository.deleteById(id);
    }

    public long contar() {
        return fra_tga_001_repository.count();
    }


}
