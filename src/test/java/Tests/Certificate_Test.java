package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Certificate_Test extends TestBase{



    // Add certificate
    // Passed
    @Test(priority = 1)
    public void addCertificate() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openCertificatesList();
        certificatePage.clickAddBtn();
        certificatePage.addCertificate(nameEN,seoNameEN,seoNameAR,requiredSEONDescEN,requiredSEONDescAR);
    //    Assert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
    }

    // Add certificate side panel
    // Passed
    @Test(priority = 2)
    public void addCertificateSidePanel() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddCertificatesSidePanel();
        certificatePage.addCertificate(nameEN,seoNameEN,seoNameAR,requiredSEONDescEN,requiredSEONDescAR);
   //     Assert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
    }


    // Edit certificate
    // Passed
    @Test(priority = 3)
    public void editCertificate() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openCertificatesList();
        certificatePage.clickAddBtn();

        certificatePage.editCertificate(nameEN,seoNameEN,seoNameAR,requiredSEONDescEN,requiredSEONDescAR,EditNameEN);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
    }


    // Search certificate
    // Passed
    @Test(priority = 4)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        addCertificate();
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
    }

    // Check validation messages on all fields
    // Passed
    @Test(priority = 9)
    public void checkCertificateValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openCertificatesList();
        certificatePage.clickAddBtn();
        certificatePage.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationNameEN().contains("The name field is required"));

        Assert.assertTrue(commonMethods_page.getValidationImageENN().contains("The Image field is required"));

        softAssert.assertAll();
    }
}
