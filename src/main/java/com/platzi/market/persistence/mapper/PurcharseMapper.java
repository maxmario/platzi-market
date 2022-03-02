package com.platzi.market.persistence.mapper;

import java.util.List;

import com.platzi.market.domain.Purchase;
import com.platzi.market.persistence.entity.Compra;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {PurcharseItemMapper.class})
public interface PurcharseMapper {
    
    @Mappings(
        {
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "items")
        }
    )
    Purchase toPurcharse(Compra compra);

    List<Purchase> toPurcharses(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase purchase);
}
