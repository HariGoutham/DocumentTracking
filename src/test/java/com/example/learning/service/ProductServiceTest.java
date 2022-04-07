package com.example.learning.service;

import com.example.learning.LearningApplicationTests;
import com.example.learning.entity.Product;
import com.example.learning.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductServiceTest extends LearningApplicationTests {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Test
    public void getAllProductsTest(){
        List<Product> list = new ArrayList<Product>();
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("Fridge");
        p1.setPrice(16000);
        list.add(p1);
        Mockito.when(productRepository.findAll()).thenReturn(list);
        List<Product> products = productService.listAll();
        assertEquals(1, products.size());
        assertEquals(products.get(0).getId(), 1);
        assertEquals(products.get(0).getName(), "Fridge");
        assertEquals(products.get(0).getPrice(), 16000);

    }

}
