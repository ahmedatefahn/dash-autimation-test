package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.util.Random;

public class Roles_Page extends PageBase{
    public Roles_Page(WebDriver driver) {
        super(driver);
    }

    By addRoleBtn = By.xpath("//span[contains(text() , 'Add Role')]");
    By permissionList = By.id("permissionsSelectOptions");
    By userModule = By.cssSelector("#permissionsSelectOptions ul li .user-module");
    By adminModule = By.cssSelector("#permissionsSelectOptions ul li .admin-module");
    By courseModule = By.cssSelector("#permissionsSelectOptions ul li .course-module");
    By consultationModule = By.cssSelector("#permissionsSelectOptions ul li .consultation-module");
    By surveyModule = By.cssSelector("#permissionsSelectOptions ul li .survey-module");
    By categoryModule = By.cssSelector("#permissionsSelectOptions ul li .category-module");
    By bankQuestionModule = By.cssSelector("#permissionsSelectOptions ul li .bankQuestion-module");
    By certificateModule = By.cssSelector("#permissionsSelectOptions ul li .certificate-module");
    By personalityModule = By.cssSelector("#permissionsSelectOptions ul li .personality-module");
    By settingModule = By.cssSelector("#permissionsSelectOptions ul li .setting-module");
    By paymentModule = By.cssSelector("#permissionsSelectOptions ul li .payment-module");
    By sliderModule = By.cssSelector("#permissionsSelectOptions ul li .slider-module");
    By currenciesModule = By.cssSelector("#permissionsSelectOptions ul li .currencies-module");
    By trackingModule = By.cssSelector("#permissionsSelectOptions ul li .tracking-module");
    By initiativeModule = By.cssSelector("#permissionsSelectOptions ul li .initiative-module");

    By delete = By.cssSelector(".b-dropdown.show ul li:nth-child(2) span");
    By confirmDelete = By.cssSelector(".modal-footer .btn-primary");

    By edit = By.cssSelector(".b-dropdown.show ul li:nth-child(1) span");



    public void clickAddButton()
    {
        Click(addRoleBtn);

    }
    public void clickSubmit()
    {
        Click(submitBtn);

    }
    public void addRole(String nameEN)
    {
        writeOnText(nameENTxt , nameEN +  new Random().nextInt(9999));
        Click(permissionList);
        Click(userModule);
        Click(adminModule);
        Click(courseModule);
        Click(consultationModule);
        Click(surveyModule);
        Click(categoryModule);
        Click(bankQuestionModule);
        Click(certificateModule);
        Click(personalityModule);
        Click(settingModule);
        Click(paymentModule);
        Click(sliderModule);
        Click(currenciesModule);
        Click(trackingModule);
        Click(initiativeModule);
        Click(submitBtn);
    }


    public void editRole(String nameEN, String nameENEdit) throws InterruptedException {
        clickAddButton();
        addRole(nameEN);
        openEditScreen();
        Thread.sleep(2000);
        clear(nameENTxt);
        writeOnText(nameENTxt , nameENEdit+  new Random().nextInt(9999));
        Thread.sleep(2000);
        Click(submitBtn);
    }

    public void openEditScreen() {
        Click(optionList);
        Click(edit);
    }

    public void delete() throws InterruptedException {
        clickOptions();
        Click(delete);
        Thread.sleep(3000);
        Click(confirmDelete);
    }


}
