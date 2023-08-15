package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class Lesson_Page extends PageBase {
    public Lesson_Page(WebDriver driver) {
        super(driver);
    }

    By addLessonBTN = By.xpath("//span[contains(text() , 'Add Lesson')]");

    By contentType = By.cssSelector("[for='contentType']");
    By selectPDF = By.cssSelector("#contentTypeSelectOptions ul li .PDF");

    By chooseTimeTXT = By.id("example-input");
    By consultant = By.id("consultantSelectOptions");
    By selectConsultant = By.cssSelector("#consultantSelectOptions ul li .admin");
    By sessionDuration = By.id("session_duration");

    // Details
    By titleENDetails = By.id("TitleEn");
    By titleArDetails = By.id("TitleAr");
    By courseEnDetails = By.id("CourseEn");
    By courseArDetails = By.id("CourseAr");
    By sectionEnDetails = By.id("SectionEn");
    By sectionArDetails = By.id("SectionAr");
    By contentTypeDetails = By.id("ContentType");
//    By contentType = By.id("ContentType");
//    By sessionDuration = By.id("session_duration");


    By file = By.cssSelector("[for='file']");

    public void clickAddBtn()
    {
        Click(addLessonBTN);

    }
    public void clickSubmit()
    {
        Click(submitBtn);

    }
    public void addLesson(boolean live, String requiredTitleEN, String requiredTitleAR, String requiredSEONameEN, String requiredSEONameAR
            , String requiredSEONDescEN, String requiredSEONDescAR) throws InterruptedException, AWTException {
        writeOnText(titleEN, requiredTitleEN);
        writeOnText(titleAR, requiredTitleAR);
        waitElementToBeUnVisible(loader);
        Click(course);
        if (live) {
            Click(selectLiveCourse);
            Click(section);
            Click(selectLiveSection);
            writeOnText(chooseTimeTXT, "23:00:00");
            Click(consultant);
            Click(selectConsultant);
            writeOnText(sessionDuration, "5");
        } else {
            Click(selectOnlineCourse);
            Click(section);
            Click(selectOnlineSection);
            // waitElementToBeVisible();
            Click(contentType);
            Click(selectPDF);
            Click(file);
            Thread.sleep(2000);
            uploadFile("Sample.pdf");
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

    public void editLesson(boolean live, String requiredTitleEN, String requiredTitleAR, String requiredSEONameEN, String requiredSEONameAR
            , String requiredSEONDescEN, String requiredSEONDescAR,String TitleENEdit , String TitleAREdit , boolean liveEdit) throws InterruptedException, AWTException {
        addLesson( live,  requiredTitleEN,  requiredTitleAR,  requiredSEONameEN,  requiredSEONameAR
                ,  requiredSEONDescEN,  requiredSEONDescAR);
        openEditScreen();
        writeOnText(titleEN, TitleENEdit);
        writeOnText(titleAR, TitleAREdit);
        waitElementToBeUnVisible(loader);
        Click(course);
        if (liveEdit) {
            Click(selectLiveCourse);
            Click(section);
            Click(selectLiveSection);
            writeOnText(chooseTimeTXT, "23:00:00");
            Click(consultant);
            Click(selectConsultant);
            writeOnText(sessionDuration, "5");
        } else {
            Click(selectOnlineCourse);
            Click(section);
            Click(selectOnlineSection);
            // waitElementToBeVisible();
            Click(contentType);
            Click(selectPDF);
            Click(file);
            Thread.sleep(2000);
            uploadFile("Sample.pdf");
        }
        writeOnText(titleEN, TitleENEdit);
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

    public String getCourseNameEn()
    {
        return getText(titleENDetails);
    }
    public String getCourseNameAr()
    {
        return getText(titleArDetails);
    } public String getCourseEn()
    {
        return getText(courseEnDetails);
    } public String getCourseAr()
    {
        return getText(courseArDetails);
    } public String getSectionNameEn()
    {
        return getText(sectionEnDetails);
    } public String getSectionNameAr()
    {
        return getText(sectionArDetails);
    }public String getContentType()
    {
        return getText(contentTypeDetails);
    }
}
