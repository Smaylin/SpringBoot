package com.talendig.springboottalendig.bbdd.mongo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "alumnos")
public class Alumno {

    @Id
    private int id;
    private String nombre;
    private String apellido;
    private DatosContacto datosContacto;
    @DBRef
    private Colegio colegio;

}
