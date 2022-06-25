package com.talendig.springboottalendig.bbdd.jpa.service;

import com.talendig.springboottalendig.bbdd.jdbc.model.Entrada;
import com.talendig.springboottalendig.bbdd.jpa.model.Producto;
import com.talendig.springboottalendig.bbdd.jpa.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }
    public List<Producto> getProductosEscasos() {
        return productoRepository.findByStockLessThan(10);
    }

    public void insertProducto(Producto producto) {
        productoRepository.save(producto);
    }

    public void deleteProducto(int idProducto) {
        productoRepository.deleteById(idProducto);
    }

}
