package com.yuzarsif.springdatajpademo.repository;

import com.yuzarsif.springdatajpademo.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    void saveMethod() {

        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("ABC4");
        product.setPrice(new BigDecimal(150));
        product.setActive(true);
        product.setImageUrl("product1.png");

        Product savedProduct = repository.save(product);

        System.out.println(savedProduct);
    }

    @Test
    void updateUsingSaveMethod() {

        Long id = 1L;
        Product product = repository.findById(id).get();

        product.setName("updated product 1");
        product.setDescription("updated 1 product desc");

        Product updatedProduct =  repository.save(product);

        System.out.println(updatedProduct);
    }

    @Test
    void saveAllMethod() {

        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 description");
        product2.setSku("ABC2");
        product2.setPrice(new BigDecimal(100));
        product2.setActive(true);
        product2.setImageUrl("product2.png");

        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product 3 description");
        product3.setSku("ABC3");
        product3.setPrice(new BigDecimal(100));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        List<Product> products = repository.saveAll(List.of(product2, product3));

        System.out.println(products);
    }

}