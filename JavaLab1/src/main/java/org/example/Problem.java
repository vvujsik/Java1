package org.example;

import java.util.*;

public class Problem {
    int amount;
    int seed;
    int UB;
    int LB;
    List<Item> items = new ArrayList<Item>();

    public Problem(int amount,int seed,int UB,int LB) {
        this.amount = amount;
        this.seed = seed;
        this.UB = UB;
        this.LB = LB;
        Random rand = new Random(seed);
        for (int i = 0; i < amount; i++) {
            int w = rand.nextInt(LB,UB);
            int v = rand.nextInt(LB,UB);
            items.add(new Item(i,w,v));
        }
    }

    public Result Solve(int capacity){
        Result result;
        List<Item> resultItems = new ArrayList<Item>();
        int actual_cap=0;
        int actual_value=0;
        int stop=0;
        Collections.sort(this.items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Float.compare(o2.ratio, o1.ratio);
            }
        });

        while (items.getFirst().weight <= (capacity-actual_cap)){
            resultItems.add(items.getFirst());
            actual_cap = actual_cap+items.getFirst().weight;
            actual_value = actual_value+items.getFirst().value;
        }
        if (actual_cap == capacity){
            result = new Result(resultItems,actual_value,actual_cap);
            return result;
        }
        for (int i = 1; i < items.size(); i++) {
            if (items.get(i).weight <= (capacity-actual_cap)){
                while (items.get(i).weight <= (capacity-actual_cap)) {
                    resultItems.add(items.get(i));
                    actual_cap = actual_cap+items.get(i).weight;
                    actual_value = actual_value+items.get(i).value;
                }
            }
        }
        result = new Result(resultItems,actual_value,actual_cap);
        return result;
    }
    @Override
    public String toString() {
        String wynik="";
        for (Item item : items) {
            wynik+=item.toString()+"\n";
        }
        //wynik+="-------------";
        return wynik;
    }
}
