package class01;


import org.testng.annotations.Test;

public class testNGannotations {
    // writing down my first test case
    @Test // test annotation is used to indicate that this is a test case
    public void firstTestCase(){
        System.out.println("hey! I'm a first test case");
    }
    @Test(groups = "smoke")
    public void secondTestCase(){
        System.out.println("it a second test case");
    }

    public void thirdTestCase(){
        System.out.println("third test case");
    }
}

