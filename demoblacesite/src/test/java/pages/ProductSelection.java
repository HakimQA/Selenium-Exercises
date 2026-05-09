package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductSelection {

    WebDriver driver;

    By productlink = By.xpath("//a[text()=\"Samsung galaxy s6\"]");
    By prodtitle = By.xpath("//h2[text()=\"Samsung galaxy s6\"]");
    By cartbutton = By.xpath("//a[text()=\"Add to cart\"]");

    public ProductSelection(WebDriver driver) {

        this.driver = driver;
    }

    public void addtocart(){

        driver.findElement(productlink).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(prodtitle));
        driver.findElement(cartbutton).click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait1.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();
        System.out.println("Alert handled successfully");

    }


}
