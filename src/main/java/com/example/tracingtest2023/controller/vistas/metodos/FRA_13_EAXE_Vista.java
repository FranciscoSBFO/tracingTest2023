package com.example.tracingtest2023.controller.vistas.metodos;

import com.example.tracingtest2023.model.operacion.MetodoMuestra;
import com.example.tracingtest2023.model.operacion.RecepcionVerificacionRegistroCodificacion;
import com.example.tracingtest2023.model.operacion.metodos.fra13eaxe.FRA_EAXE_013;
import com.example.tracingtest2023.model.operacion.metodos.fra13eaxe.datas.FRA_EAXE_013_DATA;
import com.example.tracingtest2023.service.operacion.MetodoMuestraService;
import com.example.tracingtest2023.service.operacion.RecepcionVerificacionRegistroCodificacionService;
import com.example.tracingtest2023.service.operacion.metodos.FRA_EAXE_013_DATA_Service;
import com.example.tracingtest2023.service.operacion.metodos.FRA_EAXE_013_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@CrossOrigin
public class FRA_13_EAXE_Vista {

    @Autowired
    private FRA_EAXE_013_Service fra_eaxe_013_service;

    @Autowired
    private FRA_EAXE_013_DATA_Service fra_eaxe_013_data_service;

    @Autowired
    private MetodoMuestraService metodoMuestraService;

    @Autowired
    private RecepcionVerificacionRegistroCodificacionService recepcionVerificacionRegistroCodificacionService;

    //Muestra formulario de registro inicial
    @RequestMapping(value = "/registerFRAEAXE/{id}")
    public String registerFRAEAXE(Model model, Principal principal, @PathVariable("id") Long id) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        Collection<GrantedAuthority> review = loginedUser.getAuthorities();

        for (GrantedAuthority a : review) {
            model.addAttribute("role", a.getAuthority());
        }

        MetodoMuestra metodoMuestra = metodoMuestraService.findById(id);
        RecepcionVerificacionRegistroCodificacion recepcionVerificacionRegistroCodificacion = recepcionVerificacionRegistroCodificacionService.findBySolicitudServicioClienteMuestrasId(metodoMuestra.getSolicitudServicioClienteMuestras().getSolicitudServicioClienteMuestrasId());
        Date ahora = new Date();
        SimpleDateFormat ahoraFormato = new SimpleDateFormat("yyyy-MM-dd", new Locale("ES"));
        String fechaHoy = ahoraFormato.format(ahora);
        System.out.println(fechaHoy);

        model.addAttribute("folioSolicitudServicioInterno", metodoMuestra.getSolicitudServicioClienteMuestras().getSolicitudServicioCliente().getFolioSolitudServicioCliente());
        model.addAttribute("idInternoMuestra", recepcionVerificacionRegistroCodificacion.getIdInternoMuestra1());
        model.addAttribute("folioTecnica", metodoMuestra.getFolioTecnica());
        model.addAttribute("fechaHoy", fechaHoy);

        return "content/operacion/metodos/FRA_13_EAXE/formFRA_EAXE";
    }

    //Muestra formulario de registro de numero e imagen
    @RequestMapping(value = "/agregarFRAEAXE/{id}")
    public String agregarFRAEAXE(Model model, Principal principal, @PathVariable("id") Long id) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        Collection<GrantedAuthority> review = loginedUser.getAuthorities();

        for (GrantedAuthority a : review) {
            model.addAttribute("role", a.getAuthority());
        }

        return "content/operacion/metodos/FRA_13_EAXE/formFRA_EAXE2";
    }

    //Muestra formulario de registro para terminar
    @RequestMapping(value = "/terminarFRAEAXE/{id}")
    public String terminarFRAEAXE(Model model, Principal principal, @PathVariable("id") Long id) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        Collection<GrantedAuthority> review = loginedUser.getAuthorities();

        for (GrantedAuthority a : review) {
            model.addAttribute("role", a.getAuthority());
        }

        return "content/operacion/metodos/FRA_13_EAXE/formFRA_EAXE3";
    }

    //Muestra la lista principal
    @RequestMapping("/listFRAEAXE")
    public String listFRAEAXE(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        Collection<GrantedAuthority> review = loginedUser.getAuthorities();

        for (GrantedAuthority a : review) {
            model.addAttribute("role", a.getAuthority());
        }

        List<FRA_EAXE_013> lista = fra_eaxe_013_service.findAll();
        model.addAttribute("fraeaxe", lista);

        return "content/operacion/metodos/FRA_13_EAXE/listFRA_EAXE";
    }

    //Muestra Lo que lleva cada uno
    @RequestMapping(value = "/verFRAEAXE/{id}")
    public String verFRAEAXE(Model model, Principal principal, @PathVariable("id") Long id) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        Collection<GrantedAuthority> review = loginedUser.getAuthorities();

        for (GrantedAuthority a : review) {
            model.addAttribute("role", a.getAuthority());
        }

        FRA_EAXE_013 eaxe = fra_eaxe_013_service.findById(id);
        List<FRA_EAXE_013_DATA> lista = fra_eaxe_013_data_service.buscarPorEnsayo(id);

        model.addAttribute("eaxe", eaxe);
        model.addAttribute("lista", lista);

        return "content/operacion/metodos/FRA_13_EAXE/verFRA_EAXE";
    }
}
