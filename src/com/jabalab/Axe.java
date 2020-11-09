package com.jabalab;
import java.util.Scanner;

public class Axe extends Tool {

    public Axe(Size size, double condition) {
        super("Axe");
        this.size = size;
        this.weight = size.getValue() * 2;
        this.condition = condition;
    }

    @Override
    public void use() {     //should be improved
        System.out.println("Choose how many trees you want to chop down:");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        condition -= 7.5 * num;
        System.out.println("Congrats! " + 3 * num + "wooden parts were gathered");
        System.out.println("Current condition: " + condition);
    }

    @Override
    public void repair(){
        condition += 50;
        checkCondition();
    }

    @Override
    public String toString(){
        return "Tool " + super.toString() + " size: " + size +" weight: " + weight + " condition: " + condition;
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }
}


