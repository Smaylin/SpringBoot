package com.talendig.springboottalendig.bbdd.mongo.repository;

import com.talendig.springboottalendig.bbdd.mongo.model.Alumno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "alumnos", path = "apialumnos")
public interface AlumnoRepository extends MongoRepository<Alumno, Integer> {

    List<Alumno> findByNombreContains(String nombre);
    List<Alumno> findByApellidoEqualsIgnoreCase(String apellido);

}
