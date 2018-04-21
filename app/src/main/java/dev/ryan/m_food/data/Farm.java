package dev.ryan.m_food.data;

public class Farm {

    int id;
    int type;
    String name;
    int stock;

    public Farm(int id, int type, String name, int stock) {

        this.id = id;
        this.type = type;
        this.name = name;
        this.stock = stock;

    }

    public int getId() {
        return this.id;
    }

    public int getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getStock() {
        return this.stock;
    }

}
