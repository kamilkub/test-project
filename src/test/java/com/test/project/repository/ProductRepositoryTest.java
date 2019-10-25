package com.test.project.repository;

import com.test.project.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@SpringBootTest
class ProductRepositoryTest {


    @Autowired
    private ProductRepository productRepository;


    @Test
    void lestFindOut() throws IOException {


    }



}