package com.yuzarsif.springdatajpademo.repository;

import com.yuzarsif.springdatajpademo.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository repository;

    @Test
    void findByNameMethod() {

        Product product = repository.findByName("product 2");

        System.out.println(product);
    }

    @Test
    void findByNameOrDescriptionMethod() {

        List<Product> products = repository.findByNameOrDescription("product 2",
                "product 3 description");

        System.out.println(products);
    }

    @Test
    void findByNameAndDescriptionMethod() {

        List<Product> products = repository.findByNameAndDescription("product 2",
                "product 2 description");

        System.out.println(products);
    }

    @Test
    void findDistinctByNameMethod() {

        Product product = repository.findDistinctByName("product 2");

        System.out.println(product);
    }

    @Test
    void findByPriceGreaterThanMethod() {

        List<Product> products = repository.findByPriceGreaterThan(new BigDecimal(100));

        System.out.println(products);
    }

    @Test
    void findByPriceLessThanMethod() {

        List<Product> products = repository.findByPriceLessThan(new BigDecimal(150));

        System.out.println(products);
    }

    @Test
    void findByNameContainingMethod() {

        List<Product> products = repository.findByNameContaining("product");

        products.forEach(p -> {
            System.out.println(p);
        });
    }

    @Test
    void findByPriceBetweenMethod() {

        List<Product> products = repository.findByPriceBetween(new BigDecimal(50), new BigDecimal(200));

        products.forEach(p -> {
            System.out.println(p);
        });
    }

    @Test
    void findByDateCreatedBetween() {

        LocalDateTime startDate = LocalDateTime.of(2023, 8, 24, 12, 30, 34);
        LocalDateTime endDate = LocalDateTime.of(2023, 8, 24, 20, 30, 34);

        List<Product> products = repository.findByDateCreatedBetween(startDate, endDate);

        products.forEach(p -> {
            System.out.println(p);
        });
    }

    @Test
    void findAllOrOrderByDateCreatedDescMethod() {

        List<Product> products = repository.findAllOrOrderByDateCreatedDesc();

        products.forEach(p -> {
            System.out.println(p);
        });
    }

    @Test
    void findByOrderByDateCreatedDesc() {

        List<Product> products = repository.findByOrderByDateCreatedDesc();

        products.forEach(p -> {
            System.out.println(p);
        });
    }

    @Test
    void findByNameInMethod() {

        List<Product> products = repository.findByNameIn(List.of("product 1", "product 2"));

        products.forEach(p -> {
            System.out.println(p);
        });
    }

    @Test
    void findFirst2ByOrderByNameAsc() {

        List<Product> products = repository.findFirst2ByOrderByNameAsc();

        products.forEach(p -> {
            System.out.println(p);
        });
    }


}
