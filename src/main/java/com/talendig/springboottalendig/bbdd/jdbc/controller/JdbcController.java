package com.talendig.springboottalendig.bbdd.jdbc.controller;

import com.talendig.springboottalendig.bbdd.jdbc.model.Entrada;
import com.talendig.springboottalendig.bbdd.jdbc.service.EntradasService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/demo/bbdd/jdbc")
@AllArgsConstructor
public class JdbcController {
    @Autowired
    private final EntradasService entradasService;

    @GetMapping(value = "/entradas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Entrada>> getEntradas() {
        return ResponseEntity.ok(entradasService.getEntradas());
    }

    @PostMapping(value = "/entrada", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addEntrada(@RequestBody @Valid Entrada entrada) {
        entradasService.insert(entrada);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value="/peliculas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getPeliculas() {
        return ResponseEntity.ok(entradasService.getPeliculas());
    }

    @DeleteMapping(value="/pelicula/{id}")
    public ResponseEntity<Void> deletePelicula(@PathVariable(required = true) String id) {
        entradasService.deletePelicula(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
