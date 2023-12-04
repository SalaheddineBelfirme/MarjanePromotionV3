package com.youcode.mypromotionapi.controllers;

import com.youcode.mypromotionapi.config.ModelMapperConfig;
import com.youcode.mypromotionapi.dto.ProductDto;
import com.youcode.mypromotionapi.dto.ProductPromotionDto;
import com.youcode.mypromotionapi.dto.requests.PromtionReqest;
import com.youcode.mypromotionapi.entities.Product;
import com.youcode.mypromotionapi.services.ProductServices;
import com.youcode.mypromotionapi.services.implementation.ProductServicesimp;
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
@RequestMapping("/api/product")
public class productController {
    private final ProductServicesimp service;
    private  final  ModelMapperConfig mapper;


    @Autowired
    private  CenterAdministratorController centerAdministratorController;

    @Autowired
    public productController(ProductServicesimp productServices,ModelMapperConfig mapper) {
        this.service = productServices;
        this.mapper=mapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>>getall() {
        List<ProductDto>productDtos= service.readAll().stream().map(product -> mapper.modelMapper().map(product,ProductDto.class)).toList();
        return ResponseEntity.ok(productDtos);}

}
