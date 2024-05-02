package com.factor.ecommerce.controller.api;

import com.factor.ecommerce.controller.request.ProductOrderRequest;
import com.factor.ecommerce.model.ProductOrder;
import com.factor.ecommerce.services.interfaces.ProductOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/items/")
public class ProductOrderController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(productOrderService.getAll(1));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductOrder> getOne(@PathVariable Integer id){
        return ResponseEntity.ok().body(productOrderService.getOrder(id));
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody ProductOrderRequest request){
        productOrderService.createOrder(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(){
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("update/{cartId}")
    public ResponseEntity<ProductOrder> update(@RequestBody ProductOrderRequest item,
                                               @PathVariable Integer cartId
    ){
        productOrderService.update(cartId, item);
        return ResponseEntity.ok().build();
    }
}
