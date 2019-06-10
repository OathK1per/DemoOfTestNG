package com.example.demo;

import org.testng.annotations.Test;

public class SetUp04Test {

    @Test(priority = 2)
    public void test04() {
        System.out.println("test04");
    }

    @Test(priority = 1)
    public void test05() {
        System.out.println("test05");
    }

    @Test(priority = 3)
    public void test06() {
        System.out.println("test06");
    }
}
