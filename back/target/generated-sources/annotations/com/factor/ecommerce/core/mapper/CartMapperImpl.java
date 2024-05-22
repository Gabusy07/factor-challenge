package com.factor.ecommerce.core.mapper;

import com.factor.ecommerce.core.dto.CartDTO;
import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.model.ProductOrder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-12T19:46:58-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Override
    public CartDTO cartToCartDTO(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDTO cartDTO = new CartDTO();

        cartDTO.setId( cart.getId() );
        cartDTO.setTotalPrice( cart.getTotalPrice() );
        cartDTO.setActive( cart.getActive() );
        cartDTO.setInitialDate( cart.getInitialDate() );
        List<ProductOrder> list = cart.getProductOrders();
        if ( list != null ) {
            cartDTO.setProductOrders( new ArrayList<ProductOrder>( list ) );
        }

        return cartDTO;
    }
}
