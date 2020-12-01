package com.jabalab;


import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;


public class RucksackTest {
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

}

