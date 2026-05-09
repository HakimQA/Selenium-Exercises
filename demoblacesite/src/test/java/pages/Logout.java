package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.CommonUtils;

import java.time.Duration;

public class Logout {

    WebDriver driver;
    By logout = By.xpath("//a[text()=\"Log out\"]");

    public Logout (WebDriver driver){
        this.driver = driver;
    }

    public void logout(){
        driver.findElement(logout).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isNotVisible = wait.until(
                ExpectedConditions.invisibilityOfElementLocated(logout)
        );

        if (isNotVisible) {
            System.out.println("Log out Successfully");
        }
    }


}
