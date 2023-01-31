package com.profitsoft.dudka.apiControllerTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.profitsoft.dudka.model.Product;
import com.profitsoft.dudka.model.Type;
import com.profitsoft.dudka.service.serviceInterfaces.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public class ApiControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @Mock
    @InjectMocks
    private MockMvc mockMvc;

    @Autowired
    @Mock
    @InjectMocks
    private ProductService productService;


    @Test
    @DatabaseSetup("/dataset/productsTest/productAdd.xml")
    public void getAllProductsTest() throws Exception {
        mockMvc.perform(get("/api/profitsoft/rest/products"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(result -> {
                            assertThat(result.getResponse().getContentType()).isNotEmpty();
                        }
                );
    }

    @Test
    @DatabaseSetup("/dataset/productsTest/productAdd.xml")
    public void getProductByNameAndTypeTest() throws Exception {
        mockMvc.perform(get("/api/profitsoft/rest/byNameAndType?productName=plate&typeName=kitchen&page=1"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(result -> {
                            assertThat(result.getResponse().getContentType()).isNotEmpty();
                        }
                );
    }


    @Test
    @DatabaseSetup("/dataset/productsTest/productAdd.xml")
    public void deleteProductTest() throws Exception {
        mockMvc.perform(delete("/api/profitsoft/rest/deleteProduct?id=1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void createProductTest() throws Exception {
        Product mockProduct = new Product(1L, "wallet", 2020L, 2000.2, true, new Type(1L, "home"));

        mockMvc.perform(post("/api/profitsoft/rest/product")
                        .content(objectMapper.writeValueAsString(mockProduct))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.productName", is("wallet")));

    }

    @Test
    @DatabaseSetup("/dataset/productsTest/getProductById.xml")
    public void getProductByIdTest() throws Exception {
        mockMvc.perform(get("/api/profitsoft/rest/productById?id=2")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> {
                    assertThat(result.getResponse().getContentType()).isNotEmpty();
                })
                .andExpect(jsonPath("$.productName", is("coffee")));
    }

    @Test
    @DatabaseSetup("/dataset/productsTest/getProductsByName.xml")
    public void getProductByNameTest() throws Exception {
        mockMvc.perform(get("/api/profitsoft/rest/productByName?productName=plate")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> {
                    assertThat(result.getResponse().getContentType()).isNotEmpty();
                });
    }

    @Test
    @DatabaseSetup("/dataset/productsTest/getProductsByYear.xml")
    public void getProductByYearTest() throws Exception {
        mockMvc.perform(get("/api/profitsoft/rest/productByYear?year=2022")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> {
                    assertThat(result.getResponse().getContentType()).isNotEmpty();
                });
    }

    @Test
    public void getAllTypesTest() throws Exception{
        mockMvc.perform(get("/api/profitsoft/rest/types")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> {
                    assertThat(result.getResponse().getContentType()).isNotEmpty();
                });
    }
}
