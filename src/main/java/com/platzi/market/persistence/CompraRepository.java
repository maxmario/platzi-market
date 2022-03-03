package com.platzi.market.persistence;

import java.util.List;
import java.util.Optional;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.PurchaseRepository;
import com.platzi.market.persistence.crud.CompraCrudRepository;
import com.platzi.market.persistence.entity.Compra;
import com.platzi.market.persistence.mapper.PurcharseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurcharseMapper purcharseMapper;

    @Override
    public List<Purchase> getAll() {
        return purcharseMapper.toPurcharses((List<Compra>)compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId).map(compras -> purcharseMapper.toPurcharses(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purcharseMapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return purcharseMapper.toPurcharse(compraCrudRepository.save(compra));
    }
    
}
