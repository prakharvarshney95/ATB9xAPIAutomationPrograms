package com.prakharvarshney95.ex03_testNG_examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting018_testNG_parameter {

    @Parameters ("browser")
            @Test
    public void demo1 (String value) {
        System.out.println("Browser is " + value);
        // open the browser and select dadada
        if (value.equalsIgnoreCase("chrome")) {
            System.out.println("Start my Testing in Chrome");
        }
        if (value.equalsIgnoreCase("firefox")) {
            System.out.println("Start my Firefox");
        }

}
}
