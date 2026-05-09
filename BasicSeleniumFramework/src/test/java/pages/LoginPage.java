package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
     By username = By.id("user-name");
     By password = By.id("password");
     By loginBtn = By.id("login-button");
     By errorMsg = By.xpath("//h3[@data-test='error']");

     public LoginPage(WebDriver driver){
         this.driver=driver;
     }

     public void login(String user, String pass){
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         driver.findElement(username).sendKeys(user);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         driver.findElement(password).sendKeys(pass);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         driver.findElement(loginBtn).click();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     }

     public String geterror(){
         return driver.findElement(errorMsg).getText();
     }


}
