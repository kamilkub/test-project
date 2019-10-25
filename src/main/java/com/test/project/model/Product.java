package com.test.project.model;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;


    @Transient
    private MultipartFile image;

    @Lob
    @Column
    private byte [] imageCode;


    public void changeImage(MultipartFile image) throws IOException {
        this.imageCode = image.getBytes();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public byte[] getImageCode() {
        return imageCode;
    }

    public void setImageCode(byte[] imageCode) {
        this.imageCode = imageCode;
    }
}
