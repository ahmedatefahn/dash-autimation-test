package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class Slider_Page extends PageBase {
    public Slider_Page(WebDriver driver) {
        super(driver);
    }


    By addSliderBTN = By.xpath("//span[contains(text() , 'Add Slider')]");

    By displayOn = By.cssSelector("[for='display_in']");

    By status = By.id("statusSelectOptions");


    By selectMobile = By.cssSelector("#displaySelectOptions ul li .Mobile");
    By selectAll = By.cssSelector("#displaySelectOptions ul li .All");

    By imageAR = By.cssSelector("[for='image_ar']");


    public void clickAddBtn()
    {
        Click(addSliderBTN);

    }

    public void addSlider(boolean Mobile, boolean All, boolean InActive, String NameEN, String NameAR) throws InterruptedException, AWTException {
        writeOnText(nameENTxt, NameEN);
        writeOnText(nameARTxt, NameAR);
        if (Mobile) {
            Click(displayOn);
            Click(selectMobile);
        } else if (All) {
            Click(displayOn);
            Click(selectAll);
        }
        if (InActive) {
            Click(status);
            Click(selectInactive);
        }
        Click(image);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");

        Click(imageAR);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(submitBtn);

    }

    public void editSlider(boolean Mobile, boolean All, boolean InActive, String NameEN, String NameAR
    , String NameENEdit, String NameAREdit , boolean MobileEdit,boolean AllEdit,boolean InActiveEdit) throws InterruptedException, AWTException {
        addSlider(Mobile, All, InActive, NameEN, NameAR);
        openEditScreen();
        waitElementToBeUnVisible(loader);
        clear(nameENTxt);
        writeOnText(nameENTxt, NameENEdit);
        clear(nameARTxt);
        writeOnText(nameARTxt, NameAREdit);
        if (MobileEdit) {
            Click(displayOn);
            Click(selectMobile);
        } else if (AllEdit) {
            Click(displayOn);
            Click(selectAll);
        }
        if (InActiveEdit) {
            Click(status);
            Click(selectInactive);
        }
        Click(image);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(imageAR);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        clear(nameENTxt);
        writeOnText(nameENTxt, NameENEdit);
        clear(nameARTxt);
        writeOnText(nameARTxt, NameAREdit);
        Click(submitBtn);
    }

}
