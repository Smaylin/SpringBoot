package com.talendig.springboottalendig.basicrest.controller;

import com.talendig.springboottalendig.basicrest.dto.EmpleadoDTO;
import com.talendig.springboottalendig.basicrest.model.Empleado;
import com.talendig.springboottalendig.basicrest.service.EmpleadoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/demo/basicrest")
@AllArgsConstructor
@Slf4j //Con Slf4j -> plugin de Log4j para Spring Boot. Para logs.
public class BasicRestController {

    private final EmpleadoService empleadoService;

    //Definimos nuestros endpoints dentro del Controller.
    //Por ejemplo, el caso más basico, un endpoint de tipo GET.
    @GetMapping(value="/empleados", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmpleadoDTO>> getEmpleados() {
        List<EmpleadoDTO> empleados = empleadoService.getEmpleados();
        return ResponseEntity.ok(empleados);
    }

    //Queremos obtener un empleado en concreto. A través de su id.
    @GetMapping(value="/empleado/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpleadoDTO> getEmpleado(@PathVariable String id) {
        EmpleadoDTO empleados = empleadoService.getEmpleado(id);
        log.debug("Devolviendo empleado: " + empleados.toString());
        return ResponseEntity.ok(empleados);
    }

    //Método para añadir o crear (POST) un empleado a la lista
    @PostMapping(value="/empleado", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addEmpleado(@RequestBody @Valid EmpleadoDTO empleadoDTO) {
        empleadoService.addEmpleado(empleadoDTO);
        return ResponseEntity.ok().build();

    }

    @PutMapping(value="/empleado", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        empleadoService.updateEmpleado(empleadoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/empleado/{id}")
    public ResponseEntity<Empleado> deleteEmpleado(@PathVariable(required = true) String id) {
        empleadoService.deleteEmpleado(id);
        return ResponseEntity.ok().build();
    }

}
