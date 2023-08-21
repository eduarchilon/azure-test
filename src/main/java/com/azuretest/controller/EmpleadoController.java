package com.azuretest.controller;

import com.azuretest.model.Empleado;
import com.azuretest.repository.IEmpleadoRepository;
import com.azuretest.service.interfaces.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/empleado")
public class EmpleadoController {

    private IEmpleadoRepository empleadoRepository;
    private IEmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(IEmpleadoRepository empleadoRepository, IEmpleadoService empleadoService) {
        this.empleadoRepository = empleadoRepository;
        this.empleadoService = empleadoService;
    }

    @GetMapping()
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        //Mock datos empleados
        Empleado e1 = new Empleado(1L, "Ana", 20);
        Empleado e2 = new Empleado(2L, "Juan", 30);
        Empleado e3 = new Empleado(3L, "Jose", 40);
        this.empleadoRepository.saveAll(Arrays.asList(e1, e2, e3));
        List<Empleado> empleados = this.empleadoRepository.findAll();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }
}
