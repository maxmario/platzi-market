package com.platzi.market.persistence;

import java.util.List;
import java.util.Optional;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository implements ProductRepository{
    
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        Optional<Producto> producto = productoCrudRepository.findById(productId);
        return producto.map(pro -> productMapper.toProduct(pro));
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(int inProducto) {
        return productoCrudRepository.findById(inProducto);
    }

    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    
    
}
