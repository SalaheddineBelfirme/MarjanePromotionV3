package com.youcode.mypromotionapi.services.implementation;

import com.youcode.mypromotionapi.entities.Product;
import com.youcode.mypromotionapi.repositories.ProductRepositories;
import com.youcode.mypromotionapi.services.PromotionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ProductServicesimp implements PromotionService<Product> {

    private ProductRepositories repositorie ;

    public ProductServicesimp(ProductRepositories ProductRepositories){
        this.repositorie=ProductRepositories;
    }

    @Override
    public Optional<Product> create(Product o) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> read(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<Product> readAll() {
        return repositorie.findAll();
    }

    @Override
    public Optional<Product> update(Product o) {
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID uuid) {
        return false;
    }
}
