package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Sections_Test extends TestBase {


    // Create  active section on online course with all valid data
    // Passed
    @Test(priority = 1)
    public void createActiveSectionsOnOnlineCourseWithAllValidData() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSectionsList();
        sectionsPage.clickAddBtn();
        sectionsPage.addSection(false, true, nameEN, nameAR, seoNameEN, seoNameAR, requiredLongDesEN, requiredLongDesAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }


    // Create  inactive section on online course with all valid data
    // Passed
    @Test(priority = 2)
    public void createInactiveSectionsOnOnlineCourseWithAllValidData() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSectionsList();
        sectionsPage.clickAddBtn();
        sectionsPage.addSection(false, false, nameEN, nameAR, seoNameEN, seoNameAR, requiredLongDesEN, requiredLongDesAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Create  active section on live course with all valid data
    // Passed
    @Test(priority = 3)
    public void createActiveSectionsOnLiveCourseWithAllValidData() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSectionsList();
        sectionsPage.clickAddBtn();
        sectionsPage.addSection(true, true, nameEN, nameAR, seoNameEN, seoNameAR, requiredLongDesEN, requiredLongDesAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Create inactive section on live course with all valid data
    // Passed
    @Test(priority = 4)
    public void createInactiveSectionsOnLiveCourseWithAllValidData() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSectionsList();
        sectionsPage.clickAddBtn();
        sectionsPage.addSection(true, false, nameEN, nameAR, seoNameEN, seoNameAR, requiredLongDesEN, requiredLongDesAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }


    // Edit section name and to inactive status
    // Passed
    @Test(priority = 5)
    public void editSectionsNameAndToInactiveStatus() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSectionsList();
        sectionsPage.clickAddBtn();
        sectionsPage.editSection(false, true, nameEN, nameAR, seoNameEN, seoNameAR, requiredLongDesEN, requiredLongDesAR,
                EditNameEN, EditNameAR, false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
    }

    // Edit section name and to active status
    // Passed
    @Test(priority = 6)
    public void editSectionsNameAndToActiveStatus() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSectionsList();
        sectionsPage.clickAddBtn();
        sectionsPage.editSection(false, false, nameEN, nameAR, seoNameEN, seoNameAR, requiredLongDesEN, requiredLongDesAR,
                EditNameEN, EditNameAR, true);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
    }

    // Verify Ability To Delete online Section
    @Test(priority = 7)
    public void verifyAbilityToDeleteOnlineSection() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSectionsList();
        sectionsPage.clickAddBtn();
        sectionsPage.addSection(false, true, nameEN, nameAR, seoNameEN, seoNameAR, requiredLongDesEN, requiredLongDesAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        Thread.sleep(3000);
        softAssert.assertFalse(commonMethods_page.table().contains(nameEN));

    }

    // Verify Ability To Delete live Section
    @Test(priority = 8)
    public void verifyAbilityToDeleteLiveSection() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSectionsList();
        sectionsPage.clickAddBtn();
        sectionsPage.addSection(false, true, nameEN, nameAR, seoNameEN, seoNameAR, requiredLongDesEN, requiredLongDesAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        Thread.sleep(3000);
        softAssert.assertFalse(commonMethods_page.table().contains(nameEN));

    }

    // Search section
    // Passed
    @Test(priority = 9)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSectionsList();
        sectionsPage.clickAddBtn();
        sectionsPage.addSection(false, true, nameEN, nameAR, seoNameEN, seoNameAR, requiredLongDesEN, requiredLongDesAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
    }

    // Create  active section on online course with all valid data from side panel
    // Passed
    @Test(priority = 10)
    public void createActiveSectionsOnOnlineCourseWithAllValidDataFromSidePanel() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddSectionsSidePanel();
        sectionsPage.addSection(false, true, nameEN, nameAR, seoNameEN, seoNameAR, requiredLongDesEN, requiredLongDesAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Check details of sections
    // Passed
    @Test(priority = 11)
    public void checkDetailsOfSections() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSectionsList();
        sectionsPage.clickAddBtn();
        sectionsPage.addSection(false, true, nameEN, nameAR, seoNameEN, seoNameAR, requiredLongDesEN, requiredLongDesAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        commonMethods_page.openDetailsScreen();
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Title EN ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Title AR ").contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Status ").contains("Active"));
        softAssert.assertAll();

    }

    // Check validation messages on all fields
    // Passed except select
    @Test(priority = 12)
    public void checkSectionValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSectionsList();
        sectionsPage.clickAddBtn();
        sectionsPage.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationText("title").contains("The title field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("title_ar").contains("The title_ar field is required"));

        softAssert.assertAll();
    }
}
