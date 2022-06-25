package com.talendig.springboottalendig.basicrest.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Empleado {

    private String id;
    private String nombre;
    private String apellido;

}
