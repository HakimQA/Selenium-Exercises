package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver =driver;
    }

    By chkotbtn = By.id("checkout");
    By pgtitle = By.className("title");
    By frtnme = By.id("first-name");
    By lstnme = By.id("last-name");
    By pstcode = By.id("postal-code");
    By contnubtn = By.id("continue");
    By crtlst = By.className("cart_list");
    By finshbtn = By.id("finish");
    By completehdr = By.className("complete-header");

    public void chkout(){
        driver.findElement(chkotbtn).click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(pgtitle));
            String title = driver.findElement(pgtitle).getText();
            System.out.println("Check out Page has Successfully Loaded with Page Title Name as " + title);
        } catch (Exception e) {
            System.out.println("Checkout Page seems not loaded properly");;
        }

        driver.findElement(frtnme).sendKeys("Akshay");
        driver.findElement(lstnme).sendKeys("Davidson");
        driver.findElement(pstcode).sendKeys("sferw");
        driver.findElement(contnubtn).click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(crtlst));
            String ovrview = driver.findElement(crtlst).getText();
            System.out.println("The Checkout OverView Page has loaded successfully and the Product Grid Details are " + ovrview);

        } catch (Exception e) {
            System.out.println("Checkout Overview Page seems not loaded properly");;
        }
    }

    public void overview(){
        driver.findElement(finshbtn).click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(completehdr));
            String finishtitle = driver.findElement(completehdr).getText();
            System.out.println("The Order has Placed Successfully and the Title of the last Page is " + finishtitle);

        } catch (Exception e) {
            System.out.println("The Order seems not placed yet. Please check and try Again");;
        }

    }




}
