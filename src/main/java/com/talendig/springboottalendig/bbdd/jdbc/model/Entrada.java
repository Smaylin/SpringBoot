package com.talendig.springboottalendig.bbdd.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrada {

    @NotNull
    private long id;
    @NotNull
    @Size(min=2, max=100)
    private String pelicula;
    @Min(2)
    private double precio;
    private Date fecha;

}
