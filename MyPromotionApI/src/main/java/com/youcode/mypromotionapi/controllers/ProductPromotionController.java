package com.youcode.mypromotionapi.controllers;

import com.youcode.mypromotionapi.Observer.EventListenerPromotion;
import com.youcode.mypromotionapi.Observer.PromotionManager;
import com.youcode.mypromotionapi.dto.ProductPromotionDto;
import com.youcode.mypromotionapi.entities.ProductPromotion;
import com.youcode.mypromotionapi.services.implementation.PromotionServiceImp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productPromotion")
public class ProductPromotionController implements EventListenerPromotion {
    private final PromotionServiceImp service;
    @Autowired
     private  CenterAdministratorController centerAdministratorController;
     private PromotionManager promotionManager;

    @Autowired
    public ProductPromotionController(PromotionServiceImp promotionService,PromotionManager promotionManager1) {
        this.service = promotionService;
        this.promotionManager=promotionManager1;
    }

    @GetMapping("/{uuid}")
    public void readPromotion(@PathVariable UUID uuid){

        System.out.println("from readPromotion "+uuid);
    }

    @PostMapping
    public ResponseEntity<String> createPromotion(@RequestBody ProductPromotion productPromotion) {
        System.out.println(productPromotion.getPercentage());
        if (service.create(productPromotion).isPresent()){
            promotionManager.subscribe(centerAdministratorController);
            promotionManager.notifyubscribe();
            return new ResponseEntity<>("product Promotion added ",HttpStatus.CREATED);
        }

        return new ResponseEntity<>("try again ",HttpStatus.NOT_FOUND);

    }



    @PutMapping
    public ResponseEntity<ProductPromotion>  updateProductPromotion(@RequestBody ProductPromotion productPromotion){
//        return  service.create(productPromotion).map(updatPromtion->new ResponseEntity<>(updatPromtion,HttpStatus.OK))
//                .orElse(new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR));
        return  null;
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String>deleteProductPromotion(@PathVariable UUID uuid){
        if(service.delete(uuid)){
            return new ResponseEntity<>("Product Promotion is delated",HttpStatus.OK);

        }
        return new ResponseEntity<>("try agin",HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity< List<ProductPromotionDto>>getall() {
         List<ProductPromotionDto>pts= service.readAll().stream().map(PromotionServiceImp::convertToDTO).collect(Collectors.toList());
        pts.forEach(pt -> System.out.println("prosntage est" + pt.getPercentage()));
        return ResponseEntity.ok(pts);

    }

    @Override
    public void update() {
        System.out.println("we have a new promotion");
    }
}
