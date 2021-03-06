package com.example.tracingtest2023.repository.operacion.metodos.fra14oit.datas;

import com.example.tracingtest2023.model.operacion.metodos.fra14oit.datas.FRA_OIT_001_DATA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FRA_OIT_001_DATA_Repository extends JpaRepository<FRA_OIT_001_DATA, Long> {
    FRA_OIT_001_DATA findByIdFRAOITDATA(Long id);

    @Query(value = "select * from fra_oit_001_data where idfraoit = :idFRAOIT", nativeQuery = true)
    List<FRA_OIT_001_DATA> buscarTodosPorEnsayo(@Param("idFRAOIT") Long id);
}
