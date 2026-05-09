package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {




    public static WebDriver driver;

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        String title = driver.getTitle();
        String logoText = driver.findElement(By.className("login_logo")).getText();

        Assert.assertTrue(title.contains("Swag"), "Title mismatch - page not loaded");
        Assert.assertEquals(logoText, "Swag Labs", "Logo text mismatch");

        System.out.println("Login page loaded successfully");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        System.out.println("Browser has successfully Closed");
    }




}
