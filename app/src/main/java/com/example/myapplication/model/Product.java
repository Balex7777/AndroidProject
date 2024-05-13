package com.example.myapplication.model;

public class Product {
    private String id;
    private String name;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

    public Product(String id, String name, String description, String text){
        this.id = id;
        this.name = name;
        this.text = text;
        this.description = description;
    }
}
