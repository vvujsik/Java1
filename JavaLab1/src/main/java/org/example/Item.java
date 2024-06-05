package org.example;

public class Item {
    int id;
    int weight;
    int value;
    float ratio;

    public Item(int id,int weight, int value) {
        this.id = id;
        this.weight = weight;
        this.value = value;
        this.ratio = (float) value / weight;
    }
    @Override
    public String toString() {
        return "ID: "+this.id + " Weight: " + this.weight + " Value: " + this.value + " Ratio: " + this.ratio;
    }
}
