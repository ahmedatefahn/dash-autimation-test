package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class JobTitle_Page extends PageBase{
    public JobTitle_Page(WebDriver driver) {
        super(driver);
    }

    By addJobBTN = By.xpath("//span[contains(text() , 'Add Job Title')]");
    By titleEN = By.id("title_en");
    By titleAR = By.id("title_ar");

    By delete = By.cssSelector(".b-dropdown.show ul li:nth-child(2) span");

    By confirmDelete = By.cssSelector(".modal-footer .btn-primary");
    By optionList = By.xpath("(//button[@class = 'btn dropdown-toggle btn-link dropdown-toggle-no-caret'])[1]");


    public void clickAddBtn(){
        Click(addJobBTN);

    }
    public void clickSubmit()
    {
        Click(submitBtn);

    }

    public void addActiveJob( String TitleEN ,String TitleAR )
    {
        waitElementToBeVisible(titleEN);
        writeOnText(titleEN , TitleEN + new Random().nextInt(99999));
        waitElementToBeVisible(titleAR);
        writeOnText(titleAR , TitleAR + new Random().nextInt(99999));
        waitElementToBeVisible(submitBtn);
        Click(submitBtn);
    }

    public void delete() throws InterruptedException {
        waitElementToBeVisible(optionList);
        Click(optionList);
        waitElementToBeVisible(delete);
        Click(delete);
        Thread.sleep(3000);
        waitElementToBeVisible(confirmDelete);
        Click(confirmDelete);
    }
}
