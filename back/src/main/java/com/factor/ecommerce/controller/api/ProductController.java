package com.factor.ecommerce.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body("");
    }

    public ResponseEntity<?> getOne(){
        return ResponseEntity.ok().body("");
    }

    public ResponseEntity<?> create(){
        return ResponseEntity.ok().body("");
    }

    public ResponseEntity<?> delete(){
        return ResponseEntity.ok().body("");
    }

    public ResponseEntity<?> update(){
        return ResponseEntity.ok().body("");
    }

}
