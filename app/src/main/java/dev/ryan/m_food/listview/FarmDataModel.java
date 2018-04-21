package dev.ryan.m_food.listview;

public class FarmDataModel {

    int id;
    int image;
    String farmName;
    int stock;

    public FarmDataModel(int id, int image, String farmName, int stock) {
        this.id  = id;
        this.image = image;
        this.farmName = farmName;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public String getFarmName() {
        return farmName;
    }

    public int getStock() {
        return stock;
    }
}
