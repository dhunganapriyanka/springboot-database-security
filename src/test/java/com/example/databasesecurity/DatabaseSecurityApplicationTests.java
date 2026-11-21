package com.example.databasesecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
    "APP_PASSWORD=test-only-password",
    "KEYSTORE_PASSWORD=test-only-keystore-password",
    "server.ssl.enabled=false"
})
class DatabaseSecurityApplicationTests {

    @Test
    void contextLoads() {
    }
}
