package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.util.Random;

public class Tasks_Page extends PageBase {
    public Tasks_Page(WebDriver driver) {
        super(driver);
    }

    By tasks = By.id("tasks");
    By tasksList = By.id("apps-task-list");
    By myUsersList = By.id("apps-task-enrolled-users-list");
    By addTab = By.id("apps-task-add");
    By addTaskButton = By.xpath("//span[contains(text() , 'Add Task')]");
    By nameEN = By.id("name");
    By nameAR = By.id("name_ar");
    By duration = By.id("duration");
    By shortDescriptionEN = By.id("short_description");
    By shortDescriptionAR = By.id("short_description_ar");
    By longDescriptionEN = By.id("long_description");
    By longDescriptionAR = By.id("long_description_ar");
    By quiz = By.id("quizSelectOptions");
    By selectQuiz = By.cssSelector("#quizSelectOptions ul li .The.only.way");
    By addProof = By.cssSelector("[for='add_your_proof']");
    By addAttachment = By.xpath("//span[contains(text() , 'Add PDF Attachment')]");
    By attachmentEN = By.cssSelector("#attachment-1-en + label");
    By attachmentAR = By.cssSelector("#attachment-1-ar + label");
    // By tasks = By.id("tasks");

    By userList = By.id("typeSelectOptions");
    By selectUser = By.cssSelector("#typeSelectOptions ul li .Childdddd");
    By childList = By.id("childSelectOptions");
    By selectChild = By.cssSelector("#childSelectOptions ul li:nth-child(1) span");


    public void addTask(String taskNameEN, String taskNameAR, String shoreDesEN,
                        String shoreDesAR, String longDesEN, String longDesAR) throws InterruptedException, AWTException {
        writeOnText(nameEN, taskNameEN + new Random().nextInt(9999));
        writeOnText(nameAR, taskNameAR + new Random().nextInt(9999));
        writeOnText(duration, "365");
        writeOnText(shortDescriptionEN, shoreDesEN);
        writeOnText(shortDescriptionAR, shoreDesAR);
        writeOnText(longDescriptionEN, longDesEN);
        writeOnText(longDescriptionAR, longDesAR);
      //  scrollToElement(quiz);
        Thread.sleep(3000);
        Click(quiz);
        Click(selectQuiz);
        Click(addProof);
        Click(addAttachment);

        Click(attachmentEN);

        Thread.sleep(2000);
        Click(attachmentEN);
        uploadFile("Sample.pdf");
        Click(attachmentAR);
        uploadFile("Sample.pdf");
        uploadFile("Sample.pdf");

        Click(submitBtn);
    }

    public void clickAddTaskButton() {
        Click(addTaskButton);
    }

    public void editTask(String taskNameEN, String taskNameAR, String shoreDesEN,
                         String shoreDesAR, String longDesEN, String longDesAR,String taskNameENEdit
    , String taskNameAREdit) throws InterruptedException, AWTException {
        addTask(taskNameEN, taskNameAR, shoreDesEN,
                shoreDesAR, longDesEN, longDesAR);
        openEditScreen();
        Thread.sleep(2000);
        clear(nameEN);
        writeOnText(nameEN, taskNameENEdit + new Random().nextInt(9999));
        clear(nameAR);
        writeOnText(nameAR, taskNameAREdit + new Random().nextInt(9999));
        clear(duration);
        writeOnText(duration, "1000");
        writeOnText(shortDescriptionEN, shoreDesEN);
        writeOnText(shortDescriptionAR, shoreDesAR);
        writeOnText(longDescriptionEN, longDesEN);
        writeOnText(longDescriptionAR, longDesAR);
//        scrollToElement(quiz);
//        Click(quiz);
//        Click(selectQuiz);
        Click(addProof);
        Click(addAttachment);
        Thread.sleep(2000);
        Click(attachmentEN);
        uploadFile("Sample.pdf");
        Click(attachmentAR);
        uploadFile("Sample.pdf");
        Click(submitBtn);
    }

    public void assignTaskToUser() throws InterruptedException {
        Thread.sleep(3000);
        Click(userList);
        Click(selectUser);
        Click(childList);
        Click(selectChild);

    }
}
