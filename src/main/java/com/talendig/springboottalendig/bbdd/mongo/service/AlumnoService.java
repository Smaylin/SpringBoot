package com.talendig.springboottalendig.bbdd.mongo.service;

import com.talendig.springboottalendig.bbdd.mongo.model.Alumno;
import com.talendig.springboottalendig.bbdd.mongo.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    private AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> getAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos;
    }

}
