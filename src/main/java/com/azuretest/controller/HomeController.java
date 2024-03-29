package com.azuretest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HomeController {

    /*@Value("${TEST}")
    private String miPropiedad;*/

    @GetMapping()
    public ResponseEntity<?> holaMundo() {
        String saludo = "Hola mundo!";
        return new ResponseEntity<>(saludo, HttpStatus.OK);
    }

    @GetMapping("/env")
    public ResponseEntity<?> getENV() {
        //String env = "ENV: " + System.getenv("TEST") + " o con mi.propiedad: " + this.miPropiedad;
        String env = "ENV: " + System.getenv("TEST");
        String db = "SQLCONNSTR_URI" +  System.getenv("SQLCONNSTR_URI");
        List<String> data = Arrays.asList(env, db);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
