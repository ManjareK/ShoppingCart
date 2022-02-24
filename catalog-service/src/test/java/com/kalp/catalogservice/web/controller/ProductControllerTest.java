package com.kalp.catalogservice.web.controller;

import com.kalp.catalogservice.AbstractTest;
import com.kalp.catalogservice.entities.Product;
import com.kalp.catalogservice.services.ProductService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

public class ProductControllerTest extends AbstractTest {

    @Before
    public void setup() {
        super.setup();
        this.setUpProductList();
    }

    @MockBean
    private ProductService productService;

    private List<Product> productList;

    private Product product;

    String uri = "/catalog";

    void setUpProductList() {
        this.product=new Product();
        product.setCode("DummyCode");;
        product.setDescription("DummyDescription");
        product.setName("DummyName");
        this.productList = new ArrayList<>();
        this.productList.add(product);
    }

    @Test
    public void fetchAllProducts() throws Exception {
        Mockito.when(
                productService.findAllProducts()).thenReturn(productList);
         mvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.equalTo("DummyName")));

    }
    @Test
    public void allProducts() throws Exception {
        {

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
            System.out.println(productlist);
            Assert.assertTrue(productlist.length > 0);
        }

    }

}

