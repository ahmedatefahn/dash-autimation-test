package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.lang.reflect.Method;

public class JobTitle_Test extends TestBase {


    // Add active job title
    @Test(priority = 1)
    public void addActiveJobTitle() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openJobTaskList();
        jobTitlePage.clickAddBtn();
        jobTitlePage.addActiveJob(nameEN, nameAR);
   //     softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));

    }

    // Add active job title side panel
    @Test(priority = 2)
    public void addActiveJobTitleSidePanel() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openAddJobTaskSidePanel();
        jobTitlePage.addActiveJob(nameEN, nameAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));

    }

    // Edit active job title and status to inactive
    // Passed
    @Test(priority = 3)
    public void editActiveJobTitleAndStatusToInactive() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openJobTaskList();
        jobTitlePage.clickAddBtn();

        jobTitlePage.addActiveJob(nameEN, nameAR);
     //   softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));

    }

    // Delete job title
    @Test(priority = 4)
    public void deleteJobTitle() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openJobTaskList();
        jobTitlePage.clickAddBtn();

        jobTitlePage.addActiveJob(nameEN, nameAR);
     //   softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        jobTitlePage.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        Thread.sleep(3000);
        softAssert.assertFalse(commonMethods_page.table().equals(nameEN));
    }


    // Search job
    // Passed
    @Test(priority = 5)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openJobTaskList();
        jobTitlePage.clickAddBtn();

        jobTitlePage.addActiveJob(nameEN, nameAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
    }


    // Check validation messages on all fields
    // Passed
    @Test(priority = 6)
    public void checkJobsValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openJobTaskList();
        jobTitlePage.clickAddBtn();
        jobTitlePage.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationText("title_en").contains("The title EN field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("title_ar").contains("The title AR field is required"));
        softAssert.assertAll();
    }
}
