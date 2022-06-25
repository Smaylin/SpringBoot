package com.talendig.springboottalendig.bbdd.jpa.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "producto") //Name se refiere a la tabla de BBDD
public class Producto {

    @Id //Clave Primaria
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_producto;
    private String descripcion;
    private float precio;
    private int stock;
    private char tipo;

}
