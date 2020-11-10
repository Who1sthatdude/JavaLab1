package com.jabalab;


public class Main {

    public static void main(String[] args) {
        String strToSplit = "I,will,split,this";
        Rucksack storage = new Rucksack("Axe", "Knife", "Water", "Water", "Wer", "Meat");
        storage.drink(1);
        storage.eat(1);
        storage.getTool("Axe").use();
        storage.getTool("Knife").use();
        storage.whatDoIHave();
        for(String item : strToSplit.split(",")){
            System.out.print(item + " ");
        }
        System.out.println();

        Nutrition.Meat obj1 = new Nutrition.Meat("fired", 100);
        Nutrition.Meat obj2 = new Nutrition.Meat("fired", 100);
        if(obj1.equals(obj2)){
            System.out.println("Equals");
        }else {
            System.out.println("Not equals");
        }

        Axe object1 = new Axe(Size.Large, 100);
        Axe object2 = new Axe(Size.Large, 100);
        if(object1.equals(object2)){
            System.out.println("Equals");
        }else {
            System.out.println("Not equals");
        }
    }
}
