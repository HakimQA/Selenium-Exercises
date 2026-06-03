package Date_Picker_Excercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Month;

public class JQueryFutureDateSelection {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/?utm_source=chatgpt.com");
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(0);
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        setftrdt(driver,"5","July","2026");
    }

    public static void setftrdt(WebDriver driver, String trgtdy, String trgtmnth, String trgtyr){
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
        System.out.println("Target Month  : " + trgtmnth);
        System.out.println("Target Year   : " + trgtyr);

        By nxtbtn = By.xpath("//a[@title='Next']");
        while(true){
            currentmnth = driver.findElement(By.className("ui-datepicker-month"));
            currntmnthtxt = currentmnth.getText();
            currentyr = driver.findElement(By.className("ui-datepicker-year"));
            currentyrtxt = currentyr.getText();

            int currntmntnm = Month.valueOf(currntmnthtxt.toUpperCase()).getValue(); // Convert the String datatype to Integer
            int currntyrnm = Integer.parseInt(currentyrtxt); // Convert the String datatype to Integer
            int trgtmnthnm = Month.valueOf(trgtmnth.toUpperCase()).getValue(); // Convert the String datatype to Integer
            int trgtyrnm = Integer.parseInt(trgtyr); // Convert the String datatype to Integer
            int currntvalue = currntyrnm*12+currntmntnm;
            int trgtvalue = trgtyrnm*12+trgtmnthnm;
            if(trgtvalue==currntvalue){
                break;
            }else if (trgtvalue>currntvalue){
                driver.findElement(nxtbtn).click();
            }


        }
        driver.findElement(By.xpath("//a[@data-date='"+trgtdy+"']")).click();

        String selectedDate = driver.findElement(By.id("datepicker"))
                .getAttribute("value");

        System.out.println("Selected Date: " + selectedDate);
        // Validation for the Selected Date
        int monthNumber = Month.valueOf(trgtmnth.toUpperCase()).getValue();

        String expectedDate = String.format("%02d/%02d/%s", monthNumber, Integer.parseInt(trgtdy), trgtyr);

        System.out.println("Expected Date: " + expectedDate);
        if(selectedDate.equals(expectedDate)) {
            System.out.println("Date selected successfully");
        } else {
            System.out.println("Date selection failed");
        }
        driver.quit();



    }


}
