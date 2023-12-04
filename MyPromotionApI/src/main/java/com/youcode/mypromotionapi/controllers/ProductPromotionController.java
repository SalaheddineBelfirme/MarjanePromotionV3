package com.youcode.mypromotionapi.controllers;

import com.youcode.mypromotionapi.Observer.EventListenerPromotion;
import com.youcode.mypromotionapi.Observer.PromotionManager;
import com.youcode.mypromotionapi.config.ModelMapperConfig;
import com.youcode.mypromotionapi.dto.ProductPromotionDto;
import com.youcode.mypromotionapi.dto.requests.PromtionReqest;
import com.youcode.mypromotionapi.entities.ProductPromotion;
import com.youcode.mypromotionapi.services.implementation.PromotionServiceImp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/productPromotion")
public class ProductPromotionController implements EventListenerPromotion {
    private final PromotionServiceImp service;
    private final  ModelMapperConfig modelMapperConfig;

    @Autowired
     private  CenterAdministratorController centerAdministratorController;
     private PromotionManager promotionManager;

    @Autowired
    public ProductPromotionController(PromotionServiceImp promotionService,PromotionManager promotionManager1,ModelMapperConfig modelMapperConfig1) {
        this.service = promotionService;
        this.promotionManager=promotionManager1;
        this.modelMapperConfig=modelMapperConfig1;
    }

    @GetMapping("/{uuid}")
    public void readPromotion(@PathVariable UUID uuid){

        System.out.println("from readPromotion "+uuid);
    }

    @PostMapping
    public ResponseEntity<?> createPromotion(@RequestBody PromtionReqest promotionReq) {
        ProductPromotion productPromotion= modelMapperConfig.modelMapper().
                map(promotionReq,ProductPromotion.class);
        Optional<ProductPromotion> responce=service.create(productPromotion);
        if (responce.isPresent()){
            ProductPromotionDto productPromotionDto=modelMapperConfig.modelMapper().
                    map(service.create(productPromotion),ProductPromotionDto.class);
            promotionManager.subscribe(centerAdministratorController);
            promotionManager.notifyubscribe();
            return new ResponseEntity<>(productPromotionDto,HttpStatus.CREATED);
        }

        return new ResponseEntity<>("try again",HttpStatus.NOT_FOUND);

    }



    @PutMapping
    public ResponseEntity<String>  updateProductPromotion(@RequestBody ProductPromotion productPromotion){
        Optional<ProductPromotion> promotion=service.update(productPromotion);
        if (promotion.isPresent()){
            return new ResponseEntity<>("updated",HttpStatus.OK);
        }
        return  new ResponseEntity<>("try again",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String>deleteProductPromotion(@PathVariable UUID uuid){
        if(service.delete(uuid)){
            return new ResponseEntity<>("Product Promotion is delated",HttpStatus.OK);
        }

        return new ResponseEntity<>("try again",HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<ProductPromotionDto>>getall() {
         List<ProductPromotionDto>pts= service.readAll().stream().map(PromotionServiceImp::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(pts);
    }

    @Override
    public void update() {
        System.out.println("we have a new promotion");
    }
}
