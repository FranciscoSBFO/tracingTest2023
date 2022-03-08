package com.example.tracingtest2023.service.formatos;

import java.io.*;
import java.net.URL;
import java.util.*;

import com.example.tracingtest2023.model.operacion.MetodoMuestra;
import com.example.tracingtest2023.model.operacion.RecepcionVerificacionRegistroCodificacion;
import com.example.tracingtest2023.model.operacion.SolicitudServicioCliente;
import com.example.tracingtest2023.service.operacion.MetodoMuestraService;
import com.example.tracingtest2023.service.operacion.RecepcionVerificacionRegistroCodificacionService;
import com.example.tracingtest2023.service.operacion.SolicitudServicioClienteMuestrasService;
import com.example.tracingtest2023.service.operacion.SolicitudServicioClienteService;
import com.example.tracingtest2023.utils.EstructuraNombres;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FEIL_MIE_007_Service {

    @Autowired
    private SolicitudServicioClienteService solicitudServicioClienteService;

    @Autowired
    private SolicitudServicioClienteMuestrasService solicitudServicioClienteMuestrasService;

    @Autowired
    private MetodoMuestraService metodoMuestraService;

    @Autowired
    private RecepcionVerificacionRegistroCodificacionService recepcionVerificacionRegistroCodificacionService;

    EstructuraNombres estructuraNombres = new EstructuraNombres();

    public ResponseEntity<InputStreamResource> crearFormato(Long id, int band) throws InvalidFormatException, IOException {
        List<MetodoMuestra> lista;
        RecepcionVerificacionRegistroCodificacion recepcionVerificacionRegistroCodificacion = new RecepcionVerificacionRegistroCodificacion();
        if (band == 1){
            recepcionVerificacionRegistroCodificacion = recepcionVerificacionRegistroCodificacionService.findById(id);
            lista = metodoMuestraService.findAllByMuestra(recepcionVerificacionRegistroCodificacion.getSolicitudServicioClienteMuestras().getSolicitudServicioClienteMuestrasId());
            //SolicitudServicioCliente solicitudServicioCliente = solicitudServicioClienteService.findById(id);
        } if (band == 3){
            SolicitudServicioCliente solicitudServicioCliente = solicitudServicioClienteService.findById(id);
            lista = metodoMuestraService.findAllBySolicitud(solicitudServicioCliente);

        } else {
            lista = metodoMuestraService.findAllById(id);
            recepcionVerificacionRegistroCodificacion = recepcionVerificacionRegistroCodificacionService.findBySolicitudServicioClienteMuestrasId(lista.get(0).getSolicitudServicioClienteMuestras().getSolicitudServicioClienteMuestrasId());
        }


        String pathLista = "/documentos/FEIL_MIE_007/FEIL-MIE-007-" + lista.size() + ".docx";
        ClassPathResource resource = new ClassPathResource(pathLista);
        XWPFDocument doc = new XWPFDocument(resource.getInputStream());

        XWPFTable table;
        for (int i = 0; i < lista.size(); i++) {
            table = doc.getTables().get(i);
            if (band !=3 ){
                table.getRow(1).getCell(1).setText(recepcionVerificacionRegistroCodificacion.getIdInternoMuestra1());
                table.getRow(2).getCell(1).setText(lista.get(i).getMethod().getCodigoMetodo());
                table.getRow(3).getCell(1).setText(recepcionVerificacionRegistroCodificacion.getSolicitudServicioClienteMuestras().getObservaciones());

                XWPFParagraph paragraph = table.getRow(4).getCell(1).addParagraph();
                XWPFRun run = paragraph.createRun();
                //FileInputStream fis = new FileInputStream(lista.get(i).getPathQRLab());
                InputStream fis = new URL(lista.get(i).getPathQRLab()).openStream();
                XWPFPicture picture = run.addPicture(fis, XWPFDocument.PICTURE_TYPE_PNG, "Name", Units.pixelToEMU(130), Units.pixelToEMU(130));
            } else {
                try{
                    RecepcionVerificacionRegistroCodificacion recepcionVerificacionRegistroCodificacion1 = recepcionVerificacionRegistroCodificacionService.findBySolicitudServicioClienteMuestrasId(lista.get(i).getSolicitudServicioClienteMuestras().getSolicitudServicioClienteMuestrasId());
                    table.getRow(1).getCell(1).setText(recepcionVerificacionRegistroCodificacion1.getIdInternoMuestra1());
                    table.getRow(2).getCell(1).setText(lista.get(i).getMethod().getCodigoMetodo());
                    table.getRow(3).getCell(1).setText(recepcionVerificacionRegistroCodificacion1.getSolicitudServicioClienteMuestras().getObservaciones());

                    XWPFParagraph paragraph = table.getRow(4).getCell(1).addParagraph();
                    XWPFRun run = paragraph.createRun();
                    //FileInputStream fis = new FileInputStream(lista.get(i).getPathQRLab());
                    InputStream fis = new URL(lista.get(i).getPathQRLab()).openStream();
                    XWPFPicture picture = run.addPicture(fis, XWPFDocument.PICTURE_TYPE_PNG, "Name", Units.pixelToEMU(130), Units.pixelToEMU(130));
                } catch (NullPointerException e){
                    System.out.println("No se han hecho todas las recepciones");
                }
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=FEIL_MIE_" + lista.get(0).getSolicitudServicioClienteMuestras().getSolicitudServicioCliente().getFolioSolitudServicioCliente() + ".docx");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
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
