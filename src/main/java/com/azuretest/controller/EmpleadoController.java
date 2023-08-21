package com.azuretest.controller;

import com.azuretest.model.Empleado;
import com.azuretest.repository.IEmpleadoRepository;
import com.azuretest.service.interfaces.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/empleado")
public class EmpleadoController {

    private IEmpleadoRepository empleadoRepository;
    private IEmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(IEmpleadoRepository empleadoRepository, IEmpleadoService empleadoService) {
        this.empleadoRepository = empleadoRepository;
        this.empleadoService = empleadoService;
        //Mock datos empleados
        Empleado e1 = new Empleado(1L, "Ana", 20);
        Empleado e2 = new Empleado(2L, "Juan", 30);
        Empleado e3 = new Empleado(3L, "Jose", 40);
        Empleado e4 = new Empleado(4L, "Laura", 50);
        this.empleadoRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
    }

    @GetMapping()
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleados = this.empleadoRepository.findAll();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmpleadoById(@PathVariable Long id) {
        Optional<Empleado> empleado = this.empleadoRepository.findById(id);
        if (!this.empleadoRepository.existsById(id)) {
            return new ResponseEntity<>("No existe el objeto", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(empleado.get(), HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createEmpleado(@RequestBody Empleado empleado) {
        return new ResponseEntity<>(this.empleadoRepository.save(empleado), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmpleadoById(@PathVariable Long id, @RequestBody Empleado empleado) {
        Optional<Empleado> empleadoEncontrado = this.empleadoRepository.findById(id);
        if (!this.empleadoRepository.existsById(id)) {
            return new ResponseEntity<>("No existe el objeto", HttpStatus.NOT_FOUND);
        }else{
            empleadoEncontrado.get().setNombre(empleado.getNombre());
            empleadoEncontrado.get().setEdad(empleado.getEdad());
            return new ResponseEntity<>( this.empleadoRepository.save(empleadoEncontrado.get()), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmpleadoById(@PathVariable Long id) {
        Optional<Empleado> empleadoEncontrado = this.empleadoRepository.findById(id);
        if (!this.empleadoRepository.existsById(id)) {
            return new ResponseEntity<>("No existe el objeto", HttpStatus.NOT_FOUND);
        } else {
            this.empleadoRepository.deleteById(id);
            return new ResponseEntity<>(empleadoEncontrado.get(), HttpStatus.OK);
        }
    }
}
