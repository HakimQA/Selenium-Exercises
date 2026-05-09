package TestClass;

import baseclass.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LogintoPage;
import pages.Logout;
import pages.Payment;
import pages.ProductSelection;

public class LoginTest extends BaseTest {



    @Test
    public void loginforshopping(){
        LogintoPage lp = new LogintoPage(driver);
        lp.loginforshop("tester895","User123");

        System.out.println("Login Successfully");
    }

    @Test(priority = 1)

    public void Prodselection(){
        ProductSelection ps = new ProductSelection(driver);
        ps.addtocart();
    }

    @Test(priority = 2)

    public void payment(){
        Payment pm = new Payment(driver);
        pm.payment("tester","India","Mumbai","124Qhfj28","January","2026");
    }

    @Test(priority = 3)

    public void logout(){

        Logout lg = new Logout(driver);
        lg.logout();

    }

}
