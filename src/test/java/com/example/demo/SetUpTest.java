package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.*;

public class SetUpTest {
    private Integer number = 10;
    private Integer count = 0;

    @BeforeClass(groups = "number")
    public void init() {
        number = 2;
        System.out.println("class init number1: " + number);
    }

    @AfterClass(groups = "number")
    public void dest() {
        number = null;
        System.out.println("class dest count1 " + count);
    }

    @BeforeClass(groups = "number2")
    public void init2() {
        number = 2;
        System.out.println("class init2 number1: " + number);
    }

    @AfterClass(groups = "number2")
    public void dest2() {
        number = null;
        System.out.println("class dest2 count1 " + count);
    }

    @BeforeSuite(groups = "number")
    public void initSuite() {
        number *= 10;
        count += 10;
        System.out.println("suite init number2: " + number);
    }

    @AfterSuite(groups = "number")
    public void destSuite() {
        count -= 10;
        System.out.println("suite dest count2 " + count);
    }

    @BeforeTest(groups = "number")
    public void initTest() {
        System.out.println("test init");
    }

    @AfterTest(groups = "number")
    public void destTest() {
        System.out.println("test dest");
    }

    @BeforeGroups(groups = "number")
    public void initGroups() {
        System.out.println("groups init number3: " + number);
    }

    @AfterGroups(groups = "number")
    public void destGroups() {
        System.out.println("groups dest count3 " + count);
    }

    @BeforeGroups(groups = "number2")
    public void initGroups2() {
        System.out.println("groups2 init number3: " + number);
    }

    @AfterGroups(groups = "number2")
    public void destGroups2() {
        System.out.println("groups2 dest count3 " + count);
    }

    @BeforeMethod(groups = "number")
    public void initMethod() {
        count++;
        System.out.println("method init number4: " + number);
    }

    @AfterMethod(groups = "number")
    public void destMethod() {
        count--;
        System.out.println("method dest count4 " + count);
    }

    @Test(groups = "number")
    public void test01() {
        number++;
        System.out.println("test01 number5: " + number);
        System.out.println("test01 count5: " + count);
        count++;
    }

    @Test(groups = "number", enabled = false)
    public void test02() {
        number++;
        System.out.println("test02 number6: " + (-1) * number);
        System.out.println("test02 count6: " + count);
    }

    @Test(groups = "number2")
    public void test03() {
        System.out.println("test03 number7: " + number);
        System.out.println("test03 count7: " + count);
    }

    @Test
    public void test04() {
        System.out.println("test04 number8: " + number);
        System.out.println("test04 count8: " + count);
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "number")
    public void test06() {
        count = 0;
        System.out.println("test06");
        number = number / count;
    }

    @Test
    @Parameters({"value", "isEven"})
    public void test07(int value, boolean isEven) {
        Assert.assertEquals(isEven, value % 2 == 0);
        System.out.println("test07");
    }

    @Test(dataProvider = "numbers")
    public void test08(EvenNumber number) {
        System.out.println("test08");
        Assert.assertEquals(number.isEven, number.value % 2 == 0);
    }

    @DataProvider(name = "numbers")
    public Object[][] provider() {
        return new Object[][]{{new EvenNumber(1, false)}, {new EvenNumber(4, true)}, {new EvenNumber(9, false)}};
    }

    private class EvenNumber {
        private int value;
        private boolean isEven;
        EvenNumber(int value, boolean isEven) {
            this.value = value;
            this.isEven = isEven;
        }
    }

    @Test(timeOut = 10)
    public void test09() {
        System.out.println("test09");
    }

    @Test
    public void testDepend() {
        count = 0;
        System.out.println("test06");
        number = number / count;
    }

    @Test(dependsOnMethods = {"testDepend"})
    public void test10() {
        System.out.println("test10");
    }
}
