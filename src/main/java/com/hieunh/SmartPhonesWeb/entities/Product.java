package com.hieunh.SmartPhonesWeb.entities;


import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false, length = 50)
    private String url;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product() {
    }

    public Product(String name, Double price, String url, Integer quantity, Category category) {
        this.name = name;
        this.price = price;
        this.url = url;
        this.quantity = quantity;
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
