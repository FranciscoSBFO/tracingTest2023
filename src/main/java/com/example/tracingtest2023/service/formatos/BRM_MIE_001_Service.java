package com.example.tracingtest2023.service.formatos;

import java.io.*;
import java.util.*;

import com.example.tracingtest2023.model.operacion.RecepcionVerificacionRegistroCodificacion;
import com.example.tracingtest2023.service.operacion.RecepcionVerificacionRegistroCodificacionService;
import com.example.tracingtest2023.service.operacion.SolicitudServicioClienteMuestrasService;
import com.example.tracingtest2023.service.operacion.SolicitudServicioClienteService;
import com.example.tracingtest2023.utils.EstructuraNombres;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class   BRM_MIE_001_Service {

    @Autowired
    private SolicitudServicioClienteService solicitudServicioClienteService;

    @Autowired
    private SolicitudServicioClienteMuestrasService solicitudServicioClienteMuestrasService;

    @Autowired
    private RecepcionVerificacionRegistroCodificacionService recepcionVerificacionRegistroCodificacionService;

    EstructuraNombres estructuraNombres = new EstructuraNombres();

    public ResponseEntity<InputStreamResource> crearFormato() throws InvalidFormatException, IOException{
        ClassPathResource resource = new ClassPathResource("/documentos/BRM-MIE-001.docx");
        XWPFDocument doc = new XWPFDocument(resource.getInputStream());
        List<RecepcionVerificacionRegistroCodificacion> lista = recepcionVerificacionRegistroCodificacionService.findAll();

        List<String>contactosAux;
        int bandera=0;

        XWPFTable table = doc.getTables().get(0);
        for (int i = 0; i<lista.size(); i++) {
            XWPFTableRow tableRow = table.createRow();
            tableRow.getCell(0).setText((i+1)+"");
            tableRow.getCell(1).setText(lista.get(i).getSolicitudServicioClienteMuestras().getSolicitudServicioCliente().getFolioSolitudServicioCliente());
            tableRow.getCell(2).setText(lista.get(i).getIdInternoMuestra1());
            tableRow.getCell(3).setText(lista.get(i).getSolicitudServicioClienteMuestras().getIdClienteMuestra());
            tableRow.getCell(4).setText(lista.get(i).getCantidadMuestraAnalisis());
            tableRow.getCell(5).setText(lista.get(i).getCantidadMuestraRetencion());
            tableRow.getCell(6).setText(lista.get(i).getUbicacionMuestraRetencion());
            tableRow.getCell(7).setText(lista.get(i).getSolicitudServicioClienteMuestras().getCondicionesEspeciales());
            tableRow.getCell(8).setText(lista.get(i).getCantidadMuestraEntregada());
            tableRow.getCell(9).setText(lista.get(i).getSolicitudServicioClienteMuestras().getObservaciones());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=BRM_MIE_"+lista.get(0).getSolicitudServicioClienteMuestras().getSolicitudServicioCliente().getFolioSolitudServicioCliente()+".docx");
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        doc.write(byteArrayOutputStream);
        doc.close();
        MediaType word = MediaType.valueOf("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(word)
                .body(new InputStreamResource(byteArrayInputStream));
    }
}
