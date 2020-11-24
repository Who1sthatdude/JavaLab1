package com.jabalab;

import org.junit.Assert;
import org.junit.Test;

public class KnifeTest {
    @Test
    public void knifeTestsNotEquals(){
        Tool obj1 = new Knife(Size.Large, 100);
        Tool obj2 = new Knife(Size.Medium, 56);

        Assert.assertNotEquals(obj1, obj2);
    }

    @Test
    public void knifeTestsEquals(){
        Tool obj1 = new Knife(Size.Medium, 100);
        Tool obj2 = new Knife(Size.Medium, 100);

        Assert.assertEquals(obj1, obj2);
    }

    @Test
    public void knifeTestRepair(){
        Tool obj = new Knife(Size.Large, 47);
        obj.repair();
        Assert.assertEquals(obj, new Knife(Size.Large, 77));
    }
}
