package com.azuretest.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${mi.propiedad}")
    private String miPropiedad;
    @GetMapping()
    public ResponseEntity<?> holaMundo(){
        String saludo = "Hola mundo!";
        return new ResponseEntity<>(saludo, HttpStatus.OK);
    }

    @GetMapping("/env")
    public ResponseEntity<?> getENV(){
        String env = "ENV: " + System.getenv("TEST") + " o con mi.propiedad: " + this.miPropiedad;
        return new ResponseEntity<>(env, HttpStatus.OK);
    }
}
