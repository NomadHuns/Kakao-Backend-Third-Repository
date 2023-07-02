package com.example.kakaoshop._core;

import com.example.kakaoshop._core.security.JWTProvider;
import com.example.kakaoshop.user.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class JWTProviderTest {

    @Test
    public void create_test(){
        User user = User.builder().id(1).roles("ROLE_USER,ROLE_ADMIN").email("ssar@nate.com").build();
        String jwt = JWTProvider.create(user);
        System.out.println(jwt);
    }

    @Test
    public void verify_test(){
        User user = User.builder().id(1).roles("ROLE_USER,ROLE_ADMIN").email("ssar@nate.com").build();
        String jwt = JWTProvider.create(user);
        System.out.println(jwt);
        JWTProvider.verify(jwt);
    }
}
