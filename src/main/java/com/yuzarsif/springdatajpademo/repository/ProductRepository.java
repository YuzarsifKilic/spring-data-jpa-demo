package com.yuzarsif.springdatajpademo.repository;

import com.yuzarsif.springdatajpademo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameAndDescription(String name, String description);

    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByNameContaining(String name);

    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("select p from Product p order by p.dateCreated desc")
    List<Product> findAllOrOrderByDateCreatedDesc();

    List<Product> findByOrderByDateCreatedDesc();

    List<Product> findByNameIn(List<String> names);

    List<Product> findFirst2ByOrderByNameAsc();


}
