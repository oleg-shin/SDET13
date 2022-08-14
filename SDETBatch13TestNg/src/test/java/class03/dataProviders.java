package class03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class dataProviders {
    // navigate to syntax HRMS
    // login into the website using the following credentials
    // a.username = "Admin", password = "12345" error message ="Invalid credentials"
    // b.username = "abcd", password = "Hum@nhhrm123" error message "Invalid credentials"
    // c.username = "", password = "Hum@nhhrm123", error message = "Username cannot be empty"
    // d.username = "Admin" password = "", error message = "Password cannot be empty

    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void settingupBrowser(){
        //seting up the Webdriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        getting the particular url
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

    }
    @AfterMethod(alwaysRun = true)

    public void afterMethod(){
        System.out.println("after method");
        driver.quit();
    }
    @DataProvider(name="Credentials")
    public Object[][] data() {
        Object [][] login={
                { "Admin","12345","Invalid credentials"},
                {"ABCD","Hum@nhrm123","Invalid credentials"},
                {"Admin","","Password cannot be empty"},
                {"","Hum@nhrm123","Username cannot be empty"}};
        return login;
    }

    @Test(dataProvider = "Credentials")
    public void loginWithVariousCredentials(String usrname , String password ,String expectedError){
//finding the username text box
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        //send username
        username.sendKeys(usrname);
        //        finding the password field
        WebElement pswrd = driver.findElement(By.xpath("//input[@id='txtPassword']"));
//        send password
        pswrd.sendKeys(password);
//        finding the element login btn
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
//        click the login
        loginBtn.click();

//        get the element message invalid crdentials
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
//        extract the error message
        String actualError = errorMsg.getText();
//decalre the soft Assertion
        SoftAssert soft =new SoftAssert();
//    asseert that the error is correct
        soft.assertEquals(actualError,expectedError);
//    assert all
        soft.assertAll();

    }
}
