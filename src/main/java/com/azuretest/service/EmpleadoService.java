package com.azuretest.service;

import com.azuretest.model.Empleado;
import com.azuretest.repository.IEmpleadoRepository;
import com.azuretest.service.interfaces.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService{

    private IEmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(IEmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }
}
