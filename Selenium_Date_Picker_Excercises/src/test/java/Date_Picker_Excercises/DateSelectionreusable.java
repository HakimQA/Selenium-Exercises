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

public class DateSelectionreusable {




        public static void main (String[]args){

            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get("https://demoqa.com/date-picker");

            selectDate(driver, "June", "1995", "10");

            driver.quit();


        }

        public static void selectDate (WebDriver driver, String month, String year, String day){

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Open Date Picker
            driver.findElement(By.id("datePickerMonthYearInput")).click();

            // Wait for Calender
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'react-datepicker__day')]")));

            // Select Month
            WebElement dropdownmnthbx = driver.findElement(By.className("react-datepicker__month-select")); // locate the Month DropdownBox
            Select dropdownmnth = new Select(dropdownmnthbx);  // Object Creation to access the elements in the Month Dropdown
            dropdownmnth.selectByVisibleText(month);
            WebElement monthvle = dropdownmnth.getFirstSelectedOption();
            String monthtxt = monthvle.getText();
            Assert.assertEquals(monthtxt, month);
            System.out.println("Month has been selected and is " + monthtxt);

            //Select Year

            WebElement dropdownyearbx = driver.findElement(By.className("react-datepicker__year-select")); // Locate the Year Dropdown
            Select drpdownyr = new Select(dropdownyearbx);
            drpdownyr.selectByVisibleText(year);
            WebElement yearvle = drpdownyr.getFirstSelectedOption();
            String yeartxt = yearvle.getText();
            Assert.assertEquals(yeartxt, year);
            System.out.println("The Year has been selected and it is " + yeartxt);

            // Select Day
            String dayXpath =
                    "//div[contains(@class,'react-datepicker__day--0"
                            + day + "')]";

            WebElement dayvalue = driver.findElement(By.xpath(dayXpath));
            String daytxt = dayvalue.getText();
            dayvalue.click();

            System.out.println("The Selected Day is : " + daytxt);

            // Capture selected date
            WebElement dateField = driver.findElement(By.id("datePickerMonthYearInput"));

            String actualDate = dateField.getAttribute("value");

            System.out.println("Selected Date: " + actualDate);

            // Simple validation
            Assert.assertTrue(!actualDate.isEmpty());

            System.out.println("PASS : Date selected successfully");


        }


    }


