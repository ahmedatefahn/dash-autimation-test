package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class TrackingSystem_Test extends TestBase {

    String requiredShortDesEN = "Tracking ShortDesEN Automation";
    String requiredShortDesAR = "Tracking ShortDesAR Automation";
    String requiredLongDesEN = "Tracking LongDesEN Automation";
    String requiredLongDesAR = "Tracking LongDesAR Automation";
    String requiredDuration = "5";
    String requiredSEONameEN = "Tracking SEOEN Automation";
    String requiredSEONameAR = "Tracking SEOAR Automation";
    String requiredSEONDescEN = "Tracking SEODescEN Automation";
    String requiredSEONDescAR = "Tracking SEODescAR Automation";
    String videoPath = "D:\\Photos\\Robin - 21723.mp4";
    String requiredDurationEdit = "38" ;

    // Create Tracking system Image / Free / Published
    // Passed

    @Test(priority = 1)
    public void createFreeTrackingSystemWithValidData_Image() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openTrackingList();
        trackingSystem_page.clickAddBtn();
        trackingSystem_page.createTrackingSystemWithValidData(true, true, nameEN, nameAR,
                requiredShortDesEN, requiredShortDesAR,
                requiredLongDesEN, requiredLongDesAR,
                requiredDuration, requiredSEONameEN, requiredSEONameAR, requiredSEONDescEN, requiredSEONDescAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Free"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Published"));
    }

    // Create Tracking system Image / Free / Published side panel
    // Passed

    @Test(priority = 2)
    public void createFreeTrackingSystemWithValidData_ImageSidePanel() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddTrackingSidePanel();
        trackingSystem_page.createTrackingSystemWithValidData(true, true, nameEN, nameAR,
                requiredShortDesEN, requiredShortDesAR,
                requiredLongDesEN, requiredLongDesAR,
                requiredDuration, requiredSEONameEN, requiredSEONameAR, requiredSEONDescEN, requiredSEONDescAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Free"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Published"));
    }

    // Create Tracking system Video / Free / Published
    @Test(priority = 3)
    public void createFreeTrackingSystemWithValidData_Video() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openTrackingList();
        trackingSystem_page.clickAddBtn();

        trackingSystem_page.createTrackingSystemWithValidData(false, true, nameEN, nameAR,
                requiredShortDesEN, requiredShortDesAR,
                requiredLongDesEN, requiredLongDesAR,
                requiredDuration, requiredSEONameEN, requiredSEONameAR, requiredSEONDescEN, requiredSEONDescAR);
   //     softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Free"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Published"));

    }


    // Create Tracking system Image / Free / Drafted
    // Passed
    @Test(priority = 4)
    public void createDraftedFreeTrackingSystemWithValidData_Image() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openTrackingList();
        trackingSystem_page.clickAddBtn();

        trackingSystem_page.createTrackingSystemWithValidData(true, false, nameEN, nameAR,
                requiredShortDesEN, requiredShortDesAR,
                requiredLongDesEN, requiredLongDesAR,
                requiredDuration, requiredSEONameEN, requiredSEONameAR, requiredSEONDescEN, requiredSEONDescAR);
   //     softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Free"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Drafted"));
    }


    // Search by name
    // Passed
    @Test(priority = 5)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        createFreeTrackingSystemWithValidData_Image();
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
    }

    // Edit Tracking Name | To video | Drafted | Paid | Tracking duration
    // Passed
    @Test(priority = 6)
    public void editTrackingNameVideoDraftedPaid() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openTrackingList();
        trackingSystem_page.clickAddBtn();

        trackingSystem_page.editTracking(true,true,nameEN,nameAR,nameEN,nameAR,requiredLongDesEN
        ,requiredLongDesAR,requiredDuration,nameEN,nameAR,requiredSEONDescEN,requiredSEONDescAR
        ,EditNameEN , EditNameAR , true , true ,true,requiredDurationEdit);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));



        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Drafted"));



    }
/*
    @Test(priority = 3)
    public void verifyDataOfTrackingDetails() throws InterruptedException, AWTException {
        defineObjects();
        createTrackingSystemWithValidData_Image();
        commonMethods_page.openDetailsScreen();
    }

    @Test(priority = 4)
    public void verifyAbilityToEditTrackingSystem() throws InterruptedException, AWTException {
        defineObjects();
        createTrackingSystemWithValidData_Image();
        commonMethods_page.openEditScreen();
        commonMethods_page.assertValidationMessage("Updated Successfully");

    }
*/

    // Verify ability to delete tracking not have enrolled users
    @Test(priority = 7)
    public void verifyAbilityToDeleteTrackingSystem() throws InterruptedException, AWTException {
        createFreeTrackingSystemWithValidData_Image();
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        Thread.sleep(3000);
        softAssert.assertFalse(commonMethods_page.table().contains(nameEN));
    }

    // Check Tracking system details
    // Passed

    @Test(priority = 8)
    public void checkTrackingSystemDetails() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openTrackingList();
        trackingSystem_page.clickAddBtn();
        trackingSystem_page.createTrackingSystemWithValidData(true, true, nameEN, nameAR,
                requiredShortDesEN, requiredShortDesAR,
                requiredLongDesEN, requiredLongDesAR,
                requiredDuration, requiredSEONameEN, requiredSEONameAR, requiredSEONDescEN, requiredSEONDescAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Free"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Published"));
        commonMethods_page.openDetailsScreen();
        System.out.println(nameEN);
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Name EN ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Name AR ").contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Short Description EN ").contains(requiredShortDesEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Short Description AR ").contains(requiredShortDesAR));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Long Description EN ").contains(requiredLongDesEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Long Description AR ").contains(requiredLongDesAR));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Fields ").contains("AutomationField"));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Status ").contains("Published"));
        softAssert.assertAll();
    }

    // Check validation messages on all fields
    // Passed except fields
    @Test(priority = 9)
    public void checkTrackingSystemValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openTrackingList();
        trackingSystem_page.clickAddBtn();
        trackingSystem_page.clickSubmit();
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
