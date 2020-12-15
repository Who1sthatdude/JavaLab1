package com.jabalab;

import java.util.Scanner;

public class Knife extends Tool {
    private double damage;
    public Knife(Size size, double condition){
        super("Knife");
        this.size = size;
        weight = 0.7 * size.getValue();
        damage = size.getValue() * 5;
        this.condition = condition;
    }

    @Override
    public void use() {
        Scanner in = new Scanner(System.in);
        System.out.println("how many times should I cut?");
        int num = in.nextInt();
        this.condition -= num * 3.2;
        this.checkCondition();
        System.out.println("smth was cut " + num + " times"); //has to be changed in future (objects instead of smth)
    }

    @Override
    public void repair() {
        this.condition += 30;
        this.checkCondition();
    }

    @Override
    public String toString() {
        return "Tool " + super.toString() +  " damage: " + damage + " size: " + size.transform() +
                " weight: " + weight + " condition: " + condition;
    }
}
