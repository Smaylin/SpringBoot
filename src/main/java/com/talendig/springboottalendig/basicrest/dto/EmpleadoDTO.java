package com.talendig.springboottalendig.basicrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@NoArgsConstructor //Añade un constructor sin parámetros.
@AllArgsConstructor //Añade un constructor para todos los parámetros. Finales incluidos.
public class EmpleadoDTO {

    @NotNull //No nulo, es decir, no venga a null, y debe aparecer
    @NotEmpty //No sea vacío ''
    @NotBlank //Not blank -> tiene que tener algun caracter '  '
    private String id;
    @Size(max = 20, min = 5)
    private String fullName;
    private Date creation;
    @Positive
    @Min(1000)
    @Max(9000)
    private double salario;
    @Email
    private String email;

}
