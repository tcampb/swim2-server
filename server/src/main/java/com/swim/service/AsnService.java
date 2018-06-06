package com.swim.service;

import com.swim.Dao.AsnDao;
import com.swim.model.Asn;
import com.swim.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsnService {

    @Autowired
    AsnDao asnDao;

    @Autowired
    ProductService productService;

    public void insertAsn(Asn asn) {
        asnDao.createAsn(asn);
    }

    public List<Asn> getAllAsns() {
        List<Asn> asnList = asnDao.getAllAsn();
        System.out.println("HERE");
        for(Asn asn : asnList) {
            ArrayList<Products> productList = new ArrayList<>(10);
            for(Products product : productService.getProductsByAsnId(asn.getAsn())) {
                productList.add(product);
            }
            asn.setSerials(productList);
        }
        return asnList;
    }
}
