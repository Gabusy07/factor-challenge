package com.factor.ecommerce.core.mapper;

import com.factor.ecommerce.core.dto.ProductOrderDTO;
import com.factor.ecommerce.core.model.ProductOrder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-12T21:34:37-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductOrderMapperImpl implements ProductOrderMapper {

    @Override
    public ProductOrderDTO productOrderToProductOrderDTO(ProductOrder productOrder) {
        if ( productOrder == null ) {
            return null;
        }

        ProductOrderDTO productOrderDTO = new ProductOrderDTO();

        productOrderDTO.setQuantityOrder( productOrder.getQuantityOrder() );
        productOrderDTO.setProduct( productOrder.getProduct() );

        return productOrderDTO;
    }

    @Override
    public List<ProductOrderDTO> productOrdersToProductOrdersDTO(List<ProductOrder> productOrders) {
        if ( productOrders == null ) {
            return null;
        }

        List<ProductOrderDTO> list = new ArrayList<ProductOrderDTO>( productOrders.size() );
        for ( ProductOrder productOrder : productOrders ) {
            list.add( productOrderToProductOrderDTO( productOrder ) );
        }

        return list;
    }
}
