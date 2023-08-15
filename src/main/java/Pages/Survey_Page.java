package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class Survey_Page extends PageBase {
    public Survey_Page(WebDriver driver) {
        super(driver);
    }

    By addSurveyBTN = By.xpath("//span[contains(text() , 'Add Survey')]");

    By titleEN = By.id("title_en");
    By titleAR = By.id("title_ar");

    By QEN1 = By.id("question-1-en");
    By QAR1 = By.id("question-1-ar");

    By QEN2 = By.id("question-2-en");
    By QAR2 = By.id("question-2-ar");

    By addNewQuestionBTN = By.xpath("//span[contains(text() , 'Add New Question')]");


    public void clickAddBtn()
    {
        Click(addSurveyBTN);

    }
    public void clickSubmit()
    {
        Click(submitBtn);

    }
    public void addSurvey(String NameEN, String NameAR, String requiredSEONameEN, String requiredSEONameAR
            , String requiredSEONDescEN, String requiredSEONDescAR, String QNEN1, String QNAR1,
    String QENN2 , String QEARR2) throws InterruptedException, AWTException {
        writeOnText(titleEN, NameEN);
        writeOnText(titleAR, NameAR);
        writeOnText(seoNameENTxt, requiredSEONameEN);
        writeOnText(seoNameARTxt, requiredSEONameAR);
        writeOnText(seoDesEN, requiredSEONDescEN);
        writeOnText(seoDesAR, requiredSEONDescAR);
        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        writeOnText(QEN1, QNEN1);
        writeOnText(QAR1, QNAR1);
        Click(addNewQuestionBTN);
        writeOnText(QEN2, QENN2);
        writeOnText(QAR2, QEARR2);
        Click(submitBtn);
    }

    public void editSurvey(String NameEN, String NameAR, String requiredSEONameEN, String requiredSEONameAR
            , String requiredSEONDescEN, String requiredSEONDescAR, String QNEN1, String QNAR1,
                          String QENN2 , String QEARR2,String NameENEdit,String NameAREdit,String QNEN1Edit
    ,String QNAR1Edit , String QENN2Edit ,String QEARR2Edit) throws InterruptedException, AWTException {

        addSurvey( NameEN,  NameAR,  requiredSEONameEN,  requiredSEONameAR
                ,  requiredSEONDescEN,  requiredSEONDescAR,  QNEN1,  QNAR1,
                 QENN2 ,  QEARR2);
        openEditScreen();
        waitElementToBeUnVisible(loader);
        writeOnText(titleEN, NameENEdit);
        writeOnText(titleAR, NameAREdit);
        writeOnText(seoNameENTxt, requiredSEONameEN);
        writeOnText(seoNameARTxt, requiredSEONameAR);
        writeOnText(seoDesEN, requiredSEONDescEN);
        writeOnText(seoDesAR, requiredSEONDescAR);
        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        writeOnText(QEN1, QNEN1Edit);
        writeOnText(QAR1, QNAR1Edit);
        Click(addNewQuestionBTN);
        writeOnText(QEN2, QENN2Edit);
        writeOnText(QAR2, QEARR2Edit);
        Click(submitBtn);
    }

}
