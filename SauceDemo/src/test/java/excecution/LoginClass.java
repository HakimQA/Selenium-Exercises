package excecution;

import base.BrowserSetup;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginClass extends BrowserSetup {

    @Test
    public void login(){
      LoginPage lg = new LoginPage(driver);
      lg.loginpage();

    }


}
