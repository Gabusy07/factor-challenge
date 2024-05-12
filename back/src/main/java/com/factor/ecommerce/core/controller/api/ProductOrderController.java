package com.factor.ecommerce.core.controller.api;

import com.factor.ecommerce.core.controller.request.ProductOrderRequest;
import com.factor.ecommerce.core.dto.ProductOrderDTO;
import com.factor.ecommerce.core.model.ProductOrder;
import com.factor.ecommerce.core.services.interfaces.ProductOrderService;
import jakarta.persistence.EntityNotFoundException;
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
    public ResponseEntity<ProductOrderDTO> getOne(@PathVariable Integer id){
        try {
            ProductOrderDTO op= productOrderService.getOrder(id);
            return ResponseEntity.ok().body(op);

        } catch (EntityNotFoundException e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody ProductOrderRequest request){
        ProductOrder order = productOrderService.createOrder(request);
        if(order == null){
            return ResponseEntity.status(HttpStatusCode.valueOf(501)).build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete/{orderId}")
    public ResponseEntity<?> delete(@PathVariable Integer orderId){
        Boolean result = productOrderService.deleteProductOrder(orderId);
        if(result){
            return ResponseEntity.accepted().body("order deleted");
        }
        return ResponseEntity.accepted().build();
    }

}
