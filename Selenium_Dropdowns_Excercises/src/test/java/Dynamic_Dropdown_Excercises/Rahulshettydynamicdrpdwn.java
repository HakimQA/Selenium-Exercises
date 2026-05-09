package Dynamic_Dropdown_Excercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Rahulshettydynamicdrpdwn {

    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/?utm_source=chatgpt.com");
        driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("glsctl00_mainContent_ddl_originStation1_CTNR")));
        List<WebElement> deptble = driver.findElements(By.xpath("//div[@id='dropdownGroup1']//a"));
        System.out.println(deptble.size());
        System.out.println("The Options in the Departure Dropdown are : ");
        for(WebElement table : deptble){
            System.out.println(table.getText());

        }

        WebElement dep = driver.findElement(By.xpath("//a[@value='TRV']"));
        dep.click();
        System.out.println("The Selected Departure City is " + dep.getText());
        driver.findElement(By.name("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("glsctl00_mainContent_ddl_destinationStation1_CTNR")));
        WebElement arr = driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[text()=' Chennai (MAA)']"));
        List<WebElement> arrtble = driver.findElements(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a"));
        System.out.println(arrtble.size());
        System.out.println("The Options available in Arrival Dropdown are : ");
        for (WebElement table1 : arrtble){
            System.out.println(table1.getText());
        }
        arr.click();
        System.out.println("The Selected Arrival City is " + arr.getText());
        driver.quit();
    }


}
