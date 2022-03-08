package com.example.tracingtest2023.service;

import com.example.tracingtest2023.model.DocumentOrdenServicio;
import com.example.tracingtest2023.repository.DocumentOrdenServicioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceOrdenServicio {

    @Autowired
    DocumentOrdenServicioRepository documentOrdenServicioRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger("info");

    private static final Logger APP = LoggerFactory.getLogger("info");

    /*public ResponseEntity<?> save(Map<String, String> request) {
        DocumentOrdenServicio documentOrdenServicio=new DocumentOrdenServicio();
        



        documentOrdenServicioRepository.save(documentOrdenServicio);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
    public DocumentOrdenServicio save(DocumentOrdenServicio documentOrdenServicio) {
        return documentOrdenServicioRepository.save(documentOrdenServicio);
    }

    public List<DocumentOrdenServicio> findAll() {
        return documentOrdenServicioRepository.findAll();
    }

    public DocumentOrdenServicio findById(Long id) {
        return documentOrdenServicioRepository.findByOrdenServicioId(id);
    }

    public void delete(Long methodId) {
        documentOrdenServicioRepository.deleteById(methodId);
    }

    public long contar() {
        return documentOrdenServicioRepository.count();
    }
}
