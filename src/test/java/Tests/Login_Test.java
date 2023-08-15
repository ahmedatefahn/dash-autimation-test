package Tests;

import Pages.Login_Page;
import org.testng.annotations.Test;

public class Login_Test extends TestBase {
    Login_Page loginPage;

    String Email = "momen@nurabi.net";
    String Password = "19821120Mm";

    @Test
    public void loginWithValidData() throws InterruptedException {
        loginPage = new Login_Page(driver);
        loginPage.loginWithValidData(Email, Password);
    }

}
