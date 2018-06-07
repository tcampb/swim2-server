package com.swim.DaoSpecs;

import com.swim.Dao.ProductDao;
import com.swim.model.Products;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductSpec {

    @Autowired
    ProductDao productDao;

    @Test
    public void createAndGetProductByAsnId() {
        Products products = new Products();
        products.setReceived(false); products.setDelivered(false);
        products.setAsn(10001); products.setSerial(123);
        productDao.createProduct(products);
        Assert.assertEquals(10001, productDao.getProductsByAsnId(products.getAsn()).get(0).getAsn());
    }

}
