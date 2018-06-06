package com.swim.service;

import com.swim.Dao.ProductDao;
import com.swim.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public void insertProduct(Products product) {
        productDao.createProduct(product);
    }

    public List<Products> getProductsByAsnId(int id) {
        return productDao.getProductsByAsnId(id);
    }
}
