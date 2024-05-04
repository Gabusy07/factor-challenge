package com.factor.ecommerce.core.services.impl;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.persistence.repository.CartRepository;
import com.factor.ecommerce.core.services.interfaces.SpecialDateService;
import com.factor.ecommerce.core.utils.CartType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceImplTest {

    @Mock
    private CartRepository cartRepository;

    @Mock
    private SpecialDateService specialDateService;

    @InjectMocks
    private CartServiceImpl cartService;

    @Test
    public void testGetCart_WithUserNotPresent() {
        // Simulamos que el usuario no está presente
        when(cartRepository.findById(any())).thenReturn(Optional.empty());

        // Llamamos al método getCart() con un userId arbitrario
        Optional<Cart> result = cartService.getCart(123);

        // Verificamos que no se haya creado ningún carrito
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void testGetCart_WithExistingCart() {
        // Simulamos que el usuario está presente y que ya tiene un carrito existente
        User user = new User();
        user.setId(123);
        Cart existingCart = new Cart.Builder()
                .setId(1)
                .setIsActive(true)
                .setTotalPrice(100.0)
                .setCartType(CartType.CART_COMMON)
                .build();
        when(cartRepository.findById(123)).thenReturn(Optional.of(existingCart));

        // Llamamos al método getCart() con el userId del usuario
        Optional<Cart> result = cartService.getCart(user.getId());

        // Verificamos que se haya aplicado el descuento correctamente al carrito existente
        assertEquals(75.0, result.get().getTotalPrice());
    }

    @Test
    public void testGetCart_WithNewCart() {
        // Simulamos que el usuario está presente pero no tiene un carrito existente
        User user = new User();
        user.setId(123);
        when(cartRepository.findById(123)).thenReturn(Optional.empty());
        when(specialDateService.isASpecialDate()).thenReturn(true);

        // Llamamos al método getCart() con el userId del usuario
        Optional<Cart> result = cartService.getCart(user.getId());

        // Verificamos que se haya creado un nuevo carrito con el tipo correcto
        assertEquals(CartType.CART_DATE_SPECIAL, result.get().getCartType());
    }

}