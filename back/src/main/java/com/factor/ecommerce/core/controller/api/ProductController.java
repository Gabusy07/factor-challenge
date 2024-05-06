package com.factor.ecommerce.core.controller.api;

import com.factor.ecommerce.core.model.Product;
import com.factor.ecommerce.core.services.interfaces.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products/")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(productService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getOne(@PathVariable Integer id){
        return ResponseEntity.ok().body(productService.getProduct(id).get());
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody Product p){
        return ResponseEntity.ok().body(
                productService.create(p));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(){
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("update")
    public ResponseEntity<Product> update(@RequestBody Product p){
        return ResponseEntity.ok().body(productService.update(p.getId(), p));
    }

}
