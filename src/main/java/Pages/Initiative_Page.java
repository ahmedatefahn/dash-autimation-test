package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Initiative_Page extends PageBase {
    public Initiative_Page(WebDriver driver) {
        super(driver);
    }

    By addInitiativeBtn = By.xpath("//span[contains(text() , 'Add Initiative')]");


    By introPath = By.cssSelector("[for='intro_path_type']");
    By selectImage = By.cssSelector("#introPathSelectOptions ul li .Image");


    By nameEN = By.id("name");
    By nameAR = By.id("name_ar");


    By shortDescriptionENTxt = By.id("short_description");
    By shortDescriptionARTxt = By.id("short_description_ar");
    By longDescriptionENTxt = By.id("long_description");
    By longDescriptionARTxt = By.id("long_description_ar");

    By trackingSystemList = By.id("tracking_id");
    By selectTracking = By.cssSelector("#trackingSelectOptions ul li .Automation.Tracking25123");

    By startDate = By.cssSelector("[for='start_date_picker']");
    By startDate2 = By.cssSelector("[for='Edit4654-0-start-date']");
    By selectDate = By.xpath("//span[contains(text() , '27')]");

    By currentActiveDate = By.cssSelector("span.btn.border-0.rounded-circle.text-nowrap.btn-light.font-weight-bold");


    By status = By.cssSelector("[for='status']");
    By selectPublish = By.cssSelector("#statusSelectOptions ul li .Published");

    By seoNameENTxt = By.id("seo_name_en");
    By seoNameARTxt = By.id("seo_name_ar");
    By seoDesEN = By.id("seo_description_en");
    By seoDesAR = By.id("seo_description_ar");
    By seoImage = By.cssSelector("[for='image_seo']");

    By video = By.xpath("(//label[@class = 'custom-file-label'])[2]");

    By quizList = By.id("quiz");
    By repetitionList = By.cssSelector("[for='repetition']");
    By selectRepetition = By.cssSelector("#repetitionSelectOptions ul li .Daily");
    By attachment = By.xpath("(//label[@class = 'custom-file-label'])[3]");
    By submitBtn = By.xpath("//button[@type = 'submit']");
    By loader = By.cssSelector("[role='status']");


    By introEN = By.id("introPathIdEn");
    By introAR = By.id("introPathIdAr");


    public void clickAddBtn()
    {
        Click(addInitiativeBtn);

    }

    public void clickSubmit()
    {
        Click(submitBtn);

    }
    public void addInitiative(boolean Published ,String requiredNameEN, String requiredNameAR,
                              String requiredShortDesEN, String requiredShortDesAR,
                              String requiredLongDesEN, String requiredLongDesAR,
                              String requiredSEONameEN, String requiredSEONameAR,
                              String requiredSEONDescEN, String requiredSEONDescAR) throws InterruptedException, AWTException {
        waitElementToBeUnVisible(loader);
        Click(introPath);
        waitElementToBeUnVisible(loader);
        Click(selectImage);

        Click(introEN);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(introAR);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");

        writeOnText(nameEN, requiredNameEN+new Random().nextInt(9999));
        writeOnText(nameAR, requiredNameAR+new Random().nextInt(9999));
        waitElementToBeUnVisible(loader);



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

        Click(trackingSystemList);
        Click(selectTracking);

        Click(startDate);


        Click(currentActiveDate);

        Click(startDate2);
        Click(selectDate);
        if (Published) {
            Click(status);
        }
        Click(selectPublish);
        writeOnText(seoNameENTxt, requiredSEONameEN);

        writeOnText(seoNameARTxt, requiredSEONameAR);

        writeOnText(seoDesEN, requiredSEONDescEN);

        writeOnText(seoDesAR, requiredSEONDescAR);

        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(submitBtn);
    }


    public static String getNextDate(String curDate) {
        String nextDate = "";
        try {
            Calendar today = Calendar.getInstance();
            DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            Date date = format.parse(curDate);
            today.setTime(date);
            today.add(Calendar.DAY_OF_YEAR, 1);
            nextDate = format.format(today.getTime());
        } catch (Exception e) {
            return nextDate;
        }
        return nextDate;
    }
}
