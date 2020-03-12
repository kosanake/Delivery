package org.delivery;

import org.delivery.model.Item;
import org.delivery.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(ItemRepository repo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                repo.save(new Item(1L, "item 1"));
                repo.save(new Item(2L, "item 2"));
                repo.save(new Item(3L, "item 3"));
                repo.save(new Item(4L, "item 4"));
                repo.save(new Item(5L, "item 5"));
                repo.save(new Item(6L, "item 6"));
            }
        };
    }
}
