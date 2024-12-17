package com.prakharvarshney95.ex03_testNG_examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting016_testNG_groups {

    @Test (groups = {"sanity","qa", "prod", "P0"} )
    public void sanityRun() {
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test (groups = {"Reg", "P1"} )
    public void regRun() {
        System.out.println("Reg");
        Assert.assertTrue(false);
    }

    @Test (groups = {"qa", "P0"} )
    public void smokeRun() {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }
}
