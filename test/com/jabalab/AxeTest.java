package com.jabalab;

import org.junit.Assert;
import org.junit.Test;

public class AxeTest {
    @Test
    public void axeTestsNotEquals(){
        Tool obj1 = new Axe(Size.Large, 100);
        Tool obj2 = new Axe(Size.Medium, 56);

        Assert.assertNotEquals(obj1, obj2);
    }

    @Test
    public void axeTestsEquals(){
        Tool obj1 = new Axe(Size.Medium, 100);
        Tool obj2 = new Axe(Size.Medium, 100);

        Assert.assertEquals(obj1, obj2);
    }

}
