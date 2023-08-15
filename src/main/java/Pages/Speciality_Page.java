package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class Speciality_Page extends PageBase{
    public Speciality_Page(WebDriver driver) {
        super(driver);
    }

    By addSpeciality = By.xpath("//span[contains(text() , 'Add Speciality')]");

    By titleEN = By.id("title_en");


    By type = By.id("typeSelectOptions");
    By selectConsultantType = By.cssSelector("#typeSelectOptions ul li .Consultant");
    By selectTeacherType = By.cssSelector("#typeSelectOptions ul li .Teacher");
    By selectCoachType = By.cssSelector("#typeSelectOptions ul li .Coach");


    By fields = By.id("fieldsSelectOptions");
    By selectField = By.cssSelector("#fieldsSelectOptions ul li:nth-child(2) span");

    By status = By.id("statusSelectOptions");
    By selectInActive = By.cssSelector("#statusSelectOptions ul li .Inactive");
    By selectActive = By.cssSelector("#statusSelectOptions ul li .Active");


    public void addSpecialityBtn()
    {
        Click(addSpeciality);

    }
    public void clickSubmit()
    {
        Click(submitBtn);

    }
    public void addSpeciality(String titleENN, String titleARR ,boolean consultant, boolean teacher ,boolean coach, boolean inactive)
    {
        writeOnText(titleEN , titleENN + new Random().nextInt(9999));
        writeOnText(titleAR , titleARR + new Random().nextInt(9999) );
        Click(type);

        if (consultant){
            Click(selectConsultantType);
        } else if (teacher) {
            Click(selectTeacherType);
        }

        else if (coach) {
            Click(selectCoachType);
        }
        Click(fields);
        Click(selectField);

        if (inactive){
            Click(status);
            Click(selectInActive);
        }
        Click(submitBtn);
    }


    public void editSpeciality(String titleENN, String titleARR ,
                               boolean consultant, boolean teacher ,boolean coach, boolean inactive
    ,String titleENNEdit, String titleARREdit,boolean consultantEdit , boolean teacherEdit , boolean coachEdit
    , boolean inactiveEdit) throws InterruptedException {
        addSpeciality(titleENN ,titleARR , consultant , teacher , coach , inactive);
        openEditScreen();
        Thread.sleep(2000);
        clear(titleEN);
        clear(titleAR);
        writeOnText(titleEN , titleENNEdit + new Random().nextInt(9999));
        writeOnText(titleAR , titleARREdit + new Random().nextInt(9999) );
        Click(type);

        if (consultantEdit){
            Click(selectConsultantType);
        } else if (teacherEdit) {
            Click(selectTeacherType);
        }

        else if (coachEdit) {
            Click(selectCoachType);
        }
        Click(fields);
        Click(selectField);

        if (inactiveEdit){
            Click(status);
            Click(selectInActive);
        }
        Click(submitBtn);
    }

}
