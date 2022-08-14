package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testAnnotationExample {
    // go to facebook.com
    // enter username
    // enter password
    // make sure the error is there
    @Test
    public void testingForInvalidCredentials(){
        // setting up driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // getting particular url
        driver.get("https://www.facebook.com");
        // putting wrong credentials, then clicking on login
        driver.findElement(By.id("email")).sendKeys("syntax@adfasdfasf.com");
        driver.findElement(By.id("pass")).sendKeys("whatever");
        driver.findElement(By.name("login")).click();
        driver.quit();
    }
    @Test
    public void testingForfbText(){
        //seting up the Webdriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //getting the particular url
        driver.get("https://fb.com");
        String text = driver.findElement(By.xpath("//h2")).getText();
        if(text.equals("Connect with friends and the world around you on Facebook.")){
            System.out.println("successful");
        }
        else
        {
            System.out.println("failed");
        }
        driver.quit();
    }
    // go to Facebook.com
    // make sure create account text is there
    @Test
    public void createAccountText(){
        // setting up driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // getting particular url
        driver.get("https://www.facebook.com");
        String text = driver.findElement(By.xpath("//a[text()='Create new account']")).getText();
        if(text.equals("Create new account")){
            System.out.println("successful");
        } else {
            System.out.println("failure");
        }
        driver.quit();
    }
}
