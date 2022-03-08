package com.example.tracingtest2023.repository;

import com.example.tracingtest2023.model.InformacionMuestrasOSC;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface InformacionMuestrasOSCRepository extends JpaRepository<InformacionMuestrasOSC, Long>{
    InformacionMuestrasOSC findByInformacionMuestrasOSCId(Long id);
}
