package com.platzi.market.persistence.crud;

import java.util.List;
import java.util.Optional;

import com.platzi.market.persistence.entity.Producto;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer>{
    
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidad_stock, boolean estado);

    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> getByCategoria(int idCategoria);
}
