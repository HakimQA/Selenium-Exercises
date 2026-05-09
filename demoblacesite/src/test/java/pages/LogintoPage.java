package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import java.time.Duration;

public class LogintoPage {

    WebDriver driver;

    By login_link = By.id("login2");
    By username = By.id("loginusername");
    By password = By.id("loginpassword");
    By loginbtn = By.xpath("//button[text()=\"Log in\"]");

    public LogintoPage(WebDriver driver){
        this.driver = driver;
    }

    public void loginforshop(String user,String pass){

        driver.findElement(login_link).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        driver.findElement(username).sendKeys(user);
        CommonUtils.pause(10);
        driver.findElement(password).sendKeys(pass);
        CommonUtils.pause(10);
        driver.findElement(loginbtn).click();
        CommonUtils.pause(10);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Log out']")));



    }


}
