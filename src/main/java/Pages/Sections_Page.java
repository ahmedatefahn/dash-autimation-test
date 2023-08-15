package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class Sections_Page extends PageBase {
    public Sections_Page(WebDriver driver) {
        super(driver);
    }

    By addSectionBTN = By.xpath("//span[contains(text() ,'Add Section')]");

    By course = By.id("courseSelectOptions");
    By selectOnlineCourse = By.cssSelector("#courseSelectOptions ul li .AutoOnlineCourse");

    By selectLiveCourse = By.cssSelector("#courseSelectOptions ul li .AutoLiveCourse");

    By status = By.id("statusSelectOptions");


    public void clickAddBtn()
    {
        Click(addSectionBTN);

    }
    public void clickSubmit()
    {
        Click(submitBtn);

    }
    public void addSection(boolean live,boolean active , String requiredTitleEN, String requiredTitleAR, String requiredSEONameEN, String requiredSEONameAR
            , String requiredSEONDescEN, String requiredSEONDescAR) throws InterruptedException, AWTException {
        waitElementToBeUnVisible(loader);
        writeOnText(titleEN, requiredTitleEN);
        writeOnText(titleAR, requiredTitleAR);
        waitElementToBeUnVisible(loader);
        Click(course);

        if (live) {
            Click(selectLiveCourse);
        } else {
            Click(selectOnlineCourse);
        }

        Click(status);
        if (active) {
            Click(selectActive);
        } else {
            Click(selectInactive);
        }

        writeOnText(seoNameENTxt, requiredSEONameEN);

        writeOnText(seoNameARTxt, requiredSEONameAR);

        writeOnText(seoDesEN, requiredSEONDescEN);

        writeOnText(seoDesAR, requiredSEONDescAR);

        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(submitBtn);
    }

    public void editSection(boolean live,boolean active, String requiredTitleEN, String requiredTitleAR, String requiredSEONameEN, String requiredSEONameAR
            , String requiredSEONDescEN, String requiredSEONDescAR, String TitleENEdit, String TitleAREdit
            , boolean activeEdit) throws InterruptedException, AWTException {
        addSection(live,active, requiredTitleEN, requiredTitleAR, requiredSEONameEN, requiredSEONameAR
                , requiredSEONDescEN, requiredSEONDescAR);
        openEditScreen();
        waitElementToBeUnVisible(loader);
        clear(titleEN);
        writeOnText(titleEN, TitleENEdit);
        clear(titleAR);
        writeOnText(titleAR, TitleAREdit);
        waitElementToBeUnVisible(loader);
//        Click(courseEdit);
//
//        if (live) {
//            Click(selectLiveCourse);
//        }
//        else {
//            Click(selectOnlineCourse);
//        }
        Click(status);
        if (activeEdit) {
            Click(selectActive);
        } else {
            Click(selectInactive);
        }
        clear(titleEN);
        writeOnText(titleEN, TitleENEdit);
        clear(titleAR);
        writeOnText(titleAR, TitleAREdit);
        writeOnText(seoNameENTxt, requiredSEONameEN);
        writeOnText(seoNameARTxt, requiredSEONameAR);
        writeOnText(seoDesEN, requiredSEONDescEN);
        writeOnText(seoDesAR, requiredSEONDescAR);
        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(submitBtn);
    }
}
