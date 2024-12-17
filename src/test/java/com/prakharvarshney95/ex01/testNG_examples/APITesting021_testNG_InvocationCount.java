package com.prakharvarshney95.ex01.testNG_examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting021_testNG_InvocationCount {

@Test (invocationCount = 5)
    public void test01() {
    Assert.assertTrue(true);
}

}
