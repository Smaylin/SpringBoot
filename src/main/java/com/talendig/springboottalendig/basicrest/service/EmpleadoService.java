package com.talendig.springboottalendig.basicrest.service;

import com.talendig.springboottalendig.basicrest.dto.EmpleadoDTO;
import com.talendig.springboottalendig.basicrest.mapper.EmpleadoMapper;
import com.talendig.springboottalendig.basicrest.model.Empleado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //Anotacion para indicar que esta clase es un Servicio -> Stereotype
public class EmpleadoService {

    private List<Empleado> listaEmpleados = new ArrayList<>(); //El servicio es responsable de la gestión de la lista y de la lógica de negocio

    public List<EmpleadoDTO> getEmpleados() {
        List<EmpleadoDTO> empleadoDTOS = new ArrayList<>();
        for(Empleado emp : listaEmpleados) {
            empleadoDTOS.add(EmpleadoMapper.toEmpleadoDTO(emp));
        }
        return empleadoDTOS;
    }

    public EmpleadoDTO getEmpleado(String id) {
        //Buscamos en la lista el empleado con ese id, y generamos el DTO.
        EmpleadoDTO empleadoDTO = null;
        for (Empleado emp : listaEmpleados) {
            if (emp.getId().equalsIgnoreCase(id)) {
                empleadoDTO = EmpleadoMapper.toEmpleadoDTO(emp);
            }
        }
        return empleadoDTO;
    }

    public void addEmpleado(EmpleadoDTO empleadoDTO) {
        listaEmpleados.add(EmpleadoMapper.toEmpleado(empleadoDTO));
    }

    public void updateEmpleado(EmpleadoDTO empleadoDTO) {
        for (Empleado emp : listaEmpleados) {
            if (emp.getId().equalsIgnoreCase(empleadoDTO.getId())) {
                String[] nombreApellido = empleadoDTO.getFullName().split(" ");
                //Actualizamos el empleado.
                emp.setNombre(nombreApellido[0]);
                emp.setApellido(nombreApellido[1]);
            }
        }
    }

    public void deleteEmpleado(String id) {
        for (Empleado emp : listaEmpleados) {
            if (emp.getId().equalsIgnoreCase(id)) {
                listaEmpleados.remove(emp);
            }
        }
    }
}
