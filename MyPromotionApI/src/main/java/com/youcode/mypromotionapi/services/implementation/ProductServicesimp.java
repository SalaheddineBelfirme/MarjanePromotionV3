package com.youcode.mypromotionapi.services.implementation;

import com.youcode.mypromotionapi.entities.Product;
import com.youcode.mypromotionapi.repositories.ProductRepositories;
import com.youcode.mypromotionapi.services.PromotionService;
import liquibase.util.NetUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public long count() {
        PageRequest pageRequest = PageRequest.of(1, 2);
        return repositorie.count();
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
