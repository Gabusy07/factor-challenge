package com.factor.ecommerce.config;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.auth.service.UserService;
import com.factor.ecommerce.core.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.List;

public class DataLoader implements ApplicationRunner {
    private final UserService userService;
    @Value("${dataloader:false}")
    private boolean isDataAutoLoaded;

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
        User user1 = new User.Builder()
                .username("user@user.com")
                .password("12345")
                .build();
        User user2 = new User.Builder()
                .username("admin@admin.com")
                .password("12345")
                .
                .build();
            userService.createUser(user1, "USER");
            userService.createUser(user2, "ADMIN");
        }

    }

}
