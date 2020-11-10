package com.jabalab;

import java.util.ArrayList;

public class Nutrition {
    private ArrayList<Meat> meat;
    private ArrayList<Water> bottles;

    public static class Meat{
        private double caloriesRestored;
        private StringBuffer type;
        private double weight;

        public Meat(String type, double weight){
            this.type = new StringBuffer(type);
            this.type.append(" meat");
            this.weight = weight;
            caloriesRestored = weight * 2400;
        }

        public void use(){
            System.out.println("meat piece was consumed");
        }

        public void getInfo(){
            System.out.println(caloriesRestored + " calories were restored");
        }
    }

    public static class Water{
        private double capacity;
        private double hydrationRestored;
        private boolean isClean;
        public Water(double capacity){
            this.capacity = capacity;
            hydrationRestored = capacity * 0.65;
            isClean = true;
        }

        public Water(double capacity, boolean isClean){
            this.capacity = capacity;
            hydrationRestored = capacity * 0.65;
            this.isClean = isClean;
        }

        public void use(int i){
            System.out.println("bottle number " + i + " was used and now is empty");
        }
    }

    public Nutrition(){
        meat = new ArrayList<Meat>();
        bottles = new ArrayList<Water>();
    }

    public void take(Water bottle){
        bottles.add(bottle);
    }

    public void take(Meat food){
        meat.add(food);
    }

    public void drink(int i){
        bottles.get(i-1).use(i);
        bottles.remove(i-1);
    }

    public void eat(int i){
        meat.get(i-1).use();
        meat.get(i-1).getInfo();
        meat.remove(i-1);
    }

    public ArrayList<Meat> getMeat() {
        return meat;
    }

    public ArrayList<Water> getWater() {
        return bottles;
    }

    public String info(){
        return bottles.size() + " bottles " + meat.size() + " meat pieces";
    }


}
