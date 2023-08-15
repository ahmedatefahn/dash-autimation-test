package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Stories_Test extends TestBase{




    // Verify ability to add story from admin list type text
    // Passed
    @Test
    public void checkAbilityToAddStoryFromAdminListTypeText() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdminListTab();
        storiesPage.clickAddButton();
        storiesPage.addStory(true,false,nameEN);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Saved Successfully"));
        softAssert.assertAll();
    }

    // Verify ability to add story from add tab
    // Passed
    @Test
    public void checkAbilityToAddStoryFromAddTab() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddStoryTab();
        storiesPage.addStory(true,false,nameEN);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Saved Successfully"));
        softAssert.assertAll();
    }

    // Verify ability to view story details
    // Passed

    @Test(priority = 3)
    public void checkStoryDetails() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdminListTab();
        storiesPage.clickAddButton();
        storiesPage.addStory(true,false,nameEN);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Saved Successfully"));
    //    softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        commonMethods_page.openDetailsScreen();
        System.out.println(nameEN);
        Thread.sleep(3000);
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Owner Name ").contains("Nurabi"));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Owner Type ").contains("Admin"));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Story Type ").contains("text"));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Content ").contains(nameEN));
        softAssert.assertAll();
    }
    // Verify ability to delete story
    // Passed
    @Test(priority = 4)
    public void verifyAbilityToDeleteAds() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdminListTab();
        storiesPage.clickAddButton();
        storiesPage.addStory(true,false,nameEN);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Saved Successfully"));
     //   softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        storiesPage.delete();
     //   Thread.sleep(3000);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        softAssert.assertAll();
    }

    // Verify ability to add story from admin list type image
    // Passed
    @Test(priority = 5)
    public void checkAbilityToAddStoryFromAdminListTypeImage() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdminListTab();
        storiesPage.clickAddButton();
        storiesPage.addStory(false,true,nameEN);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Saved Successfully"));
        softAssert.assertAll();
    }
    // Verify ability to add story from admin list type video
    // Performance issue
    @Test(priority = 6)
    public void checkAbilityToAddStoryFromAdminListTypeVideo() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdminListTab();
        storiesPage.clickAddButton();
        storiesPage.addStory(false,false,nameEN);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Saved Successfully"));
        softAssert.assertAll();
    }
    // Check validation messages on all fields
    // Passed except select
    @Test(priority = 7)
    public void checkStoriesValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAdminListTab();
        storiesPage.clickAddButton();
        storiesPage.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationText("content").contains("The Content field is required"));

        softAssert.assertAll();
    }
}

