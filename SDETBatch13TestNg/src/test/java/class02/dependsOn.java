package class02;

import org.testng.annotations.Test;

public class dependsOn {
    @Test
    public void login(){
        System.out.println("I have logged in successfully");
    }

    @Test(dependsOnMethods = "login")
    public  void verificationOfDashBoardPage(){

        System.out.println("I am on dashboard page");

    }
}
