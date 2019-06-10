package com.example.demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SetUp02Test {

    @BeforeClass(groups = "number2")
    public void initClass() {
        System.out.println("class02 init");
    }

    @AfterClass
    public void destClass() {
        System.out.println("class02 dest");
    }

    @Test(groups = "number")
    public void test05() {
        System.out.println("test05");
    }
}
