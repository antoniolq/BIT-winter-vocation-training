package com.example.antonio.day01_basics;

public class Food {

    public static final int CHINESE_FOOD = 1;

    public static final int FAST_FOOD = 2;

    public static final int DESSERT = 3;

    private String name;

    private int imgResId;

    private int price;

    private int type;

    private boolean isSpicy;

    private float rating;

    private String description;

    public Food(String name, int imgResId, int price, int type, boolean isSpicy, float rating, String description) {
        this.name = name;
        this.imgResId = imgResId;
        this.price = price;
        this.type = type;
        this.isSpicy = isSpicy;
        this.rating = rating;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isSpicy() {
        return isSpicy;
    }

    public void setSpicy(boolean spicy) {
        isSpicy = spicy;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
