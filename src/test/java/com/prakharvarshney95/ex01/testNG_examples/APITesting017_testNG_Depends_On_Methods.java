package com.prakharvarshney95.ex01.testNG_examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting017_testNG_Depends_On_Methods {

    @Test
    public void serverStartedOk() {
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test (dependsOnMethods = "serverStartedOk")
    public void method1() {
        System.out.println("method1");
        Assert.assertTrue(true);
    }

    @Test (dependsOnMethods = "serverStartedOk")
    public void method2() {
        System.out.println("method2");
        Assert.assertTrue(true);
    }
}
