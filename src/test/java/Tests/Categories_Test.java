package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Categories_Test extends TestBase {


    // Add active category
    // Passed
    @Test(priority = 1)
    public void createActiveCategory() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openCategoriesList();
        categoriesPage.clickAdd();
        categoriesPage.addActiveCategory(nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR);
        //   softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Add active category side panel
    // Passed

    @Test(priority = 2)
    public void createActiveCategorySidePanel() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddCategoriesSidePanel();
        categoriesPage.addActiveCategory(nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR);
        //   softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Edit category name and change status to inactive
    //      Fail waiting status ids
    @Test(priority = 3)
    public void editCategoryNameAndChangeStatusToInactive() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openCategoriesList();
        categoriesPage.clickAdd();

        categoriesPage.editActiveCategory(nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR, EditNameEN, EditNameAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Search categories
    // Passed
    @Test(priority = 4)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openCategoriesList();
        categoriesPage.clickAdd();
        categoriesPage.addActiveCategory(nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR);
        //   softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));

    }

    // Check categories details
    // Passed
    @Test(priority = 5)
    public void checkCategoriesDetails() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openCategoriesList();
        categoriesPage.clickAdd();
        categoriesPage.addActiveCategory(nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR);
        //   softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        commonMethods_page.openDetailsScreen();
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Name EN ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Name AR ").contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Status ").contains("Active"));
        softAssert.assertAll();
    }

    // Check validation messages on all fields
    // Passed
    @Test(priority = 6)
    public void checkCategoriesValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openCategoriesList();
        categoriesPage.clickAdd();
        categoriesPage.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationNameEN().contains("The name en field is required"));
        Assert.assertTrue(commonMethods_page.getValidationNameAR().contains("The name ar field is required"));
        softAssert.assertAll();
    }
}
