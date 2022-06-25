package com.talendig.springboottalendig.bbdd.mongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Data
@Document(collection = "colegio")
public class Colegio {

    @Id
    private String codigo;
    private String nombre;
    private String localidad;

}
