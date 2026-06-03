package Date_Picker_Excercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Month;

public class JqueryGenericDateSelection {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/?utm_source=chatgpt.com");
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(0);
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        setdate(driver,"20","December","2028");
        setdate(driver,"20","December","2024");
        setdate(driver,"3","June","2026");
        driver.quit();

    }
    public static void setdate(WebDriver driver,String day, String month, String year){
        By datebox = By.className("hasDatepicker");
        driver.findElement(datebox).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-title")));
        WebElement currentmnth = driver.findElement(By.className("ui-datepicker-month"));
        String currntmnthtxt = currentmnth.getText();
        WebElement currentyr = driver.findElement(By.className("ui-datepicker-year"));
        String currentyrtxt = currentyr.getText();
        System.out.println("Current Month : " + currntmnthtxt);
        System.out.println("Current Year  : " + currentyrtxt);
        System.out.println("Target Month  : " + month);
        System.out.println("Target Year   : " + year);
        By prvsbtn = By.xpath("//a[@data-handler='prev']");
        By nxtbtn = By.xpath("//a[@title='Next']");

        while (true){
            currentmnth = driver.findElement(By.className("ui-datepicker-month"));
            currntmnthtxt = currentmnth.getText();
            currentyr = driver.findElement(By.className("ui-datepicker-year"));
            currentyrtxt = currentyr.getText();
            int currntmnthnm = Month.valueOf(currntmnthtxt.toUpperCase()).getValue();
            int currntyrnm = Integer.parseInt(currentyrtxt);
            int prvsmnthnm = Month.valueOf(month.toUpperCase()).getValue();
            int prvyrnm = Integer.parseInt(year);

            int currentvalue = currntyrnm*12+currntmnthnm;
            int setvalue = prvyrnm*12+prvsmnthnm;

            if(currentvalue==setvalue){
                break;
            } else if (currentvalue<setvalue) {
                driver.findElement(nxtbtn).click();

            }else {
                driver.findElement(prvsbtn).click();
            }

        }

        driver.findElement(By.xpath("//a[@data-date='"+day+"']")).click();

        String selectedDate = driver.findElement(By.id("datepicker"))
                .getAttribute("value");

        System.out.println("Selected Date: " + selectedDate);
        // Validation for the Selected Date
        int monthNumber = Month.valueOf(month.toUpperCase()).getValue();

        String expectedDate = String.format("%02d/%02d/%s", monthNumber, Integer.parseInt(day), year);

        System.out.println("Expected Date: " + expectedDate);
        if(selectedDate.equals(expectedDate)) {
            System.out.println("Date selected successfully");
        } else {
            System.out.println("Date selection failed");
        }



    }


}
