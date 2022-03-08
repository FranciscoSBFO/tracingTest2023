package com.example.tracingtest2023.repository.operacion;

import com.example.tracingtest2023.model.operacion.SolicitudServicioCliente;
import com.example.tracingtest2023.model.operacion.SolicitudServicioClienteMuestras;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SolicitudServicioClienteMuestrasRepository extends JpaRepository<SolicitudServicioClienteMuestras, Long>{
    SolicitudServicioClienteMuestras findBySolicitudServicioClienteMuestrasId(Long id);
    List<SolicitudServicioClienteMuestras> findAllBySolicitudServicioCliente_SolicitudServicioClienteId(Long id);
    List<SolicitudServicioClienteMuestras> findAllBySolicitudServicioClienteMuestrasId(Long id);
    Long countSolicitudServicioClienteMuestrasBySolicitudServicioCliente(SolicitudServicioCliente solicitudServicioCliente);
    Long countBySolicitudServicioCliente_SolicitudServicioClienteIdAndEstatus(Long id, String estatus);
}
