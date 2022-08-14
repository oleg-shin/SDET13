package class03;

import org.testng.annotations.*;

public class Annotation {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }
    @Test
    public void Atest(){
        System.out.println("I am A test");
    }
    @Test
    public void Btest(){
        System.out.println("I am B test");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am after class");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After test");
    }
}
