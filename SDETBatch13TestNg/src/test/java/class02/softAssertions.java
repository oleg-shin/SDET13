package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertions {
    //navigate to syntaxhrms
    // 1) write test case to verify the wrong credentials give error message
    // 2) assert that username text box is displayed
    // quit the browser
    WebDriver driver;
    // navigate to syntax hrms website

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @Test(groups = "regression")
    public void invalidCredentials(){

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
//      expected text
        String expectedText="Invalid credentials";

//      declare SoftAssert
        SoftAssert soft = new SoftAssert();

//      making assertion to make sure that message is correct
        soft.assertEquals(errorText,expectedText);

//      get the weElemet username from website
        username = driver.findElement(By.xpath("//input[@id='txtUsername']"));

//      is it displayed?
        boolean displayed = username.isDisplayed();

//      testing if the second assertion is executed
        System.out.println("test the second assertion");
//      make sure the text box is displayed
        soft.assertTrue(displayed);

        soft.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}
