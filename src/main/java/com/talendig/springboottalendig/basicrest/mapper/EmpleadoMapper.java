package com.talendig.springboottalendig.basicrest.mapper;

import com.talendig.springboottalendig.basicrest.dto.EmpleadoDTO;
import com.talendig.springboottalendig.basicrest.model.Empleado;

import java.util.Date;

public class EmpleadoMapper {

    //Tendremos métodos para mapear un Empleado a un DTO y viceversa
    public static EmpleadoDTO toEmpleadoDTO(Empleado empleado) {

        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setCreation(new Date());
        empleadoDTO.setId(empleado.getId());
        empleadoDTO.setFullName(empleado.getNombre() + " " + empleado.getApellido());
        return empleadoDTO;
    }

    public static Empleado toEmpleado(EmpleadoDTO empleadoDTO) {
        String[] items = empleadoDTO.getFullName().split(" ");
        Empleado empleado = Empleado.builder().apellido(items[1])
                .nombre(items[0])
                .id(empleadoDTO.getId())
                .build();
        return empleado;
    }

}
