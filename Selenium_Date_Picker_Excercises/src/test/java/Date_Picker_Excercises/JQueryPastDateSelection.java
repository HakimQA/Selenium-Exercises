package Date_Picker_Excercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Month;

public class JQueryPastDateSelection {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/?utm_source=chatgpt.com");
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(0);
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        setpstdt(driver,"15","August","2023");

    }

    public static void setpstdt(WebDriver driver, String prvsdy, String prvsmnth, String prvyr){
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
        System.out.println("Target Month  : " + prvsmnth);
        System.out.println("Target Year   : " + prvyr);
        By prvsbtn = By.xpath("//a[@data-handler='prev']");

        while (true){
            currentmnth = driver.findElement(By.className("ui-datepicker-month"));
            currntmnthtxt = currentmnth.getText();
            currentyr = driver.findElement(By.className("ui-datepicker-year"));
            currentyrtxt = currentyr.getText();
            int currntmnthnm = Month.valueOf(currntmnthtxt.toUpperCase()).getValue();
            int currntyrnm = Integer.parseInt(currentyrtxt);
            int prvsmnthnm = Month.valueOf(prvsmnth.toUpperCase()).getValue();
            int prvyrnm = Integer.parseInt(prvyr);

            int currentvalue = currntyrnm*12+currntmnthnm;
            int prvsvalue = prvyrnm*12+prvsmnthnm;

            if(currentvalue==prvsvalue){
                break;
            } else if (currentvalue>prvsvalue) {
                driver.findElement(prvsbtn).click();

            }

        }

        driver.findElement(By.xpath("//a[@data-date='"+prvsdy+"']")).click();

        String selectedDate = driver.findElement(By.id("datepicker"))
                .getAttribute("value");

        System.out.println("Selected Date: " + selectedDate);
        // Validation for the Selected Date
        int monthNumber = Month.valueOf(prvsmnth.toUpperCase()).getValue();

        String expectedDate = String.format("%02d/%02d/%s", monthNumber, Integer.parseInt(prvsdy), prvyr);

        System.out.println("Expected Date: " + expectedDate);
        if(selectedDate.equals(expectedDate)) {
            System.out.println("Date selected successfully");
        } else {
            System.out.println("Date selection failed");
        }
        driver.quit();


    }



}
