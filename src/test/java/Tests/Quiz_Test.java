package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Quiz_Test extends TestBase {


    // Create quiz multi selection on online course
    // Passed
    @Test(priority = 1)
    public void createQuizMultiSelectionOnOnlineCourse() throws InterruptedException, AWTException {
        defineObjects();
        loginPage.loginWithValidData(Email, Password);
        sidePanel_page.openQuizList();
        quizPage.clickAddBtn();
        quizPage.addNewQuiz(false, nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR
                , nameEN, nameEN, nameEN, nameAR, nameEN, nameEN);
        //   softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Create quiz multi selection on online course side panel
    // Passed
    @Test(priority = 2)
    public void createQuizMultiSelectionOnOnlineCourseSidePanel() throws InterruptedException, AWTException {
        defineObjects();
        loginPage.loginWithValidData(Email, Password);
        sidePanel_page.openAddQuizSidePanel();
        quizPage.addNewQuiz(false, nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR
                , nameEN, nameEN, nameEN, nameAR, nameEN, nameEN);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Create quiz multi selection on live course
    // Passed
    @Test(priority = 3)
    public void createQuizMultiSelectionOnOnLiveCourse() throws InterruptedException, AWTException {
        defineObjects();
        loginPage.loginWithValidData(Email, Password);
        sidePanel_page.openQuizList();
        quizPage.clickAddBtn();

        quizPage.addNewQuiz(true, nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR
                , nameEN, nameEN, nameEN, nameAR, nameEN, nameEN);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Edit quiz multi selection to live course
    // Fail
    @Test(priority = 4)
    public void editQuizMultiSelectionTOLiveCourse() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openQuizList();
        quizPage.clickAddBtn();

        quizPage.editNewQuiz(false, nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR
                , nameEN, nameEN, nameEN, nameAR, nameEN, nameEN, EditNameEN, EditNameEN, true, EditNameEN, EditNameAR, EditNameEN, EditNameAR, EditNameEN, EditNameAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
    }

    // Edit quiz multi selection to online course
    // Fail
    @Test(priority = 5)
    public void editQuizMultiSelectionTOOnlineCourse() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openQuizList();
        quizPage.clickAddBtn();

        quizPage.editNewQuiz(true, nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR
                , nameEN, nameEN, nameEN, nameAR, nameEN, nameEN, EditNameEN, EditNameEN, false, EditNameEN, EditNameAR, EditNameEN, EditNameAR, EditNameEN, EditNameAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
    }

    // Delete quiz on online course
    @Test(priority = 6)
    public void deleteQuizOnOnlineCourse() throws InterruptedException, AWTException {
        createQuizMultiSelectionOnOnlineCourse();
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        Thread.sleep(3000);
        softAssert.assertFalse(commonMethods_page.table().contains(nameEN));
    }

    // Delete quiz on live course
    @Test(priority = 7)
    public void deleteQuizOnLiveCourse() throws InterruptedException, AWTException {
        createQuizMultiSelectionOnOnLiveCourse();
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        Thread.sleep(3000);
        softAssert.assertFalse(commonMethods_page.table().contains(nameEN));
    }


    // Search quiz
    // Passed
    @Test(priority = 8)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        createQuizMultiSelectionOnOnlineCourse();
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
    }

    // check quiz details
    // Passed
    @Test(priority = 9)
    public void checkQuizDetails() throws InterruptedException, AWTException {
        defineObjects();
        loginPage.loginWithValidData(Email, Password);
        sidePanel_page.openQuizList();
        quizPage.clickAddBtn();
        quizPage.addNewQuiz(false, nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR
                , nameEN, nameEN, nameEN, nameAR, nameEN, nameEN);
        //   softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        commonMethods_page.openDetailsScreen();
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Title EN ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Title AR ").contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Passing Precentage ").contains("80"));
        softAssert.assertAll();
    }

    // Check validation messages on all fields
    // Passed except select
    @Test(priority = 9)
    public void checkQuizValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openQuizList();
        quizPage.clickAddBtn();
        quizPage.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationText("title").contains("The title field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("title_ar").contains("The title AR field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("passing_precentage").contains("The Passing Persentage field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("item-name").contains("The Question 1 EN field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("item-name-ar").contains("The Question 1 AR field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("answer00").contains("The Answer 1 EN field is require"));
      //  Assert.assertTrue(commonMethods_page.getValidationText("answer00 AR").contains("The Answer 1 AR field is required"));

        softAssert.assertAll();
    }
}
