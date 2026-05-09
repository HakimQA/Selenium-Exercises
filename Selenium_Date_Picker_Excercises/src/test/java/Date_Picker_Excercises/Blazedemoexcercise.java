package Date_Picker_Excercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Blazedemoexcercise {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/?utm_source=chatgpt.com");
        setplace(driver,"Boston","London");
        bookflight(driver);
        personaldt(driver,"Harris","4017,Alley,BA","Boston","Philadelphia","475025");
        carddt(driver,"American Express","14587125483","05","2016","Harry Jason");
        driver.quit();

    }

    public static void setplace(WebDriver driver,String depcity , String arrcity){

        // Select Departure City from the Static Drop down
        WebElement frmcitybx = driver.findElement(By.name("fromPort"));
        Select frmcity = new Select(frmcitybx);
        frmcity.selectByVisibleText(depcity);

        Assert.assertEquals(frmcity.getFirstSelectedOption().getText(),depcity);

        // Select Arrival City from the Static Drop down

        WebElement tocitybx = driver.findElement(By.name("toPort"));
        Select tocity = new Select(tocitybx);
        tocity.selectByVisibleText(arrcity);

        Assert.assertEquals(tocity.getFirstSelectedOption().getText(),arrcity);

        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

    }

    public static void bookflight(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Flights from')]")));
        driver.findElement(By.xpath("//tr[1]//td//input")).click();
    }

    public static void personaldt(WebDriver driver,String name, String address, String city, String state, String zipcode){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Your flight from')]")));
        driver.findElement(By.id("inputName")).sendKeys(name);
        driver.findElement(By.id("address")).sendKeys(address);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("state")).sendKeys(state);
        driver.findElement(By.id("zipCode")).sendKeys(zipcode);
    }

    public static void carddt(WebDriver driver,String cardtype, String cardno, String mnth, String year, String nameoncrd){

        //Dropdown Selection

        WebElement drpdnbx = driver.findElement(By.id("cardType")); // Locate the Drpdownbx
        Select drpdn = new Select(drpdnbx); // Create an Object for the Static Dropdown
        drpdn.selectByVisibleText(cardtype);
        driver.findElement(By.id("creditCardNumber")).sendKeys(cardno);
        driver.findElement(By.id("creditCardMonth")).sendKeys(mnth);
        driver.findElement(By.id("creditCardYear")).sendKeys(year);
        driver.findElement(By.id("nameOnCard")).sendKeys(nameoncrd);
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
        String heading = "//h1[contains(text(),'Thank you for your')]";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(heading)));
        WebElement headingwe = driver.findElement(By.xpath(heading));
        Assert.assertEquals(headingwe.getText(),"Thank you for your purchase today!");
        System.out.println("The Booking has been done Successfully");

    }


}
