package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.util.Random;

public class Certificate_Page extends PageBase {
    public Certificate_Page(WebDriver driver) {
        super(driver);
    }

    By addCertificateBTN = By.xpath("//span[contains(text() , 'Add Certificate')]");

    By submitBtn = By.xpath("//button[contains(text() , ' Submit ')]");


    public void clickAddBtn()
    {
        Click(addCertificateBTN);

    }
    public void clickSubmit()
    {
        Click(submitBtn);

    }
    public void addCertificate(String NameEN, String requiredSEONameEN, String requiredSEONameAR
            , String requiredSEONDescEN, String requiredSEONDescAR) throws InterruptedException, AWTException {
        Click(image);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        writeOnText(nameENTxt, NameEN+new Random().nextInt(9999));


        writeOnText(seoNameENTxt, requiredSEONameEN);

        writeOnText(seoNameARTxt, requiredSEONameAR);

        writeOnText(seoDesEN, requiredSEONDescEN);

        writeOnText(seoDesAR, requiredSEONDescAR);

        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");

        Click(submitBtn);
    }

    public void editCertificate(String NameEN, String requiredSEONameEN, String requiredSEONameAR
            , String requiredSEONDescEN, String requiredSEONDescAR,String NameENEdit) throws InterruptedException, AWTException {
        addCertificate(NameEN, requiredSEONameEN, requiredSEONameAR
                , requiredSEONDescEN, requiredSEONDescAR);
        openEditScreen();
        Click(image);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        writeOnText(nameENTxt, NameENEdit);


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
