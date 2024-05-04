package com.factor.ecommerce.config;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.auth.service.UserService;
import com.factor.ecommerce.auth.utils.UserType;
import com.factor.ecommerce.core.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    private final UserService userService;
   // @Value("${dataloader:false}")
    private boolean isDataAutoLoaded = true;

    private List<Product> product;

    public DataLoader( UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (isDataAutoLoaded) {
            userLoading();
        }
    }

    private void userLoading() {
        System.out.println(UserType.USER_COMMON);
        User user1 = new User.Builder()
                .username("user2@ecommerce.com")
                .password("siberia123")
                .userType(UserType.USER_COMMON)
                .build();
        User user2 = new User.Builder()
                .username("userVIP2@ecommerce.com")
                .password("antartida123")
                .userType(UserType.USER_VIP)
                .build();
            userService.createUser(user1);
            userService.createUser(user2);
        }

}
