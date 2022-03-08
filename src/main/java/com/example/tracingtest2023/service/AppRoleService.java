package com.example.tracingtest2023.service;

import com.example.tracingtest2023.model.AppRole;
import com.example.tracingtest2023.repository.AppRoleRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleService {

    @Autowired
    private AppRoleRepository appRoleRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger("info");

    private static final Logger APP = LoggerFactory.getLogger("info");

    public AppRole save(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    public List<AppRole> findAll() {
        return appRoleRepository.findAll();
    }

    public AppRole findById(Long roleId) {
        return appRoleRepository.findByRoleId(roleId);
    }

    public void delete(Long roleId) {
        appRoleRepository.deleteById(roleId);
    }

    public long contar() {
        return appRoleRepository.count();
    }
}
