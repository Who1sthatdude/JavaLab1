package com.jabalab;

import java.util.Objects;

public abstract class Tool {
    private String type;
    protected Size size;
    protected double weight;
    protected double condition; // add max value for condition that would depend on size
    abstract public void use();
    abstract public void repair(); // new count mechanics have to be added

    public Tool(String type){
        this.type = type;
    }

    public void checkCondition(){ // to do: new system where 100 isn't max value for condition
        if (condition > 100){
            condition = 100;
        }
        else if (condition < 0){
            condition = 0;
        }
    }

    public Tool getTool(){
        return this;
    }

    public String getType(){
        return type;
    }

    @Override
    public String toString(){
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tool tool = (Tool) o;
        return Double.compare(tool.weight, weight) == 0 && Double.compare(tool.condition, condition) == 0 &&
                Objects.equals(type, tool.type) && size == tool.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, size, weight, condition);
    }
}
