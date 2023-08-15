package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Fields_Consultations_Page extends PageBase {
    public Fields_Consultations_Page(WebDriver driver) {
        super(driver);
    }

    By addFiledBTN = By.xpath("//span[contains(text() , 'Add Field')]");


    public void clickAddBtn()
    {
        Click(addFiledBTN);

    }
    public void clickSubmit()
    {
        Click(submitBtn);

    }
    public void addConsultantField(String TitleEN , String TitleAR)
    {
        writeOnText(titleEN , TitleEN+new Random().nextInt(9999));
        writeOnText(titleAR , TitleAR+new Random().nextInt(9999));
        Click(submitBtn);
    }


    public void editConsultantField(String TitleEN , String TitleAR,String TitleENEdit, String TitleAREdit) throws InterruptedException {
        addConsultantField(TitleEN , TitleAR);
        openEditScreen();
        Thread.sleep(5000);
        clear(titleEN);
        clear(titleAR);

        writeOnText(titleEN , TitleENEdit+new Random().nextInt(9999));
        writeOnText(titleAR , TitleAREdit+new Random().nextInt(9999));
        Click(submitBtn);
    }


}
