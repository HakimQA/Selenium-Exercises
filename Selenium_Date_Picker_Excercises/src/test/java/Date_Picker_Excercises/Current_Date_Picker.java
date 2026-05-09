package Date_Picker_Excercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Current_Date_Picker {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/date-picker?utm_source=chatgpt.com");
        driver.findElement(By.id("datePickerMonthYearInput")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'react-datepicker__day')]")));
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day--016')]")).click();
        WebElement Date_field = driver.findElement(By.id("datePickerMonthYearInput"));
        String actual_Value = Date_field.getAttribute("value");
        System.out.println("Selected Date is : " + actual_Value);
        Assert.assertEquals(actual_Value,"05/16/2026");
        System.out.println("The Date has selected Successfully");
        driver.quit();

    }


}
