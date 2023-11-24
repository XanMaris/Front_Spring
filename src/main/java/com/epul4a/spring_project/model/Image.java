package com.epul4a.spring_project.model;


import java.sql.Date;
import java.util.Arrays;

public class Image {
    private long id;
    private Date createDate;
    private String description;
    private byte[] image;
    private String name;
    private double price;
    private int user;
    private boolean privateImage;
    private boolean sold;

    public void save(Image existingImage) {
    }

    public Image() {}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" +
                description + ", price=" + price + ", image="
                + Arrays.toString(image) + ", createDate=" + createDate + "]";
    }
}
