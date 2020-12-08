package com.jabalab;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        String strToSplit = "I,will,split,this";
        Rucksack storage = new Rucksack("Axe", "Knife", "Water", "Water", "Meat");
        storage.whatDoIHave();
        for (String item : strToSplit.split(",")) {
            System.out.print(item + " ");
        }
        System.out.println();

        Nutrition.Meat obj1 = new Nutrition.Meat("fried", 0.6);
        Nutrition.Meat obj2 = new Nutrition.Meat("raw", 1.7);
        if (obj1.equals(obj2)) {
            System.out.println("Equals");
        } else {
            System.out.println("Not equals");
        }

        Axe object1 = new Axe(Size.Large, 100);
        Axe object2 = new Axe(Size.Large, 100);
        if (object1.equals(object2)) {
            System.out.println("Equals");
        } else {
            System.out.println("Not equals");
        }

        try {
            storage.takeMeat(new Nutrition.Meat("raw", 1.5));
            storage.takeMeat(new Nutrition.Meat("fried", 0.6));
            storage.takeMeat(new Nutrition.Meat("raw", 2.3));
        } catch (MyException e) {
            e.printStackTrace();
        }
        System.out.println("\nWeight of meat:");

        ArrayList<Nutrition.Meat> fried = new ArrayList<Nutrition.Meat>();
        ArrayList<Nutrition.Meat> raw = new ArrayList<Nutrition.Meat>();

        storage.getFood().getMeat().stream().filter(item -> item.getType().equals("fried meat")?fried.add(item):raw.add(item))
                .forEach(item -> System.out.println(item.getWeight()));

        printMeatArray(fried);
        printMeatArray(raw);

        double max = storage.getFood().getMeat().stream().max(Comparator.comparing(Nutrition.Meat::getCaloriesRestored))
                .get().getCaloriesRestored();
        System.out.println("Max calories restored: "+max);

        System.out.println("Average calories restored: " +
                storage.getFood().getMeat().stream().mapToDouble(Nutrition.Meat::getCaloriesRestored).average().getAsDouble());

        ArrayList<Rucksack> bags = new ArrayList<Rucksack>();
        bags.add(storage);
        System.out.println("Total calories restored: " + bags.stream().flatMap(bag -> bag.getFood().getMeat().stream())
                .mapToDouble(piece -> piece.getCaloriesRestored()).reduce(0, Double::sum));

    }

    public static void printMeatArray(ArrayList<Nutrition.Meat> array){
        Iterator<Nutrition.Meat> iterator = array.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }


}
