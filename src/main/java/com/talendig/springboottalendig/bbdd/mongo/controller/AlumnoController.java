package com.talendig.springboottalendig.bbdd.mongo.controller;


import com.talendig.springboottalendig.bbdd.mongo.model.Alumno;
import com.talendig.springboottalendig.bbdd.mongo.service.AlumnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo/bbdd/mongo")
@AllArgsConstructor //Para generar el constructor para inyectar el AlumnoService
public class AlumnoController {

    private final AlumnoService alumnoService;

    @GetMapping(value = "/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Alumno>> getAlumnos() {
        return ResponseEntity.ok(alumnoService.getAlumnos());
    }

}
