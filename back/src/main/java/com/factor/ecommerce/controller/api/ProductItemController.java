package com.factor.ecommerce.controller.api;

import com.factor.ecommerce.controller.request.ProductItemRequest;
import com.factor.ecommerce.model.ProductItem;
import com.factor.ecommerce.services.interfaces.ProductItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/items/")
public class ProductItemController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductItemService productItemService;

    public ProductItemController(ProductItemService productItemService) {
        this.productItemService = productItemService;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(productItemService.getAll(1));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductItem> getOne(@PathVariable Integer id){
        return ResponseEntity.ok().body(productItemService.getItem(id));
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody ProductItemRequest request){
        productItemService.createItem(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(){
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("update/{cartId}")
    public ResponseEntity<ProductItem> update(@RequestBody ProductItemRequest item,
                                              @PathVariable Integer cartId
    ){
        productItemService.update(cartId, item);
        return ResponseEntity.ok().build();
    }
}
