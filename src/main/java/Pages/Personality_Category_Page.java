package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class Personality_Category_Page extends PageBase{
    public Personality_Category_Page(WebDriver driver) {
        super(driver);
    }

    By addCategoryBtn = By.xpath("//span[contains(text() , 'Add Category')]");


    public void clickAddBtn()
    {
        Click(addCategoryBtn);
    }
    public void addCategory(String titleENN, String titleARR , String desENN, String desARR
                            , String requiredSEONameEN, String requiredSEONameAR, String requiredSEONDescEN,
                            String requiredSEONDescAR) throws InterruptedException, AWTException {
        waitElementToBeVisible(titleEN);
        writeOnText(titleEN , titleENN);
        waitElementToBeVisible(titleAR);
        writeOnText(titleAR , titleARR);
        waitElementToBeVisible(descEN);
        writeOnText(descEN , desENN);
        waitElementToBeVisible(descAR);
        writeOnText(descAR , desARR);
        waitElementToBeVisible(seoNameENTxt);
        writeOnText(seoNameENTxt, requiredSEONameEN);

        waitElementToBeVisible(seoNameARTxt);
        writeOnText(seoNameARTxt, requiredSEONameAR);

        waitElementToBeVisible(seoDesEN);
        writeOnText(seoDesEN, requiredSEONDescEN);

        waitElementToBeVisible(seoDesAR);
        writeOnText(seoDesAR, requiredSEONDescAR);

        waitElementToBeVisible(seoImage);
        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        waitElementToBeVisible(submitBtn);
        Click(submitBtn);
    }

}
