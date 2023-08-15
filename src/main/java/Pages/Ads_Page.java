package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class Ads_Page extends PageBase{
    public Ads_Page(WebDriver driver) {
        super(driver);
    }

    By addAdsBtn = By.xpath("//span[contains(text() , 'Add Ads')]");
    By moduleList = By.id("moduleSelectOptions");
    By selectCoursesModule = By.cssSelector("#moduleSelectOptions ul li .Courses");
    By imageAR = By.cssSelector("[for='image_ar']");



    public void clickAddButton()
    {
        waitElementToBeVisible(addAdsBtn);
        Click(addAdsBtn);
    }
    public void clickSubmit()
    {
        waitElementToBeVisible(submitBtn);
        Click(submitBtn);
    }


    public void addAds(String nameEN, String nameAR) throws InterruptedException, AWTException {
        waitElementToBeVisible(nameENTxt);
        writeOnText(nameENTxt, nameEN);
        waitElementToBeVisible(nameARTxt);
        writeOnText(nameARTxt, nameAR);
        waitElementToBeVisible(moduleList);
        Thread.sleep(5000);
        Click(moduleList);
        waitElementToBeVisible(selectCoursesModule);
        Click(selectCoursesModule);
        Click(image);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");

        Click(imageAR);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(submitBtn);

    }

    public void editAds(String nameEN, String nameAR, String nameENEdit, String nameAREdit) throws InterruptedException, AWTException {
        addAds( nameEN,  nameAR);
        openEditScreen();
        Thread.sleep(3000);
        waitElementToBeVisible(nameENTxt);
        writeOnText(nameENTxt, nameENEdit);
        waitElementToBeVisible(nameARTxt);
        writeOnText(nameARTxt, nameAREdit);
        Click(submitBtn);
    }
}
