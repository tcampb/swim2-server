package com.swim.ControllerSpecs;

import com.google.gson.Gson;
import com.swim.Dao.AsnDao;
import org.junit.Assert;
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

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerSpec {

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
    public void adminCredentials() {
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<>();
        Map<String, String> exp = new HashMap<>();
        map.put("username", "test"); map.put("password", "test");
        exp.put("role", "admin");
        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                                      .contentType(MediaType.APPLICATION_JSON_UTF8)                                                                                                  .content(gson.toJson(map)))
                                       .andExpect(MockMvcResultMatchers.status().is(200))
                                       .andReturn();
            Assert.assertEquals(gson.toJson(exp), result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void userDoesNotExist() {
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<>();
        Map<String, String> exp = new HashMap<>();
        map.put("username", "fake username"); map.put("password", "test");
        exp.put("role", "user does not exist");
        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                                      .contentType(MediaType.APPLICATION_JSON_UTF8)                                                                                                  .content(gson.toJson(map)))
                                      .andExpect(MockMvcResultMatchers.status().is(200))
                                      .andReturn();
            Assert.assertEquals(gson.toJson(exp), result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void invalidPassword() {
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<>();
        Map<String, String> exp = new HashMap<>();
        map.put("username", "test"); map.put("password", "awdwadw");
        exp.put("role", "invalid");
        try {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                                      .contentType(MediaType.APPLICATION_JSON_UTF8)                                                                                                  .content(gson.toJson(map)))
                                       .andExpect(MockMvcResultMatchers.status().is(200))
                                       .andReturn();
            Assert.assertEquals(gson.toJson(exp), result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
