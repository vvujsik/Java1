package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Problem instancja = new Problem (6,13,10,1);
        System.out.println(instancja);
        Result result= instancja.Solve(13);
        System.out.println(result);
        }
    }
