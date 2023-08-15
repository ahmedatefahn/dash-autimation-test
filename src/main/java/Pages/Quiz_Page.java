package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class Quiz_Page extends PageBase {
    public Quiz_Page(WebDriver driver) {
        super(driver);
    }

    By addQuizBTN = By.xpath("//span[contains(text() , 'Add Quiz')]");

    By passingPercentageTXT = By.id("passing_precentage");

    By q1EN = By.id("item-name");
    By q1AR = By.id("item-name-ar");
    By answer1EN = By.id("answer00");
    By answer1AR = By.id("answer00 AR");
    By isCorrectCheck1 = By.cssSelector("[for='00']");
    By addAnswerBTN = By.xpath("//span[contains(text() , 'Add Answer')]");
    By answer2EN = By.id("answer11");
    By answer2AR = By.id("answer11 AR");

    By courseEdit = By.id("course");

    By titleAREdit = By.id("title");



    public void clickAddBtn()
    {
        Click(addQuizBTN);

    }
    public void clickSubmit()
    {
        Click(submitBtn);

    }
    public void addNewQuiz(boolean live, String requiredTitleEN, String requiredTitleAR, String requiredSEONameEN
            , String requiredSEONameAR, String requiredSEONDescEN, String requiredSEONDescAR
            , String Q1EN, String Q1AR, String Answer1EN, String Answer1AR, String Answer2EN, String Answer2AR) throws InterruptedException, AWTException {
        waitElementToBeUnVisible(loader);
        writeOnText(titleEN, requiredTitleEN);
        writeOnText(titleAR, requiredTitleAR);
        waitElementToBeUnVisible(loader);
        Click(course);
        if (live) {
            Click(selectLiveCourse);
            Click(section);
            Click(selectLiveSection);
        } else {
            Click(selectOnlineCourse);
            Click(section);
            Click(selectOnlineSection);
        }
        writeOnText(passingPercentageTXT, "80");
        writeOnText(seoNameENTxt, requiredSEONameEN);

        writeOnText(seoNameARTxt, requiredSEONameAR);

        writeOnText(seoDesEN, requiredSEONDescEN);

        writeOnText(seoDesAR, requiredSEONDescAR);

        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        writeOnText(q1EN, Q1EN);
        writeOnText(q1AR, Q1AR);
        writeOnText(answer1EN, Answer1EN);
        writeOnText(answer1AR, Answer1AR);
        Click(isCorrectCheck1);
        Click(addAnswerBTN);
        writeOnText(answer2EN, Answer2EN);
        writeOnText(answer2AR, Answer2AR);
        Click(submitBtn);

    }


    public void editNewQuiz(boolean live, String requiredTitleEN, String requiredTitleAR, String requiredSEONameEN
            , String requiredSEONameAR, String requiredSEONDescEN, String requiredSEONDescAR
            , String Q1EN, String Q1AR, String Answer1EN, String Answer1AR, String Answer2EN, String Answer2AR
            , String TitleENEdit, String TitleAREdit, boolean liveEdit, String Q1ENEdit, String Q1AREdit, String Answer1ENEdit
            , String Answer1AREdit, String Answer2ENEdit, String Answer2AREdit) throws InterruptedException, AWTException {
        addNewQuiz(live, requiredTitleEN, requiredTitleAR, requiredSEONameEN
                , requiredSEONameAR, requiredSEONDescEN, requiredSEONDescAR
                , Q1EN, Q1AR, Answer1EN, Answer1AR, Answer2EN, Answer2AR);
        openEditScreen();
        waitElementToBeUnVisible(loader);
//        clear(titleEN);
//        writeOnText(titleEN, TitleENEdit);
//        clear(titleAR);
//        writeOnText(titleAR, TitleAREdit);
//        waitElementToBeUnVisible(loader);



        Click(course);
        if (liveEdit) {
            Click(selectLiveCourse);
            Click(section);
            Click(selectLiveSection);
        } else {
            Click(selectOnlineCourse);
            Click(section);
            Click(selectOnlineSection);
        }
        clear(titleEN);
        writeOnText(titleEN, TitleENEdit);
        clear(titleAREdit);
        writeOnText(titleAREdit, TitleAREdit);

        clear(passingPercentageTXT);
        writeOnText(passingPercentageTXT, "50");
        writeOnText(seoNameENTxt, requiredSEONameEN);

        writeOnText(seoNameARTxt, requiredSEONameAR);

        writeOnText(seoDesEN, requiredSEONDescEN);

        writeOnText(seoDesAR, requiredSEONDescAR);

        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        clear(q1EN);
        writeOnText(q1EN, Q1ENEdit);
        clear(q1AR);
        writeOnText(q1AR, Q1AREdit);
        clear(answer1EN);
        writeOnText(answer1EN, Answer1ENEdit);
        clear(answer1AR);
        writeOnText(answer1AR, Answer1AREdit);
        Click(addAnswerBTN);
        clear(answer2EN);
        writeOnText(answer2EN, Answer2ENEdit);
        clear(answer2AR);
        writeOnText(answer2AR, Answer2AREdit);
        Click(submitBtn);

    }
}
