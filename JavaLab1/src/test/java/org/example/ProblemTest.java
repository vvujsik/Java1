package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProblemTest {
    @Test
    public void test1(){
        int cap=20;
        int min = 0;
        int min_one_item = 0;
        Problem pr1 = new Problem(10,1,15,5);
        for(int i=0;i<pr1.items.size();i++){
            if (pr1.items.get(i).weight<cap) {
                min=1;
            }
        }
        Result result = pr1.Solve(cap);
        if (result.itemList.size()>0){
            min_one_item=1;
        }
        assertTrue(min==min_one_item);
    }
    @Test
    public void test2(){
        int cap=2;
        int min = 0;
        Problem pr1 = new Problem(10,1,15,5);
        for(int i=0;i<pr1.items.size();i++){
            if (pr1.items.get(i).weight<cap) {
                min=1;
            }
        }
        Result result = pr1.Solve(cap);
        assertEquals(min,result.itemList.size());
    }
    @Test
    public void test3(){
        boolean error=false;
        Problem pr1 = new Problem(10,1,15,5);
        for(int i=0;i<pr1.items.size();i++){
            if (pr1.items.get(i).weight<5 || pr1.items.get(i).weight>15 || pr1.items.get(i).value<5 || pr1.items.get(i).value>15){
                error=true;
            }
        }
        assertFalse(error);
    }
    @Test
    public void test4(){
        int cap=13;
        int[] items= {4,4,2};
        boolean equals=true;
        Problem instancja = new Problem (6,13,10,1);
        Result result = instancja.Solve(cap);
        for (int i=0;i<result.itemList.size();i++){
            if (result.itemList.get(i).id!=items[i]){
                equals=false;
            }
        }
        assertTrue(equals);
    }
}