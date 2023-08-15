package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.Random;

public class TrackingSystem_Page extends PageBase {
    public TrackingSystem_Page(WebDriver driver) {
        super(driver);
    }

    By addTrackingSystemBtn = By.xpath("//span[contains(text() , 'Add Tracking System')]");
    By loader = By.id("loading-spinner");
    By introPath = By.cssSelector("[for='intro_path_type']");
    By introPathParent = By.cssSelector("#introPathSelectOptions ul li");

    By selectImage = By.cssSelector("#introPathSelectOptions ul li .Image");
    By selectVideo = By.cssSelector("#introPathSelectOptions ul li .Video");





    By nameENTxt = By.id("name");
    By nameARTxt = By.id("name_ar");
    By imageEN = By.id("imageIdEn");
    By imageAR = By.id("imageIdAr");

    By shortDescriptionENTxt = By.id("short_description");
    By shortDescriptionARTxt = By.id("short_description_ar");
    By longDescriptionENTxt = By.id("long_description");
    By longDescriptionARTxt = By.id("long_description_ar");
    By field = By.cssSelector("[for = 'field']");
    By selectField = By.cssSelector("#fieldsSelectOptions ul li .AutomationField");
    By durationTxt = By.id("duration");
    By status = By.cssSelector("[for='status']");

    By selectPublish = By.cssSelector("#statusSelectOptions ul li .Published");
    By selectDrafted = By.cssSelector("#statusSelectOptions ul li .Drafted");

    By freePaid = By.id("free");
    By seoNameENTxt = By.id("seo_name_en");
    By seoNameARTxt = By.id("seo_name_ar");
    By seoDesEN = By.id("seo_description_en");
    By seoDesAR = By.id("seo_description_ar");
    By seoImage = By.cssSelector("[for='image_seo']");
    By submitBtn = By.xpath("//span[contains(text() , 'Submit')]");

    By searchTxt = By.cssSelector("input.d-inline-block.mr-1.form-control");
    By paid = By.id("paidSelectOptions");
    By selectPaid = By.cssSelector("#paidSelectOptions ul li .Paid");
    By price = By.id("price");



    public void clickAddBtn()
    {
        Click(addTrackingSystemBtn);

    }
    public void createTrackingSystemWithValidData(boolean image, boolean published, String requiredNameEN, String requiredNameAR,
                                                  String requiredShortDesEN, String requiredShortDesAR,
                                                  String requiredLongDesEN, String requiredLongDesAR,
                                                  String requiredDuration, String requiredSEONameEN, String requiredSEONameAR,
                                                  String requiredSEONDescEN, String requiredSEONDescAR) throws InterruptedException, AWTException {

        waitElementToBeUnVisible(loader);
        Click(introPath);
        waitElementToBeUnVisible(loader);
        //   selectByVisibleTXT(introPathParent , "Image");
        if (image) {
            Click(selectImage);
            Thread.sleep(2000);
            Click(introEN);
            uploadFile("ISTQB.png");
            Click(introAR);
            Thread.sleep(2000);
            uploadFile("ISTQB.png");
        }
        else {
            Click(introEN);
            Thread.sleep(2000);
            uploadFile("Video.mp4");
            Click(introAR);
            Thread.sleep(2000);
            uploadFile("Video.mp4");
        }

        writeOnText(nameENTxt, requiredNameEN + new Random().nextInt(9999));
        writeOnText(nameARTxt, requiredNameAR + new Random().nextInt(9999));
        Click(imageEN);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(imageAR);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");

        writeOnText(shortDescriptionENTxt, requiredShortDesEN);

        writeOnText(shortDescriptionARTxt, requiredShortDesAR);

        writeOnText(longDescriptionENTxt, requiredLongDesEN);

        writeOnText(longDescriptionARTxt, requiredLongDesAR);

        Click(field);
        //   System.out.println(currentDriver.findElement(By.cssSelector("#introPathSelectOptions ul")).getAttribute("innerHTML"));
        Click(selectField);
        writeOnText(durationTxt, requiredDuration);
        Click(status);
        if (published) {
            Click(selectPublish);
        }
        writeOnText(seoNameENTxt, requiredSEONameEN);
        writeOnText(seoNameARTxt, requiredSEONameAR);
        writeOnText(seoDesEN, requiredSEONDescEN);
        writeOnText(seoDesAR, requiredSEONDescAR);

        scrollToElement(seoImage);
        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Thread.sleep(2000);
        Click(submitBtn);
    }

    public void editTracking(boolean image, boolean published, String requiredNameEN, String requiredNameAR,
                             String requiredShortDesEN, String requiredShortDesAR,
                             String requiredLongDesEN, String requiredLongDesAR,
                             String requiredDuration, String requiredSEONameEN, String requiredSEONameAR,
                             String requiredSEONDescEN, String requiredSEONDescAR, String EditNameEN,
                             String EditNameAR,boolean Video   ,boolean Drafted,boolean Paid,String requiredDurationEdit) throws InterruptedException, AWTException {
        createTrackingSystemWithValidData(image, published, requiredNameEN, requiredNameAR, requiredShortDesEN, requiredShortDesAR, requiredLongDesEN, requiredLongDesAR, requiredDuration, requiredSEONameEN, requiredSEONameAR, requiredSEONDescEN, requiredSEONDescAR);
        openEditScreen();
        waitElementToBeUnVisible(loader);
        Click(introPath);
        waitElementToBeUnVisible(loader);
        if (Video) {
            Click(selectVideo);
        }
        Click(introEN);
        Thread.sleep(2000);
        uploadFile("Video.mp4");
        Click(introAR);
        Thread.sleep(2000);
        uploadFile("Video.mp4");
        clear(nameENTxt);
        writeOnText(nameENTxt, EditNameEN);
        clear(nameARTxt);
        writeOnText(nameARTxt, EditNameAR);
        Click(imageEN);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(imageAR);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");

        writeOnText(shortDescriptionENTxt, requiredShortDesEN);

        writeOnText(shortDescriptionARTxt, requiredShortDesAR);

        writeOnText(longDescriptionENTxt, requiredLongDesEN);

        writeOnText(longDescriptionARTxt, requiredLongDesAR);

        Click(field);
        Click(selectField);
        writeOnText(durationTxt, requiredDurationEdit);
        Click(status);
        if (Drafted) {
            Click(selectDrafted);
        }
        if (Paid) {
            Click(paid);
            Click(selectPaid);
            writeOnText(price , "1");
        }
        writeOnText(seoNameENTxt, requiredSEONameEN);
        writeOnText(seoNameARTxt, requiredSEONameAR);
        writeOnText(seoDesEN, requiredSEONDescEN);
        writeOnText(seoDesAR, requiredSEONDescAR);

        scrollToElement(seoImage);
        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Thread.sleep(2000);
        Click(submitBtn);

    }

    public void clickSubmit()
    {
        Click(submitBtn);
    }

}

