package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.util.Random;

public class Courses_Page extends PageBase {
    public Courses_Page(WebDriver driver) {
        super(driver);
    }

    By courseTitleEn = By.id("CourseTitleEn");
    By courseTitleAr = By.id("CourseTitleAr");
    By slugDetails = By.id("Slug");
    By catgegoryEn = By.id("catgegoryEn");
    By catgegoryAr = By.id("catgegoryAr");
    By levelDetails = By.id("Level");
    By statusDetails = By.id("Status");
    By languageDetails = By.id("Language");
    By priceDetails = By.id("Price");
    By surveyDetails = By.id("Survey");
    By typeDetails = By.id("Type");
    By descriptionEN = By.id("DescriptionEn");
    By descriptionAR = By.id("DescriptionAr");





    public void clickAddBtn() {
        Click(addCourse);

    }
    public void clickSubmit() {
        Click(submitBtn);

    }

    public void createCourse(boolean Live, boolean Published, boolean Free, String requiredTitleEN, String requiredTitleAR, String requiredSlug, String requiredPrice,
                             String requiredDesEN, String requiredDesAR, String requiredSEONameEN, String requiredSEONameAR,
                             String requiredSEONDescEN, String requiredSEONDescAR
    ) throws InterruptedException, AWTException {

        writeOnText(titleEN, requiredTitleEN + new Random().nextInt(9999));
        writeOnText(titleAR, requiredTitleAR + new Random().nextInt(9999));

        Click(category);
        Click(selectCategory);

        if (Live) {
            Click(type);
            Click(selectLiveType);
        }

        Click(image);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(thumbnailImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
/*
        waitElementToBeVisible(previewImage);
        Click(previewImage);
        Thread.sleep(2000);
        uploadFile("D:\\Photos\\Robin - 21723.mp4");
*/
        writeOnText(slug, requiredSlug + new Random().nextInt(9999));

        Click(level);
        Click(selectLevel);
        if (!Published) {
            Click(status);
            Click(selectDrafted);
        }
        Click(language);
        Click(selectLanguage);
        Click(survey);
        Click(selectSurvey);
        if (Free) {
            Click(paid);
            Click(selectFree);
        } else {
            Click(paid);
            writeOnText(price, requiredPrice);
            Click(currency);
            Click(selectCurrency);
        }
//        Click(certificate);
//        Click(selectCertificate);
        writeOnText(descEN, requiredDesEN);
        writeOnText(descAR, requiredDesAR);
        writeOnText(seoNameENTxt, requiredSEONameEN);
        writeOnText(seoNameARTxt, requiredSEONameAR);
        writeOnText(seoDesEN, requiredSEONDescEN);
        writeOnText(seoDesAR, requiredSEONDescAR);
        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(submitBtn);
    }


    public void editCourse(boolean Live, boolean Published, boolean Free, String requiredTitleEN, String requiredTitleAR, String requiredSlug, String requiredPrice,
                           String requiredDesEN, String requiredDesAR, String requiredSEONameEN, String requiredSEONameAR,
                           String requiredSEONDescEN, String requiredSEONDescAR, String editTitleEN,
                           String editTitleAR, String editSlug, boolean Drafted, boolean FreeEdit, String PriceEdit
    ) throws InterruptedException, AWTException {
        createCourse(Live, Published, Free, requiredTitleEN, requiredTitleAR, requiredSlug, requiredPrice,
                requiredDesEN, requiredDesAR, requiredSEONameEN, requiredSEONameAR,
                requiredSEONDescEN, requiredSEONDescAR);

        openEditScreen();

        waitElementToBeUnVisible(loader);
        Click(category);
        Click(selectCategory);

        writeOnText(titleEN, editTitleEN + new Random().nextInt(9999));
        writeOnText(titleAR, editTitleAR + new Random().nextInt(9999));

//        if (Live) {
//            Click(type);
//            Click(selectLiveType);
//        }

        Click(image);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(thumbnailImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
/*
        waitElementToBeVisible(previewImage);
        Click(previewImage);
        Thread.sleep(2000);
        uploadFile("D:\\Photos\\Robin - 21723.mp4");
*/
        writeOnText(slug, editSlug + new Random().nextInt(9999));
        Click(level);
        Click(selectLevel);
        if (Drafted) {

            Click(status);
            Click(selectDrafted);
        }
        Click(language);
        Click(selectLanguage);
        Click(survey);
        Click(selectSurvey);

        if (FreeEdit) {
            Click(paid);
            Click(selectFree);
        } else {
            Click(paid);
            Click(selectPaid);
            clear(price);
            writeOnText(price, PriceEdit);
            Click(currency);
            Click(selectCurrency);
        }
//        Click(certificate);
//        Click(selectCertificate);
        writeOnText(descEN, requiredDesEN);
        writeOnText(descAR, requiredDesAR);
        writeOnText(seoNameENTxt, requiredSEONameEN);
        writeOnText(seoNameARTxt, requiredSEONameAR);
        writeOnText(seoDesEN, requiredSEONDescEN);
        writeOnText(seoDesAR, requiredSEONDescAR);
        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(submitBtn);
    }

    public String getCourseTitleEN()
    {
        return getText(courseTitleEn);
    }
    public String getCourseTitleAR()
    {
        return getText(courseTitleAr);
    }    public String slugDetails()
    {
        return getText(slugDetails);
    }    public String getCategoryEN()
    {
        return getText(catgegoryEn);
    }    public String getCategoryAR()
    {
        return getText(catgegoryAr);
    }    public String getLevel()
    {
        return getText(levelDetails);
    }    public String getStatusDetails()
    {
        return getText(statusDetails);
    }    public String getLanguageDetails()
    {
        return getText(languageDetails);
    }    public String getPrice()
    {
        return getText(priceDetails);
    }    public String getSurvey()
    {
        return getText(surveyDetails);
    }    public String getType()
    {
        return getText(typeDetails);
    }    public String getDescriptionEN()
    {
        return getText(descriptionEN);
    }    public String getDescriptionAR()
    {
        return getText(descriptionAR);
    }

}
