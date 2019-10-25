package com.test.project.service;

import com.test.project.model.Market;
import com.test.project.model.Product;
import com.test.project.repository.MarketRepository;
import com.test.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    @Autowired
    private ProductRepository productRepository;

    private MarketRepository marketRepository;


    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }


    public List<Market> getAllData(){
        return (List<Market>) marketRepository.findAll();
    }

    public void addNewData(Market data){
        marketRepository.save(data);
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public byte [] dataImage() {
        return productRepository.findById(14).getImageCode();
    }

}
