package com.kalp.catalogservice.web.controller;

import com.kalp.catalogservice.AbstractTest;
import com.kalp.catalogservice.entities.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;

public class ProductControllerTest extends AbstractTest {

    @Before
    public void setup() {
        super.setup();
    }

    @Test
    public void allProducts() throws Exception {
        {
            String uri = "/catalog";
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                    .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            Assert.assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            Product[] productlist = new Product[0];
            try {
                productlist = super.mapFromJson(content, Product[].class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Assert.assertTrue(productlist.length > 0);
        }

    }

}

