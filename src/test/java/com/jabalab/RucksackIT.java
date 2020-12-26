package com.jabalab;


import com.jabalab.*;
import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;


public class RucksackIT {
    @Test
    public void getTool_isUsed_True(){
        Tool toolMock = Mockito.mock(Axe.class);
        String str = "Axe";
        Mockito.when(toolMock.getType()).thenReturn(str);
        Rucksack obj = new Rucksack();
        try {
            obj.takeTool(toolMock, str);
        }catch (MyException e){
            e.printStackTrace();
        }
        Assertions.assertEquals(obj.getTool(str).getType(), str);
        Mockito.verify(toolMock).getType();
    }


    @Test
    public void getFood_isUsed_True(){
        Nutrition.Meat meatMock = Mockito.mock(Nutrition.Meat.class);
        Mockito.when(meatMock.getWeight()).thenReturn(1.0);
        Rucksack obj = new Rucksack();
        try{
            obj.takeMeat(meatMock);
        }catch (MyException e){
            e.printStackTrace();
        }
        Assertions.assertEquals(obj.getFood().getMeat(0).getWeight(), 1.0);
        Mockito.verify(meatMock).getWeight();
    }

    @Test
    public void Rucksack_HashMap_Spy(){
        HashMap<String, Tool> map = Mockito.spy(new HashMap<>());
        map.put("Axe", new Axe(Size.Small, 100));
        Rucksack testObject = new Rucksack(map);
        testObject.getTool("Axe");
        Mockito.verify(map).get("Axe");
    }

}

