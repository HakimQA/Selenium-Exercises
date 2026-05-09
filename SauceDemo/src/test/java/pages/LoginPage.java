package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
     public LoginPage(WebDriver driver){
         this.driver = driver;
     }


    By cstid = By.id("user-name");
    By passwrd = By.xpath("//input[@id='password']");
    By lgnbtn = By.id("login-button");

    public void loginpage(){


        driver.findElement(cstid).sendKeys("standard_user");
        driver.findElement(passwrd).sendKeys("secret_sauce");
        driver.findElement(lgnbtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String actualtitle = driver.getTitle();
        wait.until(ExpectedConditions.titleContains("Swag"));
        System.out.println(actualtitle);
        String expectedtitle = "Swag Labs";
        if (actualtitle.equals(expectedtitle)){
            System.out.println("Login Successfully");
        }else {
            System.out.println("Login Attempt has failed");
        }


    }



}
