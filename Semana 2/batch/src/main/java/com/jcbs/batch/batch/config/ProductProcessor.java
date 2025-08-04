package com.jcbs.batch.batch.config;

import com.jcbs.batch.batch.entity.Products;
import org.springframework.batch.item.ItemProcessor;

public class ProductProcessor implements ItemProcessor<Products, Products> {
    @Override
    public Products process(Products products) throws Exception {
    if (products.getCategory().equals("Pantalones") &&
            products.getPrice() > 100) {
        return products;
    }else {
        return null;
    }
    }
}
