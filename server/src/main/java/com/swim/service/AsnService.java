package com.swim.service;

import com.swim.Dao.AsnDao;
import com.swim.Dao.ProductDao;
import com.swim.model.Asn;
import com.swim.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsnService {

    @Autowired
    AsnDao asnDao;

    @Autowired
    ProductService productService;

    @Autowired
    ProductDao productDao;

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


    public void updateToReceived(ArrayList<Integer> serialList, int asnId) {
        productDao.updateColumnReceived(serialList, asnId);
    }


    public void updateToDelivered(ArrayList<Integer> serialList, int asnId) {
        productDao.updateColumnDelivered(serialList, asnId);

    }

    public boolean checkIfAllProductsReceived(int asnId) {
        List<Products> productslist = productDao.getProductsByAsnId(asnId);
        for(Products product : productslist){
            if(!product.getReceived()){
                return false;
            }
        }
        asnDao.updateAsn("received", asnId);
        return true;
    }

    public boolean checkIfAllProductsDelivered(int asnId) {
        List<Products> productslist = productDao.getProductsByAsnId(asnId);
        for(Products product : productslist){
            if(!product.getReceived()){
                return false;
            }
        }
        asnDao.updateAsn("delivered", asnId);
        return true;
    }
}
