package org.delivery;

import org.assertj.core.api.Assertions;
import org.delivery.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeliveryApplicationTests {

    @Autowired
    private HomeController homeController;

    @Test
    void contextLoads() {
        Assertions.assertThat(homeController).isNotNull();
    }

}
