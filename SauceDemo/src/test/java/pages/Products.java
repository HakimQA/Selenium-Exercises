package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Products {

    WebDriver driver;

    public Products(WebDriver driver){
        this.driver = driver;
    }

    By prdtlnk = By.xpath("//div[text()='Sauce Labs Backpack']");
    By pgvrfctn = By.id("back-to-products");
    By adtcrtbtn = By.id("add-to-cart");
    By crtcnt = By.xpath("//span[text()='1']");


    public void product() {

        driver.findElement(prdtlnk).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(pgvrfctn));

            System.out.println("Page has Navigated to the Product upon Clicking the Link ");

        } catch (Exception e) {

            System.out.println("Page Navigation Failed");
        }

        driver.findElement(adtcrtbtn).click();
        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(crtcnt));

            System.out.println("Product Successfully added to the Cart ");

        } catch (Exception e) {

            System.out.println("Product failed to added in the Cart");
        }




    }

}
