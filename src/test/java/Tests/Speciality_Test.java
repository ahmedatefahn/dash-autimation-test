package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Speciality_Test extends TestBase {




    // Add speciality On Consultant
    // Passed
    @Test(priority = 1)
    public void verifyAbilityToAddSpecialityOnConsultant() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openSpecialityList();
        specialityPage.addSpecialityBtn();
        specialityPage.addSpeciality(nameEN,nameAR,true,false,false,false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));
        softAssert.assertAll();

    }

    // Add speciality On Teacher
    // Passed
    @Test(priority = 2)
    public void verifyAbilityToAddSpecialityOnTeacher() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openSpecialityList();
        specialityPage.addSpecialityBtn();
        specialityPage.addSpeciality(nameEN,nameAR,false,true,false,false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));
        softAssert.assertAll();

    }

    // Add speciality On Coach
    // Passed
    @Test(priority = 3)
    public void verifyAbilityToAddSpecialityOnCoach() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openSpecialityList();
        specialityPage.addSpecialityBtn();
        specialityPage.addSpeciality(nameEN,nameAR,false,false,true,false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));
        softAssert.assertAll();

    }

    // Search By name
    // Passed
    @Test(priority = 4)
    public void verifyAbilityToSearchByName() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSpecialityList();
        specialityPage.addSpecialityBtn();
        specialityPage.addSpeciality(nameEN,nameAR,true,false,false,false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertAll();


    }

    // Delete speciality
    // Passed
    @Test(priority = 5)
    public void verifyAbilityToDeleteSpeciality() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSpecialityList();
        specialityPage.addSpecialityBtn();
        specialityPage.addSpeciality(nameEN,nameAR,true,false,false,false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        softAssert.assertAll();

    }

    // Edit speciality Name and status
    // Passed
    @Test(priority = 6)
    public void verifyAbilityToEditSpecialityNameAndStatus() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSpecialityList();
        specialityPage.addSpecialityBtn();
        specialityPage.editSpeciality(nameEN,nameAR,true,false,false,false,nameEN,nameAR,true,false,false,true);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Inactive"));
        softAssert.assertAll();
    }

    // Add speciality On Consultant Side Panel
    // Passed
    @Test(priority = 7)
    public void verifyAbilityToAddSpecialityOnConsultantSidePanel() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openAddSpecialitySidePanel();
        specialityPage.addSpeciality(nameEN,nameAR,true,false,false,false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));
        softAssert.assertAll();
    }

    // check speciality details
    // Passed
    @Test(priority = 8)
    public void checkSpecialityDetails() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openSpecialityList();
        specialityPage.addSpecialityBtn();
        specialityPage.addSpeciality(nameEN,nameAR,true,false,false,false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));
        commonMethods_page.openDetailsScreen();
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Title EN ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Title AR ").contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Type ").contains("consultant"));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Status ").contains("Active"));
        softAssert.assertAll();

    }
    // Check validation messages on all fields
    // Passed except select
    @Test(priority = 9)
    public void checkSpecialityValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSpecialityList();
        specialityPage.addSpecialityBtn();
        specialityPage.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationText("title_en").contains("The title EN field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("title_ar").contains("The title AR field is required"));

        softAssert.assertAll();
    }

}
