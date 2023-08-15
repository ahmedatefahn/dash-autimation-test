package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.util.Random;

public class Activity_Page extends PageBase {
    public Activity_Page(WebDriver driver) {
        super(driver);
    }

    By addActivityBtn = By.xpath("//span[contains(text() , 'Add Activity')]");
    By trackingSystemList = By.id("trackingSelectOptions");
    By selectTracking = By.cssSelector("#trackingSelectOptions ul li .Automation.Tracking");

    By nameEN = By.id("name");
    By nameAR = By.id("name_ar");
    By intro = By.id("introId");

    By shortDescriptionENTxt = By.id("short_description");
    By shortDescriptionARTxt = By.id("short_description_ar");
    By longDescriptionENTxt = By.id("long_description");
    By longDescriptionARTxt = By.id("long_description_ar");
    By video = By.xpath("(//label[@class = 'custom-file-label'])[2]");

    By quizList = By.id("quiz");
    By repetitionList = By.cssSelector("[for='repetition']");
    By selectDailyRepetition = By.cssSelector("#repetitionSelectOptions ul li .Daily");

    By selectWeeklyRepetition = By.cssSelector("#repetitionSelectOptions ul li .Weekly");
    By selectMonthlyRepetition = By.cssSelector("#repetitionSelectOptions ul li .Monthly");
    By selectOneTimeRepetition = By.cssSelector("#repetitionSelectOptions ul li .One.Time");

    By dateType = By.id("dateTypeSelectOptions");
    By selectDate = By.cssSelector("#dateTypeSelectOptions ul li .Date");
    By selectCustom = By.cssSelector("#dateTypeSelectOptions ul li .Custom");






    By attachmentEN = By.cssSelector("[for='attachment-1-en']");
    By attachmentAR = By.cssSelector("[for='attachment-1-ar']");


    By addAttachmentBTN = By.xpath("//span[contains(text() , 'Add PDF Attachment')]");
    By seoImage = By.id("image_seo");
    By submitBtn = By.xpath("//button[@type = 'submit']");
  //  By loader = By.id("loading-spinner");
    By loader = By.cssSelector("[role='status']");



    public void clickAddBtn()
    {
        Click(addActivityBtn);

    }
    public void clickSubmit()
    {
        Click(submitBtn);

    }
    public void createActivityWithValidData(boolean Daily ,boolean Weekly ,boolean Monthly ,
                                            boolean OneTime,boolean Custom ,String requiredNameEN, String requiredNameAR,
                                            String requiredShortDesEN, String requiredShortDesAR,
                                            String requiredLongDesEN, String requiredLongDesAR) throws InterruptedException, AWTException {
        waitElementToBeUnVisible(loader);
        writeOnText(nameEN, requiredNameEN + new Random().nextInt(9999));
        writeOnText(nameAR, requiredNameAR+ new Random().nextInt(9999)
        );
        waitElementToBeUnVisible(loader);
        Click(trackingSystemList);
        waitElementToBeUnVisible(loader);
        Click(selectTracking);
        //   waitElementToBeUnVisible(loader);
//        waitElementToBeVisible(intro);
//          Click(intro);
//          Thread.sleep(2000);
//        uploadFile("D:\\Courses\\Appium\\Explicit Wait.mp4");
        writeOnText(shortDescriptionENTxt, requiredShortDesEN);
        writeOnText(shortDescriptionARTxt, requiredShortDesAR);
        writeOnText(longDescriptionENTxt, requiredLongDesEN);
        writeOnText(longDescriptionARTxt, requiredLongDesAR);
//        scrollToElement(video);
//        waitElementToBeVisible(video);
//        Click(video);
//        uploadFile("D:\\Courses\\Appium\\Explicit Wait.mp4");
        //      waitElementToBeVisible(quizList);
        //     waitElementToBeVisible(repetitionList);

        Click(repetitionList);

        if (Daily){

            Click(selectDailyRepetition);
        } else if (Weekly) {

            Click(selectWeeklyRepetition);
        }
        else if (Monthly) {
            Click(selectMonthlyRepetition);
        }
        else if (OneTime) {
            Click(selectOneTimeRepetition);
            Click(dateType);

            if (Custom){
                Click(selectCustom);
            }
            else {
                Click(selectDate);
            }
        }

        Click(addAttachmentBTN);
        Click(attachmentEN);
        uploadFile("Sample.pdf");
        Click(attachmentAR);
        uploadFile("Sample.pdf");
        Click(submitBtn);

    }

    public void editActivity(boolean Daily ,boolean Weekly ,boolean Monthly ,
                             boolean OneTime,boolean DateRange ,String requiredNameEN, String requiredNameAR,
                             String requiredShortDesEN, String requiredShortDesAR,
                             String requiredLongDesEN, String requiredLongDesAR,
    String requiredNameENEdit ,String requiredNameAREdit,boolean DailyEdit ,
                             boolean WeeklyEdit,boolean MonthlyEdit, boolean OneTimeEdit,
    boolean Custom) throws InterruptedException, AWTException {
        createActivityWithValidData( Daily , Weekly , Monthly , OneTime, DateRange , requiredNameEN,  requiredNameAR, requiredShortDesEN,  requiredShortDesAR, requiredLongDesEN,  requiredLongDesAR);
        openEditScreen();
        waitElementToBeUnVisible(loader);
        clear(nameEN);
        writeOnText(nameEN, requiredNameENEdit);
        clear(nameAR);
        writeOnText(nameAR, requiredNameAREdit);
        waitElementToBeUnVisible(loader);
        Click(trackingSystemList);
        waitElementToBeUnVisible(loader);
        Click(selectTracking);

        clear(nameEN);
        writeOnText(nameEN, requiredNameENEdit);
        clear(nameAR);
        writeOnText(nameAR, requiredNameAREdit);
        //   waitElementToBeUnVisible(loader);
//        waitElementToBeVisible(intro);
//          Click(intro);
//          Thread.sleep(2000);
//        uploadFile("D:\\Courses\\Appium\\Explicit Wait.mp4");
        writeOnText(shortDescriptionENTxt, requiredShortDesEN);
        writeOnText(shortDescriptionARTxt, requiredShortDesAR);
        writeOnText(longDescriptionENTxt, requiredLongDesEN);
        writeOnText(longDescriptionARTxt, requiredLongDesAR);
//        scrollToElement(video);
//        waitElementToBeVisible(video);
//        Click(video);
//        uploadFile("D:\\Courses\\Appium\\Explicit Wait.mp4");
        //      waitElementToBeVisible(quizList);
        //     waitElementToBeVisible(repetitionList);

        Click(repetitionList);
        if (DailyEdit){

            Click(selectDailyRepetition);
        } else if (WeeklyEdit) {
            Thread.sleep(3000);
            Click(selectWeeklyRepetition);
        }
        else if (MonthlyEdit) {
            Click(selectMonthlyRepetition);
        }
        else if (OneTimeEdit) {
            Click(selectOneTimeRepetition);
            Click(dateType);

            if (Custom){
                Click(selectCustom);
            }
            else {
                Click(selectDate);
            }
        }
        Click(addAttachmentBTN);
        Click(attachmentEN);
        uploadFile("Sample.pdf");
        Click(attachmentAR);
        uploadFile("Sample.pdf");
        Click(submitBtn);
    }


}
