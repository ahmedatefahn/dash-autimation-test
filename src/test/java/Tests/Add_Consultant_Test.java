package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Add_Consultant_Test extends TestBase {


    // Add consultant
    // Passed

    @Test(priority = 1)
    public void checkAbilityToAddConsultant() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddConsultant();
        addConsultantPage.addConsultant(false, false, true, nameEN + "Lorem ipsum dolor sit amet, consectetuer adipiscin ",
                nameAR + "Lorem ipsum dolor sit amet, consectetuer adipiscin");
        //    Assert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

    }


    // Add teacher
    // Passed

    @Test(priority = 2)
    public void checkAbilityToAddTeacher() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddConsultant();
        addConsultantPage.addConsultant(true, false, false, nameEN + "Lorem ipsum dolor sit amet, consectetuer adipiscin ",
                nameAR + "Lorem ipsum dolor sit amet, consectetuer adipiscin");
        //    Assert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

    }

    // add coach
    // Passed

    @Test(priority = 3)
    public void checkAbilityToAddCoach() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddConsultant();
        addConsultantPage.addConsultant(false, true, false, nameEN + "Lorem ipsum dolor sit amet, consectetuer adipiscin ",
                nameAR + "Lorem ipsum dolor sit amet, consectetuer adipiscin");
        //    Assert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

    }

    // Search by username
    // Passed
    @Test(priority = 4)
    public void checkAbilityToSearchByUserName() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openConsultantsTab();
        addConsultantPage.search("Llccc");
        addConsultantPage.table().contains("Llccc");
    }

    // Delete consultants
    //
    @Test(priority = 5)
    public void checkAbilityToRemoveConsultant() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddConsultant();
        addConsultantPage.addConsultant(false, false, true,
                nameEN + "Lorem ipsum dolor sit amet, consectetuer adipiscin ",
                nameAR + "Lorem ipsum dolor sit amet, consectetuer adipiscin");
        //    Assert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        addConsultantPage.removeConsultants();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
    }

    // Edit consultant user | Type | Field | Speciality | Job title | Price |About
    // Issue
    @Test(priority = 6)
    public void checkAbilityToEditConsultant() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddConsultant();

        addConsultantPage.editConsultant(false, false, true,
                nameEN + "Lorem ipsum dolor sit amet, consectetuer adipiscin ",
                nameAR + "Lorem ipsum dolor sit amet, consectetuer adipiscin", true, false, false, nameEN, nameAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));

    }

    // Check consultant details
    //

    @Test(priority = 7)
    public void checkConsultantDetails() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddConsultant();
        addConsultantPage.addConsultant(false, false, true, nameEN + "Lorem ipsum dolor sit amet, consectetuer adipiscin ",
                nameAR + "Lorem ipsum dolor sit amet, consectetuer adipiscin");
        //    Assert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        addConsultantPage.openDetails();
        //  softAssert.assertTrue(commonMethods_page.assertValidationText(" Email ").contains(nameEN));
        //  softAssert.assertTrue(commonMethods_page.assertValidationText(" Phone ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Type ").contains("Consultant"));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Languages ").contains("English"));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" About EN ").contains("Lorem ipsum dolor sit amet, consectetuer adipiscin"));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" About AR ").contains("Lorem ipsum dolor sit amet, consectetuer adipiscin"));
        softAssert.assertAll();

    }

    // Check validation messages on all fields
    // Not done
    @Test(priority = 9)
    public void checkAddConsultantValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddConsultant();
        sidePanel_page.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationNameEN().contains("The name field is required"));
        Assert.assertTrue(commonMethods_page.getValidationNameAR().contains("The name_ar field is required"));
        Assert.assertTrue(commonMethods_page.getValidationShortDesEN().contains("The short description EN field is required"));
        Assert.assertTrue(commonMethods_page.getValidationShortDesAR().contains("The short description AR field is required"));
        Assert.assertTrue(commonMethods_page.getValidationLongDesEN().contains("The long description EN field is required"));
        Assert.assertTrue(commonMethods_page.getValidationLongDesAR().contains("The long description AR field is required"));
        Assert.assertTrue(commonMethods_page.getValidationDuration().contains("The duration field is required"));
        Assert.assertTrue(commonMethods_page.getValidationIntroEN().contains("The intro en field is required"));
        Assert.assertTrue(commonMethods_page.getValidationIntroAR().contains("The intro ar field is required"));
        Assert.assertTrue(commonMethods_page.getValidationImageEN().contains("The Image en field is required"));
        Assert.assertTrue(commonMethods_page.getValidationImageAR().contains("The Image ar field is required"));

        softAssert.assertAll();
    }

}
