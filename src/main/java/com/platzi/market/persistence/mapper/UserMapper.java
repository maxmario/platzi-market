package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.User;
import com.platzi.market.persistence.entity.Usuario;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    @Mappings(
        {
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "nombreUsuario", target = "userName"),
            @Mapping(source = "contraUsuario", target = "userPass"),
            @Mapping(source = "estado", target = "active")
        }
    )
    User toUser(Usuario usuario);

    @InheritInverseConfiguration
    Usuario toUsuario(User user);
}
