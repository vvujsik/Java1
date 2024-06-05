package org.example;

import java.util.ArrayList;
import java.util.List;

public class Result {
    int value;
    int weight;
    List<Item> itemList = new ArrayList<Item>();

    public Result(List<Item> items,int value, int weight) {
        this.itemList = items;
        this.value = value;
        this.weight = weight;
    }
    @Override
    public String toString() {
        String wynik="";
        for (Item item : itemList) {
            wynik+=item.toString()+"\n";
        }
        wynik+="Value: "+this.value+" Weight: "+this.weight+"\n";
        return wynik;
    }
}
