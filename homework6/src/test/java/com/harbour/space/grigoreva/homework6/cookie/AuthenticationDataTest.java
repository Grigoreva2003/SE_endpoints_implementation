package com.harbour.space.grigoreva.homework6.cookie;

import com.harbour.space.grigoreva.homework6.cookie.AuthenticationData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AuthenticationDataTest {
    private static final Integer courierId = 1;
    private static final String login = "login";
    private static final String password = "password";
    private static AuthenticationData authData;

    @BeforeAll
    public static void initializationAuthenticationData() {
        authData = new AuthenticationData(courierId, login, password);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals(courierId, authData.getCourierId());
        assertEquals(login, authData.getLogin());
        assertEquals(password, authData.getPassword());
    }

    @Test
    public void testSetters() {
        Integer newCourierId = 2;
        String newLogin = "new_login";
        String newPassword = "new_password";

        authData.setCourierId(newCourierId);
        authData.setLogin(newLogin);
        authData.setPassword(newPassword);

        assertEquals(newCourierId, authData.getCourierId());
        assertEquals(newLogin, authData.getLogin());
        assertEquals(newPassword, authData.getPassword());
    }
}
