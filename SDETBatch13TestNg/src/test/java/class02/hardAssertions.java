package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class hardAssertions {
    //navigate to syntaxhrms
    // write test case to verify the wrong credentials give error message
    // quit the browser
    WebDriver driver;
    // navigate to syntax hrms website

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @Test
    public void verifyInvalidCredentials() {
//      finding the username text box
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));

//      send invalid username
        username.sendKeys("WeatherMay");
//      finding the password text box
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));

//      send invalid password
        password.sendKeys("asdaffd");
//      finding login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));

        loginButton.click();
//       get the element message invalid credentials
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));

//      extract the error message
        String errorText = errorMsg.getText();
//
        System.out.println(errorText);

//      declaring the message that we are expecting
        String expectedMsg = "Invalid credentials";

//      making assertion to make sure that message is correct
        Assert.assertEquals(errorText,expectedMsg);

//      the text box Username is displayed
        username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        boolean displayed = username.isDisplayed();
        System.out.println(displayed);
        displayed = false;
//      check if the displayed is true or not
        Assert.assertTrue(displayed);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}

