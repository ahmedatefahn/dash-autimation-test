package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class Stories_Page extends PageBase{
    public Stories_Page(WebDriver driver) {
        super(driver);
    }

    By addStoryBtn = By.xpath("//span[contains(text() , 'Add Story')]");
    By text = By.id("content");
    By typeOption = By.id("typeSelectOptions");
    By textOption = By.cssSelector("#typeSelectOptions ul li .Text");
    By imageOption = By.cssSelector("#typeSelectOptions ul li .Image");
    By videoOption = By.cssSelector("#typeSelectOptions ul li .Video");
    By file = By.cssSelector("[for='file']");


    By delete = By.cssSelector(".b-dropdown.show ul li:nth-child(2) span");
    By confirmDelete = By.cssSelector(".modal-footer .btn-primary");



    public void clickAddButton(){
        waitElementToBeVisible(addStoryBtn);
        Click(addStoryBtn);
    }
    public void clickSubmit()
    {
        Click(submitBtn);

    }

    public void addStory(boolean textContect,boolean imageContent,String newStory) throws InterruptedException, AWTException {
        if (textContect){
            waitElementToBeVisible(text);
            writeOnText(text, newStory);
        } else if (imageContent) {
            waitElementToBeVisible(typeOption);
            Click(typeOption);
            waitElementToBeVisible(imageOption);
            Click(imageOption);
            Click(file);

            Thread.sleep(2000);
            uploadFile("ISTQB.png");
        //    writeOnText(text, newStory);
        }
        else {
            waitElementToBeVisible(typeOption);
            Click(typeOption);
            waitElementToBeVisible(videoOption);
            Click(videoOption);
            Click(file);

            Thread.sleep(2000);
            uploadFile("Video.mp4");
          //  writeOnText(text, newStory);
        }
        Click(submitBtn);

    }

    public void delete() throws InterruptedException {
        clickOptions();
        Click(delete);
        Thread.sleep(3000);
        waitElementToBeVisible(confirmDelete);
        Click(confirmDelete);
    }

}
