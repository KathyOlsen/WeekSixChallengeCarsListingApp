package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=1, max=20)
    private String make;

    @NotNull
    @Size(min=2, max=30)
    private String model;

    @NotNull
    @Min(1920)
    @Max(2050)
    private int year;

    private String color;

    @ManyToOne()
    private Category category;

    private String used;

    private int price;

    private String priceString;

    public Car() {
    }

    public Car(@NotNull @Size(min = 1, max = 20) String make,
               @NotNull @Size(min = 2, max = 30) String model,
               @NotNull @Min(1920) @Max(2050) int year,
               String color,
               Category category,
               String used,
               int price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.category = category;
        this.used = used;
        this.price = price;
        this.priceString = "$" + String.format("%,d", price);
    }


//    public static String formatPrice (int price) {
//        return String.format("%,d", price);
//    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPriceString() {
        return priceString;
    }

    public void setPriceString(String priceString) {
        this.priceString = priceString;
    }
}
