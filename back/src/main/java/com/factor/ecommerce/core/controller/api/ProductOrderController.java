package com.factor.ecommerce.core.controller.api;

import com.factor.ecommerce.core.controller.request.ProductOrderRequest;
import com.factor.ecommerce.core.model.ProductOrder;
import com.factor.ecommerce.core.services.interfaces.ProductOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders/")
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
        Optional<ProductOrder>  op= productOrderService.getOrder(id);
        if (op.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(op.get());
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody ProductOrderRequest request){
        Optional<ProductOrder> op = productOrderService.createOrder(request);
        if(op.isEmpty()){
            return ResponseEntity.status(HttpStatusCode.valueOf(501)).build();
        }
        return ResponseEntity.ok().body(op.get());
    }

    @DeleteMapping("delete/{orderId}")
    public ResponseEntity<?> delete(@PathVariable Integer orderId){
        Boolean result = productOrderService.deleteProductOrder(orderId);
        if(result){
            return ResponseEntity.accepted().body("order deleted");
        }
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("update/{cartId}")
    public ResponseEntity<ProductOrder> update(@RequestBody ProductOrderRequest order,
                                               @PathVariable Integer cartId
    ){
        Optional<ProductOrder> op = productOrderService.update(cartId, order);
        if(op.isEmpty()){
            return ResponseEntity.status(HttpStatusCode.valueOf(501)).build();
        }
        return ResponseEntity.ok().body(op.get());
    }
}
