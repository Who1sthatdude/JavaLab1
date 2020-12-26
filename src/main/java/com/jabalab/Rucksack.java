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
                if(item.equals("Axe")) {
                    takeTool(new Axe(Size.Large, 100), item);
                }else if(item.equals("Knife")){
                    takeTool(new Knife(Size.Medium, 100), item);
                }else if(item.equals("Water")){
                    takeWater(new Nutrition.Water(1));
                }else if(item.equals("Meat")){
                    takeMeat(new Nutrition.Meat("fried", 1));
                }
            } catch (MyException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public Rucksack(HashMap<String, Tool> tools) {
        this.tools = tools;
    }

    public void takeTool(Tool item, String name) throws MyException{
        if(item != null) {
            tools.put(name, item);
        }
        else {
            throw new MyException("You are trying to get an item that doesn't exist");
        }
    }

    public void takeMeat(Nutrition.Meat item) throws MyException{
        if(item != null) {
            food.take(item);
        }else{
            throw new MyException("You are trying to put an item that is null");
        }
    }

    public void takeWater(Nutrition.Water item) throws MyException{
        if(item != null) {
            food.take(item);
        }else{
            throw new MyException("You are trying to put an item that is null");
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

    public Nutrition getFood(){
        return food;
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
