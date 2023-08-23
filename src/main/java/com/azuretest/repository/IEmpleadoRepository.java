package com.azuretest.repository;

import com.azuretest.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {
}
