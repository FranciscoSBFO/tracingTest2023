package com.example.tracingtest2023.model;

import java.util.Map;

public class ListaContactos {

    private Map<String, String> contactos;


    public Map<String, String> getContactos() {
        return contactos;
    }

    public void setContactos(Map<String, String> contactos) {
        this.contactos = contactos;
    }

    @Override
    public String toString() {
        return "ListaContactos{" +
                "contactos=" + contactos +
                '}';
    }
}
