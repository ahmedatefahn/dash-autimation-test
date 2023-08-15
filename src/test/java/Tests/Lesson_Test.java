package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Lesson_Test extends TestBase {


    // Create Lesson on online course with PDF and all valid data
    // Passed
    @Test(priority = 1)
    public void createLessonOnOnlineCourseWithPDF() throws InterruptedException, AWTException {
        defineObjects();
        loginPage.loginWithValidData(Email, Password);
        sidePanel_page.openLessonList();
        lessonPage.clickAddBtn();

        lessonPage.addLesson(false ,nameEN,nameAR,seoNameEN,seoNameEN,requiredLongDesEN,requiredLongDesAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Create Lesson on online course with PDF and all valid data side panel
    // Passed
    @Test(priority = 2)
    public void createLessonOnOnlineCourseWithPDFSidePanel() throws InterruptedException, AWTException {
        defineObjects();
        loginPage.loginWithValidData(Email, Password);
        sidePanel_page.openAddLessonSidePanel();

        lessonPage.addLesson(false ,nameEN,nameAR,seoNameEN,seoNameEN,requiredLongDesEN,requiredLongDesAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Create Lesson on live course with all valid data
    // Passed
    @Test(priority = 3)
    public void createLessonOnOnLiveCourseWithPDF() throws InterruptedException, AWTException {
        defineObjects();
        loginPage.loginWithValidData(Email, Password);
        sidePanel_page.openLessonList();
        lessonPage.clickAddBtn();

        lessonPage.addLesson(true ,nameEN,nameAR,seoNameEN,seoNameEN,requiredLongDesEN,requiredLongDesAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));

    }

    // Edit Lesson for online course to live  course with PDF  to live course and section
    // Passed
    @Test(priority = 4)
    public void editLessonOnOnlineCourseWithPDFTOBeLiveCourse() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openLessonList();
        lessonPage.clickAddBtn();

        lessonPage.editLesson(false ,nameEN,nameAR,seoNameEN,seoNameEN,requiredLongDesEN,requiredLongDesAR,EditNameEN,EditNameAR,true);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("AutoLiveCourse"));


    }

    // Edit Lesson for live course on online course with PDF  to live course and section
    // Passed
    @Test(priority = 5)
    public void editLessonOnLiveCourseWithPDFTOBeOnlineCourse() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openLessonList();
        lessonPage.clickAddBtn();

        lessonPage.editLesson(true ,nameEN,nameAR,seoNameEN,seoNameEN,requiredLongDesEN,requiredLongDesAR,EditNameEN,EditNameAR,false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("AutoOnlineCourse"));


    }



    // Verify ability to delete online lesson
    @Test(priority = 6)
    public void verifyAbilityToDeleteOnlineLesson() throws InterruptedException, AWTException {
        defineObjects();
        loginPage.loginWithValidData(Email, Password);
        sidePanel_page.openLessonList();
        lessonPage.clickAddBtn();

        lessonPage.addLesson(false ,nameEN,nameAR,seoNameEN,seoNameEN,requiredLongDesEN,requiredLongDesAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        Thread.sleep(3000);
        softAssert.assertFalse(commonMethods_page.table().contains(nameEN));

    }

    // Verify ability to delete live lesson
    @Test(priority = 7)
    public void verifyAbilityToDeleteLiveLesson() throws InterruptedException, AWTException {
        defineObjects();
        loginPage.loginWithValidData(Email, Password);
        sidePanel_page.openLessonList();
        lessonPage.clickAddBtn();

        lessonPage.addLesson(false ,nameEN,nameAR,seoNameEN,seoNameEN,requiredLongDesEN,requiredLongDesAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        Thread.sleep(3000);
        softAssert.assertFalse(commonMethods_page.table().contains(nameEN));

    }

    // Search lesson
    // Passed
    @Test(priority = 8)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        defineObjects();
        loginPage.loginWithValidData(Email, Password);
        sidePanel_page.openLessonList();
        lessonPage.clickAddBtn();

        lessonPage.addLesson(false ,nameEN,nameAR,seoNameEN,seoNameEN,requiredLongDesEN,requiredLongDesAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
    }

    // Check lesson details
    // Pass // Performance issue
    @Test(priority = 9)
    public void checkLessonDetails() throws InterruptedException, AWTException {
        defineObjects();
        loginPage.loginWithValidData(Email, Password);
        sidePanel_page.openLessonList();
        lessonPage.clickAddBtn();

        lessonPage.addLesson(false ,nameEN,nameAR,seoNameEN,seoNameEN,requiredLongDesEN,requiredLongDesAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        commonMethods_page.openDetailsScreen();
        Thread.sleep(4000);
        softAssert.assertTrue(lessonPage.getCourseNameEn().contains(nameEN));
        softAssert.assertTrue(lessonPage.getCourseNameAr().contains(nameAR));
        softAssert.assertTrue(lessonPage.getCourseEn().contains("AutoOnlineCourse"));
        softAssert.assertTrue(lessonPage.getCourseAr().contains("AutoOnlineCourse"));
        softAssert.assertTrue(lessonPage.getSectionNameEn().contains("SectionOnline"));
        softAssert.assertTrue(lessonPage.getSectionNameAr().contains("SectionOnline"));
        softAssert.assertTrue(lessonPage.getContentType().contains("pdf"));
        softAssert.assertAll();
    }
    // Check validation messages on all fields
    // Passed except select
    @Test(priority = 10)
    public void checkLessonValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openLessonList();
        lessonPage.clickAddBtn();
        lessonPage.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationText("title").contains("The title en field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("title_ar").contains("The title ar field is required"));
        Assert.assertTrue(commonMethods_page.getValidationFile().contains("The File field is required"));
        softAssert.assertAll();
    }


}
