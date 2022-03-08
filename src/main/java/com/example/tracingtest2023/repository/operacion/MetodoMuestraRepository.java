package com.example.tracingtest2023.repository.operacion;

import com.example.tracingtest2023.model.operacion.MetodoMuestra;

import com.example.tracingtest2023.model.operacion.SolicitudServicioCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MetodoMuestraRepository extends JpaRepository<MetodoMuestra, Long>{
    MetodoMuestra findByMetodoMuestraId(Long id);
    MetodoMuestra findBySolicitudServicioClienteMuestras_SolicitudServicioClienteMuestrasId(Long id);
    void deleteAllBySolicitudServicioClienteMuestras_SolicitudServicioClienteMuestrasId(Long id);
    List<MetodoMuestra> findAllByMethod_MethodId(Long id);
    List<MetodoMuestra> findAllBySolicitudServicioClienteMuestras_SolicitudServicioClienteMuestrasId(Long id);
    //List<MetodoMuestra> findAllBySolicitudServicioClienteSolicitudServicioClienteIdMuestras_SolicitudServicioCliente(SolicitudServicioCliente solicitudServicioCliente);
    List<MetodoMuestra> findAllBySolicitudServicioClienteMuestras_SolicitudServicioCliente(SolicitudServicioCliente solicitudServicioCliente);
    List<MetodoMuestra> findAllByMetodoMuestraId(Long id);
    Long countBySolicitudServicioClienteMuestras_SolicitudServicioClienteAndEstatus(SolicitudServicioCliente solicitudServicioCliente, String Estatus);
}
