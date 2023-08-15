package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Fields_Consultations_Test extends TestBase {


    // Add consultations field
    // Passed
    @Test(priority = 1)
    public void createConsultationFiled() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openFieldsConsultationsList();
        fieldsConsultationsPage.clickAddBtn();
        fieldsConsultationsPage.addConsultantField(nameEN, nameAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Add consultations field side panel
    // Passed
    @Test(priority = 2)
    public void createConsultationFiledSidePanel() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openAddFieldsConsultationsSidePanel();
        fieldsConsultationsPage.addConsultantField(nameEN, nameAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Edit consultations names field
    // Passed
    @Test(priority = 3)
    public void editConsultationFiledNames() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openFieldsConsultationsList();
        fieldsConsultationsPage.clickAddBtn();

        fieldsConsultationsPage.editConsultantField(nameEN, nameAR,EditNameEN,EditNameAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
    }


    // Delete consultations field
    @Test(priority = 4)
    public void deleteConsultationFiled() throws InterruptedException {
        createConsultationFiled();
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        Thread.sleep(3000);
        softAssert.assertFalse(commonMethods_page.table().contains(nameEN));

    }

    // Search consultant field
    @Test(priority = 5)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        createConsultationFiled();
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
    }





    // Check fields on consultation details
    // Passed
    @Test(priority = 6)
    public void checkFieldsDetails() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openFieldsConsultationsList();
        fieldsConsultationsPage.clickAddBtn();
        fieldsConsultationsPage.addConsultantField(nameEN, nameAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Saved Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        commonMethods_page.openDetailsScreen();
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Title EN ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Title AR ").contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Type ").contains("consultant"));
        softAssert.assertAll();
    }

    // Check validation messages on all fields
    // Passed
    @Test(priority = 7)
    public void checkConsultationFieldsValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openFieldsConsultationsList();
        fieldsConsultationsPage.clickAddBtn();
        fieldsConsultationsPage.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationText("title").contains("The title EN field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("title_ar").contains("The title AR field is required"));
        softAssert.assertAll();
    }

}
