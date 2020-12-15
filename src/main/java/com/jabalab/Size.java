package com.jabalab;

public enum Size {
    Small(2),
    Medium(3),
    Large(5);
    private int value;

    Size(int i) {
        value = i;
    }

    public int getValue(){
        return value;
    }

    public String transform(){
        if (value == 2){
            return "Small";
        }
        else if (value == 3){
            return "Medium";
        }
        else{
            return "Large";
        }
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}
