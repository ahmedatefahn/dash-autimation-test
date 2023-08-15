package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login_Page extends PageBase {

    public Login_Page(WebDriver driver) {
        super(driver);
    }

    By mailTxt = By.id("login-email");
    By passwordTxt = By.id("login-password");
    By loginBtn = By.xpath("//button[contains(text() , ' Login ')]");


    public void loginWithValidData(String requiredMail, String requiredPassword) throws InterruptedException {
        writeOnText(mailTxt, requiredMail);
        writeOnText(passwordTxt, requiredPassword);
        Click(loginBtn);
    }

}
