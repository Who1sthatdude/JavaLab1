package com.jabalab;


import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;


public class RucksackTest {
    @Test
    public void takeToolTest(){
        Axe axeMock = Mockito.mock(Axe.class);
        Rucksack obj = new Rucksack();
        Exception exception = Assertions.assertThrows(MyException.class, () -> {
            obj.takeTool(axeMock, "axe");
        });
    }

    @Test
    public void takeWaterTest(){
        Nutrition.Water waterMock = Mockito.mock(Nutrition.Water.class);
        Rucksack obj = new Rucksack();
        Nutrition objToCompare = new Nutrition(waterMock);
        try {
            obj.takeWater(waterMock);
        } catch(Exception e){
            e.printStackTrace();
        }
        Assert.assertEquals(obj.getFood().getWater(), objToCompare.getWater());
    }

    @Test
    public void takeMeatTest(){
        Nutrition.Meat meatMock = Mockito.mock(Nutrition.Meat.class);
        Rucksack obj = new Rucksack();
        Nutrition objToCompare = new Nutrition(meatMock);
        try {
            obj.takeMeat(meatMock);
        } catch(Exception e){
            e.printStackTrace();
        }
        Assert.assertEquals(obj.getFood().getMeat(), objToCompare.getMeat());
    }

}

