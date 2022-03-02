package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurcharseItem;
import com.platzi.market.persistence.entity.ComprasProducto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurcharseItemMapper {
    
    @Mappings(
        {
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
        }
    )
    PurcharseItem toPurcharseItem(ComprasProducto comprasProducto);

    @InheritInverseConfiguration
    @Mappings(
        {
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
        }
    )
    ComprasProducto toComprasProducto(PurcharseItem purcharseItem);
}
