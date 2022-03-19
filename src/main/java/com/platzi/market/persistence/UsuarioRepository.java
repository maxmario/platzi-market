package com.platzi.market.persistence;

import java.util.Optional;

import com.platzi.market.domain.User;
import com.platzi.market.domain.repository.UserRepository;
import com.platzi.market.persistence.crud.UsuarioCrudRepository;
import com.platzi.market.persistence.entity.Usuario;
import com.platzi.market.persistence.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Optional<User> getUser(int userId) {
        Optional<Usuario> usuario = usuarioCrudRepository.findById(userId);
        return usuario.map(usr -> userMapper.toUser(usr));
    }

    @Override
    public Optional<User> getByUserName(String userName) {
        Optional<Usuario> usuario = usuarioCrudRepository.findByNombreUsuario(userName);
        return usuario.map(usr -> userMapper.toUser(usr));
    }
    
}
