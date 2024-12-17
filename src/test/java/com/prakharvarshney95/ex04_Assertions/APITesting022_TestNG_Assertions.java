package com.prakharvarshney95.ex04_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting022_TestNG_Assertions {

    @Test
    public void test_hardAssertExample() {
        System.out.println("start of the program");
        Boolean is_shreya_Male = false;
        Assert.assertTrue(is_shreya_Male);
        System.out.println("End of the program");

        Assert.assertEquals("Prakhar", "Prakhar");
    }

    @Test
    public void test_softAssertExample() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("This line will be executed");
        softAssert.assertAll(); // This will report all collected errors
    }

}
