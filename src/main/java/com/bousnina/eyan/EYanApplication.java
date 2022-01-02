package com.bousnina.eyan;

import com.bousnina.eyan.entities.Category;
import com.bousnina.eyan.entities.Product;
import com.bousnina.eyan.repositories.CategoryRepository;
import com.bousnina.eyan.repositories.ProductRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class EYanApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(EYanApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        categoryRepository.save(new Category(null, "computer", null, null, null));
        categoryRepository.save(new Category(null, "printer", null, null, null));
        categoryRepository.save(new Category(null, "smartPhones", null, null, null));
        Random rnd = new Random();
        categoryRepository.findAll().forEach(category -> {
            for (int i = 0; i < 10; i++) {
                Product product = new Product();
                product.setName(RandomString.make(18));
                product.setCurrentPrice(100 + rnd.nextInt(10000));
                product.setAvailable(rnd.nextBoolean());
                product.setPromotion(rnd.nextBoolean());
                product.setSelected(rnd.nextBoolean());
                product.setCategory(category);
                product.setPicture("unknown.png");
                productRepository.save(product);
            }


        });
    }
}
