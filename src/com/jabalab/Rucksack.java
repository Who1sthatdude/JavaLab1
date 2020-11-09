package com.jabalab;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Rucksack {
    private HashMap<String, Tool> tools;
    private Nutrition food;// add new maps with resources and nutrition
    public Rucksack(String... contains){
        food = new Nutrition();
        tools = new HashMap<String, Tool>();
        for(String item : contains){
            try {
                take(item);
            } catch (MyException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void take(String item) throws MyException{
        if(item.equals("Axe")){
            tools.put("Axe", new Axe(Size.Medium, 100));
        }
        else if (item.equals("Knife")){
            tools.put("Knife", new Knife(Size.Medium, 100));
        }
        else if (item.equals("Water")){
            food.take(new Nutrition.Water(0.5));
        }
        else if (item.equals("Meat")){
            food.take(new Nutrition.Meat("fried", 0.325));
        }
        else{
            throw new MyException("You are trying to get an item that doesn't exist");
        }
    }

    public Tool getTool(String key){
        return tools.get(key);
    }

    public void drink(int i){
        food.drink(i);
    }

    public void eat(int i){
        food.eat(i);
    }

    public void whatDoIHave(){
        System.out.println("there are " + food.info());
        Iterator<HashMap.Entry<String, Tool>> it = tools.entrySet().iterator();
        while(it.hasNext()){
            Tool value = it.next().getValue();
            System.out.println(value.toString());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rucksack rucksack = (Rucksack) o;
        return Objects.equals(tools, rucksack.tools) &&
                Objects.equals(food, rucksack.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tools, food);
    }
}
