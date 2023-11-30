package com.youcode.mypromotionapi.services.implementation;

import com.youcode.mypromotionapi.dto.ProductDto;
import com.youcode.mypromotionapi.dto.ProductPromotionDto;
import com.youcode.mypromotionapi.entities.ProductPromotion;
import com.youcode.mypromotionapi.entities.Promotion;
import com.youcode.mypromotionapi.services.PromotionService;
import com.youcode.mypromotionapi.repositories.PromotionRepository;
import com.youcode.mypromotionapi.services.IProductPromotion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImp implements PromotionService<ProductPromotion> {
    private PromotionRepository repository;

    public PromotionServiceImp(PromotionRepository promotionRepository) {
        this.repository = promotionRepository;
    }

    @Override
    public Optional<ProductPromotion> create(ProductPromotion promotion) {
        return Optional.of(repository.save(promotion));
    }

    @Override
    public Optional<ProductPromotion> read(UUID uuid) {
        return repository.findById(uuid);

    }

    @Override
    public List<ProductPromotion> readAll() {
        System.out.println("bingo from the service ofpromtion prodect");
        return repository.findAll();

    }

    @Override
    public Optional<ProductPromotion> update(ProductPromotion promotion) {
         Optional<ProductPromotion> promotion1=repository.findById(promotion.getUuid());
         if (promotion1.isPresent()){
             ProductPromotion p=promotion1.get();
             p.setPercentage(promotion.getPercentage());
             return Optional.of(repository.save(p));
         }
        return Optional.empty();
    }

    @Override
    public boolean delete(UUID uuid) {

       try {
           repository.deleteById(uuid);
           return true;
       }catch (Exception e){
           System.out.println(e.getMessage());
           return  false;
       }
    }

    public static ProductPromotionDto convertToDTO(ProductPromotion productPromotion){
        ProductPromotionDto productPromotionDto=new ProductPromotionDto();
        productPromotionDto.setProduct(productPromotion.getProduct());
        productPromotionDto.setPercentage(productPromotion.getPercentage());
        productPromotionDto.setUuid(productPromotion.getUuid());
        return productPromotionDto;
    }
}
