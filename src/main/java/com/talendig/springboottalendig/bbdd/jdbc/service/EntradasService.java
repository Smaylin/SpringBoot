package com.talendig.springboottalendig.bbdd.jdbc.service;

import com.talendig.springboottalendig.bbdd.jdbc.model.Entrada;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntradasService {

    //Para acceder por JDBC a base de datos, utilizamos JdbcTemplate
    private final JdbcTemplate jdbcTemplate;

    public EntradasService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Entrada> getEntradas() {

        return jdbcTemplate.query("SELECT * FROM ENTRADAS", (resultSet, i) ->
                new Entrada(resultSet.getInt("id"), resultSet.getString("pelicula"),
                        resultSet.getDouble("precio"), resultSet.getDate("fecha")));

    }

    @Transactional
    public void insert(Entrada entrada) {
        jdbcTemplate.update("INSERT INTO ENTRADAS VALUES (? ,?, ?, ?)", entrada.getId(),
                entrada.getPelicula(), entrada.getPrecio(), entrada.getFecha());
    }

    public List<String> getPeliculas() {
        return jdbcTemplate.query("SELECT PELICULA FROM ENTRADAS", (resultSet, i) ->
                resultSet.getString("pelicula"));
    }

    public void deletePelicula(String id) {
        jdbcTemplate.update("DELETE FROM ENTRADAS WHERE ID = ?", id);
    }


}
