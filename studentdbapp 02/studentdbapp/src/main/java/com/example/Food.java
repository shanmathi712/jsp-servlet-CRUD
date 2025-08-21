package com.example;

public class Food {
    private int id;
    private String name;
    private int quantity;

    public Food() {}
    public Food(int id, String name, int quantity) {
        this.id = id; this.name = name; this.quantity = quantity;
    }
    public Food(String name, int quantity) {
        this.name = name; this.quantity = quantity;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}