package com.example.demo;

import org.testng.annotations.Test;

public class SetUp03Test {

    @Test(priority = 3)
    public void test01() {
        System.out.println("test01");
    }

    @Test(priority = 2)
    public void test02() {
        System.out.println("test02");
    }

    @Test(priority = 1)
    public void test03() {
        System.out.println("test03");
    }
}
