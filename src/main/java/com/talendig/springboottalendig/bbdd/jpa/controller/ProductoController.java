package com.talendig.springboottalendig.bbdd.jpa.controller;

import com.talendig.springboottalendig.bbdd.jpa.model.Producto;
import com.talendig.springboottalendig.bbdd.jpa.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo/bbdd/jpa")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping(value = "/productos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> selectProductos() {
        return ResponseEntity.ok(productoService.getProductos());
    }

    @GetMapping(value = "/productos/escasos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> selectProductosEscasos() {
        return ResponseEntity.ok(productoService.getProductosEscasos());
    }

    @PostMapping(path="/producto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insertProducto(@RequestBody(required = true) Producto producto) {
        productoService.insertProducto(producto);
        return  ResponseEntity.ok().build();
    }

    @DeleteMapping(path="/producto/{idProducto}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer idProducto) {
        productoService.deleteProducto(idProducto);
        return  ResponseEntity.ok().build();
    }

}
