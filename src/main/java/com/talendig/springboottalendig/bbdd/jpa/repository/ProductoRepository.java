package com.talendig.springboottalendig.bbdd.jpa.repository;

import com.talendig.springboottalendig.bbdd.jpa.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    //SELECT * FROM PRODUCTO WHERE STOCK > CANTIDAD
    List<Producto> findByStockGreaterThan(int cantidad);
    //SELECT * FROM PRODUCTO WHERE STOCK < CANTIDAD
    List<Producto> findByStockLessThan(int cantidad);
    //SELECT * FROM PRODUCTO WHERE DESCRIPCION LIKE '%CADENA%'
    List<Producto> findByDescripcionContains(String cadena);
    List<Producto> findByTipoEqualsOrTipoEquals(String a, String b);

}
