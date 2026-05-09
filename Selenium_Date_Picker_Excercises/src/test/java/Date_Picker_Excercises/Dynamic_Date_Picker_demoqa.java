package Date_Picker_Excercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Month;

public class Dynamic_Date_Picker_demoqa {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/date-picker?utm_source=chatgpt.com");
        setdate(driver,"05","July","2025", "13:30");

    }

    public static void setdate(WebDriver driver, String trgtday, String trgtmnth,    String trgtyr, String trgttime){

        By datebox = By.id("dateAndTimePickerInput");
        driver.findElement(datebox).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker-popper")));
        //WebElement currntmnthyr = driver.findElement(By.className("react-datepicker__current-month"));
        //String currntmnthyrtxt = currntmnthyr.getText();
        //System.out.println("The Current Date is :" + currntmnthyrtxt);

        By nxtbtn = By.xpath("//button[@aria-label=\"Next Month\"]");
        By prvsbtn = By.xpath("//button[@aria-label=\"Previous Month\"]");
        while (true){
            String currntmnthyrtxt = driver.findElement(By.className("react-datepicker__current-month")).getText();
            String[] parts = currntmnthyrtxt.split(" ");
            String currntmnth = parts[0];
            int currntyear = Integer.parseInt(parts[1]); // Converting the String Current Year Part to Number
            int currntmnthnm = Month.valueOf(currntmnth.toUpperCase()).getValue(); // Converting the Current Month to Numerical Value
            int trgtmnthnm = Month.valueOf(trgtmnth.toUpperCase()).getValue(); // Converting the Target Month to Numerical Value
            int trgtyrnm = Integer.parseInt(trgtyr); // Converting the String Target Year to Number
            System.out.println("The Current Month is " +currntmnth);
            System.out.println("The Current Year is " +currntyear);

            int currentvalue = currntyear*12+currntmnthnm; // Calculation which used to compare the current date with target date to select the Date
            int targetvalue = trgtyrnm*12+trgtmnthnm; // Calculation which used to compare the target date with target date to select the Date

            if(currentvalue==targetvalue){
                break;

            }else if(targetvalue>currentvalue){
                driver.findElement(nxtbtn).click();
            }else{
                driver.findElement(prvsbtn).click();
            }


        }

        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--0"+ trgtday +"')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + trgttime + "']"))).click();


        String selectddate = driver.findElement(By.id("dateAndTimePickerInput")).getAttribute("value");
        System.out.println("The Selected Date is : "  + selectddate);
        if(selectddate.contains(trgtmnth)
                && selectddate.contains(trgtyr)) {
            System.out.println("Date selected successfully");
        } else {
            System.out.println("Date selection failed");
        }
        driver.quit();






    }



}
