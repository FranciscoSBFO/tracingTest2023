package com.example.tracingtest2023.controller.vistas.metodos;

import com.example.tracingtest2023.model.operacion.MetodoMuestra;
import com.example.tracingtest2023.model.operacion.RecepcionVerificacionRegistroCodificacion;
import com.example.tracingtest2023.service.operacion.MetodoMuestraService;
import com.example.tracingtest2023.service.operacion.RecepcionVerificacionRegistroCodificacionService;
import com.example.tracingtest2023.utils.WebUtils;
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
import java.util.Locale;

@Controller
@CrossOrigin
public class FRA_04_GR_Vista {

    @Autowired
    private MetodoMuestraService metodoMuestraService;

    @Autowired
    private RecepcionVerificacionRegistroCodificacionService recepcionVerificacionRegistroCodificacionService;

    @RequestMapping(value = "/registerFRAGR/{id}")
    public String registerFRAGR(Model model, Principal principal, @PathVariable("id") Long id) {
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

        model.addAttribute("folioSolicitudServicioInterno", metodoMuestra.getSolicitudServicioClienteMuestras().getSolicitudServicioCliente().getFolioSolitudServicioCliente());
        model.addAttribute("idInternoMuestra", recepcionVerificacionRegistroCodificacion.getIdInternoMuestra1());
        model.addAttribute("folioTecnica", metodoMuestra.getFolioTecnica());
        model.addAttribute("fechaHoy", fechaHoy);

        return "content/operacion/metodos/FRA_04_GR/formFRA_GR";
    }

    @RequestMapping("/listFRAGR")
    public String listFRAGR(Model model, Principal principal) {
        // After user login successfully.
        String userName = principal.getName();

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);

        Collection<GrantedAuthority> review = loginedUser.getAuthorities();

        model.addAttribute("userName", userName);
        model.addAttribute("userInfo", userInfo);

        for (GrantedAuthority a : review) {
            model.addAttribute("role", a.getAuthority());
        }

        return "content/operacion/metodos/FRA_04_GR/listFRA_GR";
    }
}
