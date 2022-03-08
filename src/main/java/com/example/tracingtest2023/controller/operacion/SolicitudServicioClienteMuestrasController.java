package com.example.tracingtest2023.controller.operacion;

import com.example.tracingtest2023.model.operacion.SolicitudServicioClienteMuestras;
import com.example.tracingtest2023.service.ClientService;
import com.example.tracingtest2023.service.FoliosService;
import com.example.tracingtest2023.service.MethodService;
import com.example.tracingtest2023.service.QR.QRService;
import com.example.tracingtest2023.service.formatos.FEIM_SOC_005_Service;
import com.example.tracingtest2023.service.formatos.FSS_SOC_001_Service;
import com.example.tracingtest2023.service.operacion.SolicitudServicioClienteMuestrasService;
import com.example.tracingtest2023.service.operacion.SolicitudServicioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/solicitudServicioClienteMuestras")
public class SolicitudServicioClienteMuestrasController {
    @Autowired
    private SolicitudServicioClienteService solicitudServicioClienteService;

    @Autowired
    private SolicitudServicioClienteMuestrasService solicitudServicioClienteMuestrasService;

    @Autowired
    private FoliosService foliosService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private MethodService methodService;

    @Autowired
    private FSS_SOC_001_Service fss_soc_001_service;

    @Autowired
    private FEIM_SOC_005_Service feim_soc_005_service;

    @Autowired
    private QRService qrService;

    //ListarTodo
    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public List<SolicitudServicioClienteMuestras> getAll() {
        return solicitudServicioClienteMuestrasService.findAll();
    }

    //ListarUnElemento
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public List<SolicitudServicioClienteMuestras> getbyidsolicitud(@PathVariable("id") Long id) {
        return solicitudServicioClienteMuestrasService.findAllBySolicitud(id);
    }

    //ListarUnElemento
    @RequestMapping(method = RequestMethod.GET, value = "/uno/{id}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public SolicitudServicioClienteMuestras getbyid(@PathVariable("id") Long id) {
        return solicitudServicioClienteMuestrasService.findById(id);
    }
}
