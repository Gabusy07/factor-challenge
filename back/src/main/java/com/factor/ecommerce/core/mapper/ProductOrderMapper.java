package com.factor.ecommerce.core.mapper;

import com.factor.ecommerce.core.dto.CartDTO;
import com.factor.ecommerce.core.dto.ProductOrderDTO;
import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.model.ProductOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductOrderMapper {

    ProductOrderMapper INSTANCE = Mappers.getMapper(ProductOrderMapper.class);


    ProductOrderDTO productOrderToProductOrderDTO(ProductOrder productOrder);

    List<ProductOrderDTO> productOrdersToProductOrdersDTO(List<ProductOrder> productOrders);


    default ProductOrder productOrderDTOToProductOrder(ProductOrderDTO productOrderDTO) {
        ProductOrder productOrder = new ProductOrder.Builder()
                .quantityOrder(productOrderDTO.getQuantityOrder()).build();
        return productOrder;
    }

}
