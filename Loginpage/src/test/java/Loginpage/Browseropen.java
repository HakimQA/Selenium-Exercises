package Loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Browseropen {

    public static void main(String[] args) throws InterruptedException {
    WebDriver driver;
        driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.get("https://sauce-demo.myshopify.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        System.out.println("Browser has opened");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement logo = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("logo"))
        );

        if (logo.isDisplayed()) {
            System.out.println("Success: Page has loaded successfully");
        } else {
            System.out.println("Failed: Page has not loaded");
        }
        Thread.sleep(5000);

        driver.close();
        Thread.sleep(5000);
        try {
            driver.getTitle(); // try accessing browser
            System.out.println("Failed: Browser still open");
        } catch (Exception e) {
            System.out.println("Success: Browser is closed");
        }
    }

}
