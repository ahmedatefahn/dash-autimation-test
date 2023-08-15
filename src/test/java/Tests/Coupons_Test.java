package Tests;

import org.testng.annotations.Test;

import java.awt.*;

public class Coupons_Test extends TestBase {


    // Add active coupon with Percent
    // Passed

    @Test(priority = 1)
    public void verifyAbilityToAddActiveCouponWithPercent() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openCouponList();
        couponsPage.clickAddCoupon();

        couponsPage.createCoupon(nameEN, nameEN, true, false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains("percent"));
    }

    // Add active coupon with amount
    // Passed

    @Test(priority = 2)
    public void verifyAbilityToAddActiveCouponWithAmount() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openCouponList();
        couponsPage.clickAddCoupon();

        couponsPage.createCoupon(nameEN, nameEN, true, true);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains("amount"));
    }

    // Add inactive coupon with Percent
    // Passed
    @Test(priority = 3)
    public void verifyAbilityToAddInActiveCouponWithPercent() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openCouponList();
        couponsPage.clickAddCoupon();

        couponsPage.createCoupon(nameEN, nameEN, false, false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains("percent"));
    }

    // Search coupon
    // Fail manual issue
    @Test(priority = 4)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openCouponList();
        couponsPage.clickAddCoupon();
        couponsPage.createCoupon(nameEN, nameEN, false, false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
    }

    // Delete coupon
    // Passed
    @Test(priority = 5)
    public void verifyDeleteCoupon() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openCouponList();
        couponsPage.clickAddCoupon();
        couponsPage.createCoupon(nameEN, nameEN, false, false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));
    }


    // Add coupon with amount side panel
    // Passed
    @Test(priority = 6)
    public void verifyAbilityToAddCouponSidePanel() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openAddCouponSidePanel();
        couponsPage.createCoupon(nameEN, nameEN, true, false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains("percent"));
    }

    // Edit coupon name and to inactive and to amount
    // Passed

    @Test(priority = 7)
    public void verifyAbilityToEditCouponNameAndToInactiveAndToAmount() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openCouponList();
        couponsPage.clickAddCoupon();
        couponsPage.editCoupon(nameEN, nameEN, true, false, EditNameEN, EditNameEN, false, true);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains("amount"));
    }

    // check coupon details
    // Passed
    @Test(priority = 8)
    public void checkCouponDetails() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openCouponList();
        couponsPage.clickAddCoupon();
        couponsPage.createCoupon(nameEN, nameEN, true, false);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains("percent"));
        commonMethods_page.openDetailsScreen();
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Name ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Description ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Status ").contains("Active"));
        softAssert.assertAll();
    }

    // Check validation messages on all fields
    // Fail
    @Test(priority = 9)
    public void checkCouponValidationMessaged() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openCouponList();
        couponsPage.clickAddCoupon();
        couponsPage.clickSubmit();
        softAssert.assertTrue(commonMethods_page.getValidationText("name").contains("The name field is required"));
        softAssert.assertAll();
    }


}
