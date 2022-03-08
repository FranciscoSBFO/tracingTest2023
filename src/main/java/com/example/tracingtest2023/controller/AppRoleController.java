package com.example.tracingtest2023.controller;

//import com.pmisys.admin.api.service.TokenValidator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.tracingtest2023.model.AppRole;
import com.example.tracingtest2023.service.AppRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/appRole")
public class AppRoleController {

    @Autowired
    private AppRoleService appRoleService;

    private static final Logger APP = LoggerFactory.getLogger("info");
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //ListarTodo
    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public List<AppRole> getAll() {
        return appRoleService.findAll();
    }
}
