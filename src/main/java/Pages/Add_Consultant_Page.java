package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;

public class Add_Consultant_Page extends PageBase{
    public Add_Consultant_Page(WebDriver driver) {
        super(driver);
    }



    By selectUser = By.id("userSelectOptions");
    By selectUserFromList = By.cssSelector("#userSelectOptions ul li:nth-child(1) span");
    By selectUserFromListSecond = By.cssSelector("#userSelectOptions ul li:nth-child(2) span");

    By type = By.id("typeSelectOptions");
    By selectConsultant = By.cssSelector("");
    By selectTeacher = By.cssSelector("#typeSelectOptions ul li .Teacher");
    By selectCoach = By.cssSelector("#typeSelectOptions ul li .Coach");
    By fields = By.id("fieldSelectOptions");
    By selectFieldConsultant = By.cssSelector("#fieldSelectOptions ul li .TESTING");
    By selectFieldTeacher = By.cssSelector("#fieldSelectOptions ul li .Basma.teacher");
    By selectFieldCoach = By.cssSelector("#fieldSelectOptions ul li .moh");

    By speciality = By.id("specialitySelectOptions");
    By selectSpecialityConsultant = By.cssSelector("#specialitySelectOptions ul li .TESTING.HIGH");
    By selectSpecialityTeacher = By.cssSelector("#specialitySelectOptions ul li .Basma.speciality.teacher");
    By selectSpecialityCoach = By.cssSelector("#specialitySelectOptions ul li .medan55");

    By jobTitle = By.id("jobTitleSelectOptions");
    By selectJobTitle = By.cssSelector("#jobTitleSelectOptions ul li:nth-child(1) span");
    By selectJobTitleSecond = By.cssSelector("#jobTitleSelectOptions ul li:nth-child(2) span");



    By ageStage = By.id("ageStageSelectOptions");
    By selectAllAgeStage = By.cssSelector("#ageStageSelectOptions ul li .All");
    By cvButton = By.cssSelector("[for='uploadfiles']");
    By period = By.id("periodSelectOptions");
    By select30Period = By.cssSelector("#periodSelectOptions ul li:nth-child(1) span");
    By priceTxt = By.id("price");
    By language = By.id("languageSelectOptions");
    By selectEnglishLanguage = By.cssSelector("#languageSelectOptions ul li .English");
    By aboutENTxt = By.id("about");
    By aboutARTxt = By.id("about_ar");
//    By selectUser = By.id("");
//    By selectUser = By.id("");
//    By selectUser = By.id("");
//    By selectUser = By.id("");
//    By selectUser = By.id("");

    By searchTxt = By.cssSelector("input.d-inline-block.mr-1.form-control");
    By removeBtn = By.xpath("//span[contains(text() , 'Remove')]");

    By confirmDelete = By.cssSelector(".modal-footer .btn-primary");

    By editBtn = By.xpath("//tbody/tr[1]/td[4]/a[2]/span[1]");


    By detailsBtn = By.xpath("//span[contains(text() , 'Details')]");



    public void addConsultant(boolean teacher , boolean coach ,boolean consultant, String titleAboutEN ,
                              String titleAboutAR) throws InterruptedException, AWTException {
        Thread.sleep(3000);
        Click(selectUser);
        Click(selectUserFromList);
      //  System.out.println(currentDriver.findElement(selectUserFromList).getText());
        if (teacher)
        {
            Click(type);
            Click(selectTeacher);
            Click(fields);
            Click(selectFieldTeacher);
            Click(speciality);
            Click(selectSpecialityTeacher);
        } else if (coach)
        {
            Click(type);
            Click(selectCoach);
            Click(fields);
            Click(selectFieldCoach);
            Click(speciality);
            Click(selectSpecialityCoach);
            Click(jobTitle);
            Click(selectJobTitle);
        } else if (consultant) {
            Click(fields);
            Click(selectFieldConsultant);
            Click(speciality);
            Click(selectSpecialityConsultant);
        }
        Click(jobTitle);
        Click(selectJobTitle);
        Click(ageStage);
        Click(selectAllAgeStage);
    //    Click(cvButton);
     //   Thread.sleep(2000);
     //   uploadFile("Sample.pdf");
      //  Click(period);
    //    Click(select30Period);
    //    writeOnText(priceTxt,".1");
        Click(language);
        Click(selectLanguage);
        writeOnText(aboutENTxt , titleAboutEN);
        writeOnText(aboutARTxt , titleAboutAR);
        Click(submitBtn);

    }

    public void editConsultant(boolean teacher , boolean coach ,boolean consultant, String titleAboutEN ,
                               String titleAboutAR,boolean teacherEdit ,boolean coachEdit ,boolean consultantEdit ,
                               String titleAboutENEdit, String titleAboutAREdit) throws InterruptedException, AWTException {
        addConsultant( teacher ,  coach , consultant,  titleAboutEN ,
             titleAboutAR);
        Click(editBtn);
        Click(selectUser);
        Click(selectUserFromListSecond);
        if (teacherEdit)
        {
            Click(type);
            Click(selectTeacher);
            Click(fields);
            Click(selectFieldTeacher);
            Click(speciality);
            Click(selectSpecialityTeacher);
        } else if (coachEdit)
        {
            Click(type);
            Click(selectCoach);
            Click(fields);
            Click(selectFieldCoach);
            Click(speciality);
            Click(selectSpecialityCoach);
            Click(jobTitle);
            Click(selectJobTitle);
        } else if (consultantEdit) {
            Click(fields);
            Click(selectFieldConsultant);
            Click(speciality);
            Click(selectSpecialityConsultant);
        }
        Click(jobTitle);
        Click(selectJobTitleSecond);
        Click(ageStage);
        Click(selectAllAgeStage);
        Click(cvButton);
        Thread.sleep(2000);
        uploadFile("Sample.pdf");
        Click(period);
        Click(select30Period);
        clear(priceTxt);
        writeOnText(priceTxt,".2");
        writeOnText(aboutENTxt , titleAboutENEdit);
        writeOnText(aboutARTxt , titleAboutAREdit);
        Click(submitBtn);

    }

    public void search(String requiredValue) throws AWTException, InterruptedException {
        waitElementToBeVisible(removeBtn);
        waitElementToBeVisible(searchTxt);
        writeOnText(searchTxt, requiredValue);
        currentDriver.findElement(searchTxt).sendKeys(Keys.ENTER);
    }

    public String table() {
        waitElementToBeVisible(removeBtn);
        WebElement table = currentDriver.findElement(By.cssSelector("[role = 'table']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println("size is " +rows.size());
        int size= rows.size();
        String  firstRow = rows.get(1).getText();
        System.out.println("first row name is " + firstRow);

        return firstRow;
    }

    public void removeConsultants() throws InterruptedException {
        waitElementToBeVisible(removeBtn);
        Click(removeBtn);
        Thread.sleep(2000);
        Click(confirmDelete);
    }

    public void openDetails()
    {
        Click(detailsBtn);
    }

}
