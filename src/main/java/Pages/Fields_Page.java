package Pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.util.Random;

public class Fields_Page extends PageBase {
    public Fields_Page(WebDriver driver) {
        super(driver);
    }

    CommonElements commonElements;

    By addFieldBtn = By.xpath("//span[contains(text() , 'Add Field & Goal')]");
    By nameEN = By.id("name");
    By nameAR = By.id("name_ar");
    By type = By.id("type");
    By selectChild = By.cssSelector("#fieldsSelectOptions ul li .Edit516");

    By status = By.id("statusSelectOptions");
    By selectPublished = By.cssSelector("#statusSelectOptions ul li .Published");
    By selectDraft = By.cssSelector("#statusSelectOptions ul li .Drafted");

    By seoNameEN = By.id("seo_name_en");
    By seoNameAR = By.id("seo_name_ar");
    By seoDescEN = By.id("seo_description_en");
    By seoDescAR = By.id("seo_description_ar");
    By seoImage = By.cssSelector("div.custom-file.b-form-file");
    By ss = By.id("image_seo");
    By submitBtn = By.xpath("//button[@type = 'submit']");
    By loader = By.id("loading-spinner");


    public void clickAddBtn()
    {
        Click(addFieldBtn);

    }
    public void clickSubmit()
    {
        Click(submitBtn);
    }
    public void createParentFieldWithValidData(boolean parent,boolean Published , String requiredNameEN, String requiredNameAR, String requiredSEONameEN,
                                               String requiredSEONameAR, String requiredSEODesEN, String requiredSEODesAR) throws AWTException, InterruptedException {
        waitElementToBeUnVisible(loader);
        writeOnText(nameEN, requiredNameEN + new Random().nextInt(9999));
        writeOnText(nameAR, requiredNameAR + new Random().nextInt(9999));
        waitElementToBeUnVisible(loader);
        Click(type);
        if (!parent) {
            Click(type);
            Click(selectChild);
        }
        if(Published){
            Click(status);
            Click(selectPublished);
        }
        writeOnText(seoNameEN, requiredSEONameEN);
        writeOnText(seoNameAR, requiredSEONameAR);
        writeOnText(seoDescEN, requiredSEODesEN);
        writeOnText(seoDescAR, requiredSEODesAR);
        scrollToElement(seoImage);
        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(submitBtn);

    }

    public void editField(boolean parent,boolean Published ,boolean Drafted,boolean child, String requiredNameEN, String requiredNameAR,
                          String requiredSEONameEN, String requiredSEONameAR, String requiredSEODesEN,
                          String requiredSEODesAR,String EditNameEN , String EditNameAR
    ) throws InterruptedException, AWTException {
        createParentFieldWithValidData( parent, Published ,  requiredNameEN,  requiredNameAR,  requiredSEONameEN,
             requiredSEONameAR,  requiredSEODesEN,  requiredSEODesAR);
        openEditScreen();
        waitElementToBeUnVisible(loader);
        Thread.sleep(5000);
        clear(nameEN);
        writeOnText(nameEN, EditNameEN );
        clear(nameAR);
        writeOnText(nameAR, EditNameAR);
        waitElementToBeUnVisible(loader);
//        Click(type);
////        if (child) {
////            Click(type);
////            Click(selectChild);
////        }
        if(Drafted){
            Click(status);
            Click(selectDraft);
        }
        writeOnText(seoNameEN, requiredSEONameEN);
        writeOnText(seoNameAR, requiredSEONameAR);
        writeOnText(seoDescEN, requiredSEODesEN);
        writeOnText(seoDescAR, requiredSEODesAR);
        scrollToElement(seoImage);
        Click(seoImage);
        Thread.sleep(2000);
        uploadFile("ISTQB.png");
        Click(submitBtn);
    }


}
