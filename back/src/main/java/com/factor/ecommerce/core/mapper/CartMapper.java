package com.factor.ecommerce.core.mapper;

import com.factor.ecommerce.core.dto.CartDTO;
import com.factor.ecommerce.core.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);


    CartDTO cartToCartDTO(Cart cart);

    default Cart cartDTOtoCart(CartDTO cartDTO) {
        if (cartDTO == null) {
            return null;
        }
        return new Cart.Builder()
                .id(cartDTO.getId())
                .totalPrice(cartDTO.getTotalPrice())
                .isActive(cartDTO.getActive())
                .initialDate(cartDTO.getInitialDate())
                .productOrders(cartDTO.getProductOrders())
                .build();
    }

}
