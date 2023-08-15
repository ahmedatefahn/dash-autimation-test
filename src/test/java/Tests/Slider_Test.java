package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Slider_Test extends TestBase {


    // Add slider on web
    // Passed
    @Test(priority = 1)
    public void addSliderOnWeb() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSlidersList();
        addSliderPage.clickAddBtn();
        addSliderPage.addSlider(false, false, false, nameEN, nameAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));
    }

    // Add slider on web side panel
    // Fail
    @Test(priority = 2)
    public void addSliderOnWebSidePanel() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.OpenAddSlidersSidePanel();
        addSliderPage.addSlider(false, false, false, nameEN, nameAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));
    }

    // Edit slider name and status to active and to display all [Web]
    // Passed
    @Test(priority = 3)

    public void EditSliderNameAndStatusToInactiveAndToDisplayAll() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSlidersList();
        addSliderPage.clickAddBtn();

        addSliderPage.editSlider(false, false, false, nameEN, nameAR, EditNameEN, EditNameAR, false, true
                , true);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Inactive"));
    }

    // Add slider on mobile
    // Passed
    @Test(priority = 4)
    public void addSliderOnMobile() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSlidersList();
        addSliderPage.clickAddBtn();

        addSliderPage.addSlider(true, false, false, nameEN, nameAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));

    }

    // Add slider on mobile and web
    // Passed
    @Test(priority = 5)
    public void addSliderOnMobileAndWeb() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSlidersList();
        addSliderPage.clickAddBtn();

        addSliderPage.addSlider(false, true, false, nameEN, nameAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));

    }

    // Add slider on web Inactive
    // Passed
    @Test(priority = 6)
    public void addSliderOnWebInactive() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSlidersList();
        addSliderPage.clickAddBtn();

        addSliderPage.addSlider(false, false, true, nameEN, nameAR);
        //   softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Inactive"));
    }

    // Delete slider on web
    // Passed
    @Test(priority = 7)
    public void deleteSliderOnWeb() throws InterruptedException, AWTException {
        addSliderOnWeb();
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
        Thread.sleep(3000);
        softAssert.assertFalse(commonMethods_page.table().contains(nameEN));

    }


    // Search slider
    // Passed
    @Test(priority = 8)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        addSliderOnWeb();
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
    }

    // Check slider name english, arabic, display on, status on details
    //Passed
    @Test(priority = 9)
    public void checkSliderDetailsAfterAddSlider() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSlidersList();
        addSliderPage.clickAddBtn();
        addSliderPage.addSlider(false, false, false, nameEN, nameAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Active"));
        commonMethods_page.openDetailsScreen();
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Name EN ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Name AR ").contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Display In ").contains("web"));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Status ").contains("Active"));
        softAssert.assertAll();

    }

}
