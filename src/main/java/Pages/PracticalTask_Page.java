package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticalTask_Page extends PageBase {
    public PracticalTask_Page(WebDriver driver) {
        super(driver);
    }

    By addPracticalTaskBTN = By.xpath("//span[contains(text() , 'Add Practical Task')]");
    By questionEN = By.id("question_en");
    By questionAR = By.id("question_ar");
    By courseENDetails = By.id("course");
    By courseARDetails = By.id("course_ar");
    By sectionENDetails = By.id("section");
    By sectionARDetails = By.id("section_ar");


    public void clickAddBtn() {
        Click(addPracticalTaskBTN);

    }

    public void clickSubmit()
    {
        Click(submitBtn);

    }
    public void addPracticalTask(boolean live, String QuestEN, String QuestAR) {
        writeOnText(questionEN, QuestEN);
        writeOnText(questionAR, QuestAR);
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
        Click(submitBtn);
    }

    public void editPracticalTask(boolean live, String QuestEN, String QuestAR, String QuestENEdit,
                                  String QuestAREdit) {
        addPracticalTask(live, QuestEN, QuestAR);
        openEditScreen();
        writeOnText(questionEN, QuestENEdit);
        writeOnText(questionAR, QuestAREdit);
        waitElementToBeUnVisible(loader);

        writeOnText(questionEN, QuestENEdit);
        writeOnText(questionAR, QuestAREdit);
        Click(submitBtn);
    }

    public String getQuestionEN()
    {
        // To get value of hidden text
        System.out.println(currentDriver.findElement(By.id("question")).getAttribute("value"));
        String valueEN = currentDriver.findElement(By.id("question")).getAttribute("value");
        return valueEN;

    }
    public String getQuestionAR()
    {
        System.out.println(currentDriver.findElement(By.id("question_ar")).getAttribute("value"));
        String valueEN = currentDriver.findElement(By.id("question_ar")).getAttribute("value");
        return valueEN;
    }
    public String getCourseEN()
    {
        System.out.println(currentDriver.findElement(By.id("course")).getAttribute("value"));
        String valueEN = currentDriver.findElement(By.id("course")).getAttribute("value");
        return valueEN;
    }  public String getCourseAR()
    {
        System.out.println(currentDriver.findElement(By.id("course_ar")).getAttribute("value"));
        String valueEN = currentDriver.findElement(By.id("course_ar")).getAttribute("value");
        return valueEN;
    }  public String getSectionEN()
    {
        System.out.println(currentDriver.findElement(By.id("section")).getAttribute("value"));
        String valueEN = currentDriver.findElement(By.id("section")).getAttribute("value");
        return valueEN;
    }  public String getSectionAR()
    {
        System.out.println(currentDriver.findElement(By.id("section_ar")).getAttribute("value"));
        String valueEN = currentDriver.findElement(By.id("section_ar")).getAttribute("value");
        return valueEN;
    }
}
