package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest(){
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user","secret_sauce");

        ProductPage pp = new ProductPage(driver);
        Assert.assertEquals(pp.getPageTitle(),"Products");
    }

    @Test
    public void invalidLoginTest(){

        LoginPage lp = new LoginPage(driver);
        lp.login("wrong_user","wrong_pass");
        Assert.assertTrue(lp.geterror().contains("Username and password do not match"));

    }

    @Test
    public void addToCartTest(){
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user","secret_sauce");

        ProductPage pp = new ProductPage(driver);
        pp.addTocart();
        pp.openCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));

    }



}
