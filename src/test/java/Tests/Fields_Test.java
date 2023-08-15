package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.Random;

public class Fields_Test extends TestBase {

    String requiredSEONameEN = "Fields SEOEN Automation";
    String requiredSEONameAR = "Fields SEOAR Automation";
    String requiredSEODescEN = "Fields SEODescEN Automation";
    String requiredSEODescAR = "Fields SEODescAR Automation";


    // Create Field Parent / Published
    @Test(priority = 1)
    public void createPublishedParentFieldsWithValidData() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openFieldsList();
        fields_page.clickAddBtn();
        fields_page.createParentFieldWithValidData(true, true, nameEN, nameAR, requiredSEONameEN,
                requiredSEONameAR, requiredSEODescEN, requiredSEODescAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Published"));

    }

    // Create Field Parent / Published side panel
    @Test(priority = 2)
    public void createPublishedParentFieldsWithValidDataSidePanel() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openAddFieldSidePanel();
        fields_page.createParentFieldWithValidData(true, true, nameEN, nameAR, requiredSEONameEN,
                requiredSEONameAR, requiredSEODescEN, requiredSEODescAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Published"));

    }

    // Create Field Parent / Draft

    @Test(priority = 3)
    public void createDraftParentFieldsWithValidData() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openFieldsList();
        fields_page.clickAddBtn();
        fields_page.createParentFieldWithValidData(true, false, nameEN, nameAR, requiredSEONameEN,
                requiredSEONameAR, requiredSEODescEN, requiredSEODescAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Drafted"));

    }

    // Create Field Child  / Published

    @Test(priority = 4)
    public void createPublishedChildFieldsWithValidData(Method method) throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openFieldsList();
        fields_page.clickAddBtn();

        fields_page.createParentFieldWithValidData(false, true, nameEN, nameAR, requiredSEONameEN,
                requiredSEONameAR, requiredSEODescEN, requiredSEODescAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

//        softAssert.assertTrue(commonMethods_page.table().contains(requiredNameEN));
//        softAssert.assertTrue(commonMethods_page.table().contains("Published"));

    }


    // Create Field Child / Draft
    @Test(priority = 5)
    public void createDraftChildFieldsWithValidData(Method method) throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openFieldsList();
        fields_page.clickAddBtn();

        fields_page.createParentFieldWithValidData(false, false, nameEN, nameAR, requiredSEONameEN,
                requiredSEONameAR, requiredSEODescEN, requiredSEODescAR);
    //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        //      softAssert.assertTrue(commonMethods_page.table().contains(requiredNameEN));
        //     softAssert.assertTrue(commonMethods_page.table().contains("Drafted"));
    }


    // Search by field name
    // Passed
    @Test(priority = 6)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        createPublishedParentFieldsWithValidData();
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
    }

    // Edit field name and type to child |  status to drafted
    // Passed
    @Test(priority = 7)
    public void editFieldNameAndStatus() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openFieldsList();
        fields_page.clickAddBtn();

        fields_page.editField(true,true,true,true
                ,nameEN,nameEN,nameEN,nameAR,requiredSEODescEN,
                requiredSEODescAR, EditNameEN , EditNameAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Drafted"));


    }

    /*

    @Test(priority = 3)
    public void verifyDataOfFieldsDetails(Method method) throws InterruptedException, AWTException {
        defineObjects();
        createDraftParentFieldsWithValidData(method);
        commonMethods_page.openDetailsScreen();
    }

    @Test(priority = 4)
    public void verifyAbilityToEditFields(Method method) throws InterruptedException, AWTException {
        defineObjects();
        createDraftParentFieldsWithValidData(method);
        commonMethods_page.openEditScreen();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));

    }

    @Test(priority = 5)
    public void verifyAbilityToDeleteField(Method method) throws InterruptedException, AWTException {
        defineObjects();
        createDraftParentFieldsWithValidData(method);
        commonMethods_page.delete();
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Deleted Successfully"));

    }

 */

    // Check fields details
    // Passed
    @Test(priority = 8)
    public void checkFieldsDetails() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openFieldsList();
        fields_page.clickAddBtn();
        fields_page.createParentFieldWithValidData(true, true, nameEN, nameAR, requiredSEONameEN,
                requiredSEONameAR, requiredSEODescEN, requiredSEODescAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        softAssert.assertTrue(commonMethods_page.table().contains("Published"));
        commonMethods_page.openDetailsScreen();
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Name EN ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Name AR ").contains(nameAR));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Status ").contains("Published"));
        softAssert.assertAll();

    }
    // Check fields validations
    // Passed
    @Test(priority = 9)
    public void checkFieldsValidations() throws InterruptedException {
        defineObjects();
        login();
        sidePanel_page.openFieldsList();
        fields_page.clickAddBtn();
        fields_page.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationNameEN().contains("The name EN field is required"));
        Assert.assertTrue(commonMethods_page.getValidationNameAR().contains("The name AR field is required"));
        softAssert.assertAll();

    }

}
