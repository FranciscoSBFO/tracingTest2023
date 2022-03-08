package com.example.tracingtest2023.repository;

import com.example.tracingtest2023.model.Machine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MachineRepository extends JpaRepository<Machine, Long>{
    Machine findByMachineId(Long idMachine);
}
