package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class BankQuestion_Test extends TestBase {


    // Add published bank question from admin
    // Passed
    @Test(priority = 1)
    public void addPublishedBankQuestionFromAdmin() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdminList();
        bankQuestionPage.clickAddBrn();
        bankQuestionPage.addQuestionFromAdmin(nameEN, nameAR, nameEN, nameAR, true, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR);
        //  Assert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Add published bank question from admin side panel
    // Passed
    @Test(priority = 2)
    public void addPublishedBankQuestionFromAdminSidePanel() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddAdminSidePanel();
        bankQuestionPage.addQuestionFromAdmin(nameEN, nameAR, nameEN, nameAR, true, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR);
        //  Assert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }


    // Edit bank question [Name and status to Draft] from Admin
    // Passed
    @Test(priority = 3)
    public void editBankQuestionNamesAndStatusToDraftedFromAdmin() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdminList();
        bankQuestionPage.clickAddBrn();

        bankQuestionPage.editQuestionFromAdmin(nameEN, nameAR, nameEN, nameAR, true, seoNameEN, seoNameAR,
                requiredSEONDescEN, requiredSEONDescAR, EditNameEN, EditNameAR, EditNameEN, EditNameAR, true);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
    }

    // Search bank question
    // Passed
    @Test(priority = 4)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        addPublishedBankQuestionFromAdmin();
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));

    }

    // Check bank question detailsCheck bank question details
    // Passed
    @Test(priority = 5)
    public void checkBankQuestionDetails() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdminList();
        bankQuestionPage.clickAddBrn();
        bankQuestionPage.addQuestionFromAdmin(nameEN, nameAR, nameEN, nameAR, true, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR);
        //  Assert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        commonMethods_page.openDetailsScreen();
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Question EN ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Question AR ").contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Answer EN ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Answer AR ").contains(nameAR));
        //    softAssert.assertTrue(commonMethods_page.assertValidationText(" Title EN ").contains(nameEN));
        //    softAssert.assertTrue(commonMethods_page.assertValidationText(" Title EN ").contains(nameEN));
        softAssert.assertAll();
    }
    // Check validation messages on all fields
    // Passed
    @Test(priority = 6)
    public void checkBankQuestionValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdminList();
        bankQuestionPage.clickAddBrn();
        bankQuestionPage.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationQuestionEN().contains("The question EN field is required"));
        Assert.assertTrue(commonMethods_page.getValidationQuestionAR().contains("The question AR field is required"));
        Assert.assertTrue(commonMethods_page.getValidationAnswerEN().contains("The answer EN field is required"));
        Assert.assertTrue(commonMethods_page.getValidationAnswerAR().contains("The answer AR field is required"));
        softAssert.assertAll();
    }
}
