package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Ads_Test extends TestBase {


    // Create Ads from Ads list on courses
    // Passed
    @Test(priority = 1)
    public void checkAbilityToAddAdsOnCourses() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdsList();
        adsPage.clickAddButton();
        adsPage.addAds(nameEN, nameAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertAll();
    }

    // Create Ads from Add Ads tab  on courses
    // Passed
    @Test(priority = 2)
    public void checkAbilityToAddAdsOnCoursesFromAddTab() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdsAdd();
        adsPage.addAds(nameEN, nameAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertAll();
    }

    // Search by name
    // Passed
    @Test(priority = 3)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdsList();
        adsPage.clickAddButton();
        adsPage.addAds(nameEN, nameAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertAll();
    }

    // Verify ability to delete ads
    // Passed
    @Test(priority = 4)
    public void verifyAbilityToDeleteAds() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdsList();
        adsPage.clickAddButton();
        adsPage.addAds(nameEN, nameAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        Thread.sleep(3000);
        softAssert.assertFalse(commonMethods_page.table().contains(nameEN));
        softAssert.assertAll();
    }

    // Verify ability to edit ads name
    // Passed
    @Test(priority = 5)
    public void editAdsName() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdsList();
        adsPage.clickAddButton();

        adsPage.editAds(nameEN,nameAR,EditNameEN,EditNameAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
        softAssert.assertAll();
    }

    // Verify ability to view ads details
    // Passed

    @Test(priority = 6)
    public void checkAdsDetails() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdsList();
        adsPage.clickAddButton();
        adsPage.addAds(nameEN, nameAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        commonMethods_page.openDetailsScreen();
        System.out.println(nameEN);
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Name EN ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Name AR ").contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Status ").contains("Active"));
        softAssert.assertAll();
    }

    // Check validation messages on all fields
    // Passed except selects
    @Test(priority = 7)
    public void checkAdsValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdsList();
        adsPage.clickAddButton();
        adsPage.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationNameEN().contains("The name en field is required"));
        Assert.assertTrue(commonMethods_page.getValidationNameAR().contains("The name ar field is required"));
        Assert.assertTrue(commonMethods_page.getValidationImageENN().contains("The image en field is required"));
        Assert.assertTrue(commonMethods_page.getValidationImageARR().contains("The image ar field is required"));
        softAssert.assertAll();
    }
}
