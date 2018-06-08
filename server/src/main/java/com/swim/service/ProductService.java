package com.swim.service;

import com.swim.Dao.ProductDao;
import com.swim.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    AsnService asnService;

    public void insertProduct(Products product) {
        productDao.createProduct(product);
    }

    public List<Products> getProductsByAsnId(int id) {
        return productDao.getProductsByAsnId(id);
    }

    public void updateReceivedItems(ArrayList<Integer> serialList, int asnId, int dockdoor) {
        productDao.updateColumnReceived(serialList, asnId);
        asnService.checkIfAllProductsReceived(asnId);
    }


    public void updateDeliveredItems(ArrayList<Integer> serialList, int asnId, int dockdoor) {
        productDao.updateColumnDelivered(serialList, asnId);
        asnService.checkIfAllProductsDelivered(asnId);
    }
}
