package Date_Picker_Excercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JQueryTodayDateSelection {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/?utm_source=chatgpt.com");
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(0);
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        settoday(driver);

    }

    public static void settoday(WebDriver driver){

        By datebox = By.className("hasDatepicker");
        driver.findElement(datebox).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-title")));
        driver.findElement(By.xpath("//td[contains(@class,'ui-datepicker-today')]")).click();
        WebElement dateField = driver.findElement(By.id("datepicker"));

        String selectedDate = dateField.getAttribute("value");

        System.out.println(selectedDate);



    }



}
