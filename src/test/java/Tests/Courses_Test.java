package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Courses_Test extends TestBase {


    // Create online , free , published  course with all valid data
    // Passed
    @Test(priority = 1)


    public void createCourseOnlineFreePublished() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openCoursesList();
        coursesPage.clickAddBtn();
        coursesPage.createCourse(false, true, true, nameEN, nameAR, slugName, price,
                requiredLongDesEN, requiredLongDesAR, requiredSEONameEN, requiredSEONameAR,
                requiredSEONDescEN, requiredSEONDescAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Free"));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));
        softAssert.assertTrue(commonMethods_page.table().contains("Online"));
    }

    // Create online , free , published  course with all valid data from side panel
    // Passed
    @Test(priority = 2)
    public void createCourseOnlineFreePublishedFromSidePanel() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddCourseSidePanel();
        coursesPage.createCourse(false, true, true, nameEN, nameAR, slugName, price,
                requiredLongDesEN, requiredLongDesAR, requiredSEONameEN, requiredSEONameAR,
                requiredSEONDescEN, requiredSEONDescAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Free"));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));
        softAssert.assertTrue(commonMethods_page.table().contains("Online"));
    }


    // Create live , free , published  course with all valid data
    // Passed

    @Test(priority = 3)
    public void createCourseLiveFreePublished() throws InterruptedException, AWTException {
        defineObjects();
        loginPage.loginWithValidData(Email, Password);
        sidePanel_page.openCoursesList();
        coursesPage.clickAddBtn();
        coursesPage.createCourse(true, true, true, nameEN, nameAR, slugName, price,
                requiredLongDesEN, requiredLongDesAR, requiredSEONameEN, requiredSEONameAR,
                requiredSEONDescEN, requiredSEONDescAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Free"));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));
        softAssert.assertTrue(commonMethods_page.table().contains("Live"));
    }


    // Verify ability to delete online course not have enrolled users
    @Test(priority = 4)
    public void verifyDeleteOnlineCourseNotHaveEnrolledUsers() throws InterruptedException, AWTException {
        defineObjects();
        createCourseOnlineFreePublished();
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        Thread.sleep(3000);
        softAssert.assertFalse(commonMethods_page.table().contains(nameEN));
    }

    // Verify ability to delete live course not have enrolled users
    @Test(priority = 5)
    public void verifyDeleteLiveCourseNotHaveEnrolledUsers() throws InterruptedException, AWTException {
        defineObjects();
        createCourseLiveFreePublished();
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        Thread.sleep(3000);
        softAssert.assertFalse(commonMethods_page.table().contains(nameEN));
    }

    // Edit online course to paid , draft
    // Passed
    @Test(priority = 6)
    public void editOnlineCourseToPaidAndDraft() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openCoursesList();
        coursesPage.clickAddBtn();

        coursesPage.editCourse(false, true, true, nameEN, nameAR, slugName, price,
                requiredLongDesEN, requiredLongDesAR, requiredSEONameEN, requiredSEONameAR,
                requiredSEONDescEN, requiredSEONDescAR,EditNameEN,EditNameAR,slugNameEdit,true,false
                ,PriceEdit);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
    }

    // Edit live course to paid , draft
    // Passed
    @Test(priority = 7)
    public void editLiveCoursePaidAndDraft() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openCoursesList();
        coursesPage.clickAddBtn();
        coursesPage.editCourse(true, true, true, nameEN, nameAR, slugName, price,
                requiredLongDesEN, requiredLongDesAR, requiredSEONameEN, requiredSEONameAR,
                requiredSEONDescEN, requiredSEONDescAR,EditNameEN,EditNameAR,slugNameEdit,true,false
                ,PriceEdit);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
    }

    // Search course
    // Passed
    @Test(priority = 8)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        createCourseOnlineFreePublished();
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));

    }

    // Check course details
    // Passed
    @Test(priority = 9)
    public void verifyDetailsOfCourse() throws InterruptedException, AWTException {
        createCourseOnlineFreePublished();
        commonMethods_page.openDetailsScreen();
        Thread.sleep(3000);

        softAssert.assertTrue(coursesPage.getCourseTitleEN().contains(nameEN));
        softAssert.assertTrue(coursesPage.getCourseTitleAR().contains(nameAR));
        softAssert.assertTrue(coursesPage.slugDetails().contains(slugName));
        softAssert.assertTrue(coursesPage.getCategoryEN().contains("Mobile Testing"));
        softAssert.assertTrue(coursesPage.getCategoryAR().contains("موبايل تستنج"));
        softAssert.assertTrue(coursesPage.getLevel().contains("All"));
        softAssert.assertTrue(coursesPage.getStatusDetails().contains("Published"));
        softAssert.assertTrue(coursesPage.getLanguageDetails().contains("English"));
        softAssert.assertTrue(coursesPage.getPrice().contains("Free"));
//      //  softAssert.assertTrue(coursesPage.getSurvey().contains("dcd"));
        softAssert.assertTrue(coursesPage.getType().contains("Online"));
        softAssert.assertTrue(coursesPage.getDescriptionEN().contains(requiredLongDesEN));
        softAssert.assertTrue(coursesPage.getDescriptionAR().contains(requiredLongDesAR));
        softAssert.assertAll();
    }

    // Check validation messages on all fields
    // Passed except select
    @Test(priority = 10)
    public void checkCoursesValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openCoursesList();
        coursesPage.clickAddBtn();
        coursesPage.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationText("title").contains("The title field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("title_ar").contains("The title_ar field is required"));
        Assert.assertTrue(commonMethods_page.getValidationImageENN().contains("The Image field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("slug").contains("The slug field is required"));
        Assert.assertTrue(commonMethods_page.getValidationThumbnail().contains("The Thumbnail field is required"));
     //   Assert.assertTrue(commonMethods_page.getValidationText("title").contains("The title field is required"));


        softAssert.assertAll();
    }
}
