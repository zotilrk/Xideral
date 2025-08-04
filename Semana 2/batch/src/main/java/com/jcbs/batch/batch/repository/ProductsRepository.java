package com.jcbs.batch.batch.repository;

import com.jcbs.batch.batch.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, String> {

}
