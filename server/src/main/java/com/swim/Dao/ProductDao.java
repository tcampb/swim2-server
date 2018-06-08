package com.swim.Dao;

import com.swim.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createProduct(Products product) {
        try {
            SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(product);
            jdbcTemplate.update("insert into products (asn, serial, received, delivered) values (:asn, :serial, :received, :delivered)", parameterSource);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Create an Asn method to GET the AsnByID
    public List<Products> getProductsByAsnId(int id) {
        List<Products> productsList = jdbcTemplate.query("SELECT * FROM products WHERE asn = " + id, new BeanPropertyRowMapper<Products>(Products.class)  );
        return productsList;
    }


    // Create a method to update the column received to true
    public void updateColumnReceived(ArrayList<Integer> serialList, int asnId) {
        HashMap<String, Integer> params = new HashMap<>();
        for (Integer serialId: serialList){
                params.put("id", serialId);
             jdbcTemplate.update("UPDATE products SET received = 'true' WHERE serial = :id", params);
        }


    }

    public void updateColumnDelivered(ArrayList<Integer> serialList, int asnId) {
        HashMap<String, Integer> params = new HashMap<>();
        for (Integer serialId: serialList){
            params.put("id", serialId);
            jdbcTemplate.update("UPDATE products SET delivered = 'true' WHERE serial = :id", params);
        }
    }
}
