package execution;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.FlightBookingTest;

public class ExecutionTesst extends BaseTest {

    @Test
public void flightbook() throws InterruptedException {
FlightBookingTest fb = new FlightBookingTest(driver);
fb.frmcity("Chennai");
fb.tocity("Dubai");
fb.deprtdate("October-2026","13");

    }



}
