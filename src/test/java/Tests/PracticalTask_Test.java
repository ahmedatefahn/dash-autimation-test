package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class PracticalTask_Test extends TestBase {


    // Add practical task on online course
    @Test(priority = 1)
    public void createPracticalTaskOnOnlineCourse() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openPracticalTaskList();
        practicalTaskPage.clickAddBtn();
        practicalTaskPage.addPracticalTask(false, nameEN, nameAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Add practical task on online course side panel
    @Test(priority = 2)
    public void createPracticalTaskOnOnlineCourseSidePanel() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openAddPracticalTaskListSidePanel();
        practicalTaskPage.addPracticalTask(false, nameEN, nameAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Add practical task on live course
    @Test(priority = 3)
    public void createPracticalTaskOnLiveCourse() throws InterruptedException {
        defineObjects();
        loginPage.loginWithValidData(Email, Password);
        sidePanel_page.openPracticalTaskList();
        practicalTaskPage.clickAddBtn();

        practicalTaskPage.addPracticalTask(true, nameEN, nameAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Edit  practical task name
    // Passed
    @Test(priority = 4)
    public void editPracticalTaskToLiveCourse() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openPracticalTaskList();
        practicalTaskPage.clickAddBtn();

        practicalTaskPage.editPracticalTask(false, nameEN, nameAR,EditNameEN,EditNameAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
    }

    // Delete practical task on online course
    @Test(priority = 5)
    public void deletePracticalTaskOnOnlineCourse() throws InterruptedException, AWTException {
        createPracticalTaskOnOnlineCourse();
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        softAssert.assertFalse(commonMethods_page.table().contains(nameEN));
    }

    // Delete practical task on live course
    @Test(priority = 6)
    public void deletePracticalTaskOnLiveCourse() throws InterruptedException, AWTException {
        createPracticalTaskOnLiveCourse();
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        softAssert.assertFalse(commonMethods_page.table().contains(nameEN));
    }

    // Search practical task
    //
    @Test(priority = 7)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        createPracticalTaskOnOnlineCourse();
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
    }

    // Check details of practical task
    // Pass // Performance issue while creating
    @Test(priority = 8)
    public void checkDetailsOfPracticalTask() throws InterruptedException {
        createPracticalTaskOnOnlineCourse();
        commonMethods_page.openDetailsScreen();
        Thread.sleep(4000);
        softAssert.assertTrue(practicalTaskPage.getQuestionEN().contains(nameEN));
        softAssert.assertTrue(practicalTaskPage.getQuestionAR().contains(nameAR));
        softAssert.assertTrue(practicalTaskPage.getCourseEN().contains("AutoOnlineCourse"));
        softAssert.assertTrue(practicalTaskPage.getCourseAR().contains("AutoOnlineCourse"));
        softAssert.assertTrue(practicalTaskPage.getSectionEN().contains("SectionOnline"));
        softAssert.assertTrue(practicalTaskPage.getSectionAR().contains("SectionOnline"));
        softAssert.assertAll();
    }

    // Check validation messages on all fields
    // Passed except select
    @Test(priority = 9)
    public void checkPracticalTasksValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openPracticalTaskList();
        practicalTaskPage.clickAddBtn();
        practicalTaskPage.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationText("question_en").contains("The question en field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("question_ar").contains("The question ar field is required"));
        softAssert.assertAll();
    }
}
