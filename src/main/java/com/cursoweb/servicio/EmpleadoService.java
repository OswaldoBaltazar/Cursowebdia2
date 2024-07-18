package com.cursoweb.servicio;

import com.cursoweb.modelo.Empleado;
import com.cursoweb.repositorio.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> getEmpleadoById(Integer id) {
        return empleadoRepository.findById(id);
    }

    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado updateEmpleado(Integer id, Empleado empleadoDetails) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Empleado not found"));
        empleado.setNombre(empleadoDetails.getNombre());
        empleado.setDepartamento(empleadoDetails.getDepartamento());
        empleado.setSueldo(empleadoDetails.getSueldo());
        return empleadoRepository.save(empleado);
    }

    public void deleteEmpleado(Integer id) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Empleado not found"));
        empleadoRepository.delete(empleado);
    }
}
