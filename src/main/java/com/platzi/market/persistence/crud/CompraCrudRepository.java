package com.platzi.market.persistence.crud;

import java.util.List;
import java.util.Optional;

import com.platzi.market.persistence.entity.Compra;

import org.springframework.data.repository.CrudRepository;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer>{
    
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
