package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class User_Page extends PageBase {
    public User_Page(WebDriver driver) {
        super(driver);
    }

    By name = By.id("username");
    By password = By.id("login-password");
    By email = By.id("email");
    By birthDateIcon = By.id("example-datepicker date-picker-top");
    By selectCurrentDate = By.cssSelector(".btn.border-0.rounded-circle.text-nowrap.btn-outline-primary.font-weight-bold");
    By languageList = By.id("languageSelectOptions");
    By selectEnglish = By.cssSelector("#languageSelectOptions ul li .English");
    By rolesList = By.id("roleSelectOptions");
    By selectAdminRole = By.cssSelector("#roleSelectOptions ul li .User_Module_Role");
    By selectUserRole = By.cssSelector("#roleSelectOptions ul li .User");

    By username = By.id("username");
    By role = By.id("role");
    By language = By.id("language");
    By gender = By.id("gender");



    public void addUser(boolean user, String nameEN, String passwordEN, String emailUser) {
        writeOnText(name, nameEN);
        writeOnText(password, passwordEN);
        writeOnText(email, emailUser+ new Random().nextInt(9999));
        Click(birthDateIcon);
        Click(selectCurrentDate);
        Click(languageList);
        Click(selectEnglish);
        Click(submitBtn);
        Click(rolesList);
        if (user) {
            Click(selectUserRole);
        } else {
            Click(selectAdminRole);
        }
        Click(submitBtn);
    }


    public void editUser(String nameENEdit) throws InterruptedException {
        openEditScreen();
        waitElementToBeUnVisible(loader);
        Thread.sleep(4000);
        clear(name);
        writeOnText(name, nameENEdit);
        Click(submitBtn);
    }
    public void clickSubmit()
    {
        Click(submitBtn);

    }

    public String getUserName()
    {
        return getText(username);
    }
    public String getRole()
    {
        return getText(role);
    }
    public String getLanguage()
    {
        return getText(language);
    }
    public String getGender()
    {
        return getText(gender);
    }
}
