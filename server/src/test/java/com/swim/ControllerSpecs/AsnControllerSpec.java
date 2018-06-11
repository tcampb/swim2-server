package com.swim.ControllerSpecs;

import com.google.gson.Gson;
import com.swim.Dao.AsnDao;
import com.swim.model.Asn;
import com.swim.model.Products;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsnControllerSpec {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    AsnDao asnDao;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void postRequestToGetAllAsnsRoute() {
        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/asns"))
                                      .andExpect(MockMvcResultMatchers.status().is(405))
                                      .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getRequestToGetAllAsnsRoute() {
        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/asns"))
                                      .andExpect(MockMvcResultMatchers.status().is(200))
                                     .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createAsnRoute() {

        ArrayList<Products> productsList = new ArrayList<>();
        Gson gson = new Gson();
        Products products = new Products();
        products.setSerial(123); products.setAsn(123); products.setDelivered(false); products.setReceived(false);
        productsList.add(products);
        Asn asn = new Asn();
        asn.setVendorId("A123"); asn.setSerials(productsList); asn.setExpectedArrivalDate("10-10-2018");
        asn.setExpectedArrivalTime("10:10"); asn.setAsn(1876);

        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/receive/asn")
                                                                     .contentType(MediaType.APPLICATION_JSON_UTF8)                                                                                                  .content(gson.toJson(asn)))
                                                                     .andExpect(MockMvcResultMatchers.status().is(200))
                                                                     .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            asnDao.deleteAnsById(1876);
        }
    }
}
