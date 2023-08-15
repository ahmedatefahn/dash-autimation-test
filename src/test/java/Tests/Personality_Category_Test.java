package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Personality_Category_Test extends TestBase{



    // Add personality category

    @Test(priority = 1)
    public void createPersonalityCategory() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openPersonalityCategoryList();
        personalityCategoryPage.clickAddBtn();
        personalityCategoryPage.addCategory(nameEN,nameAR,nameEN,nameAR,nameEN,nameAR,requiredSEONDescEN,requiredSEONDescAR);
     //   softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Add personality category side panel

    @Test(priority = 2)
    public void createPersonalityCategorySidePanel() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddPersonalityCategorySidePanel();
        personalityCategoryPage.addCategory(nameEN,nameAR,nameEN,nameAR,nameEN,nameAR,requiredSEONDescEN,requiredSEONDescAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }
}
