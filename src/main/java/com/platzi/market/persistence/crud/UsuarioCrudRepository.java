package com.platzi.market.persistence.crud;

import java.util.Optional;

import com.platzi.market.persistence.entity.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {
    
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
