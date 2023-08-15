package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout_Page extends PageBase{
    public Logout_Page(WebDriver driver) {
        super(driver);
    }

    By profile = By.cssSelector("span.b-avatar.badge-minimal.badge-light-primary.rounded-circle");
    By logout = By.xpath("//span[contains(text() , 'Logout')]");


    public void logout()
    {
        waitElementToBeVisible(profile);
        Click(profile);
        waitElementToBeVisible(logout);
        Click(logout);
    }
}
