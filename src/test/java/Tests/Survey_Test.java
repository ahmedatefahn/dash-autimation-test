package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Survey_Test extends TestBase {


    // Add Survey
    // Passed
    @Test(priority = 1)
    public void createSurvey() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSurveyList();
        surveyPage.clickAddBtn();
        surveyPage.addSurvey(nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR, nameEN, nameAR, nameEN, nameAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Add Survey side panel
    // Passed
    @Test(priority = 2)
    public void createSurveySidePanel() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSAddSurveySidePanel();
        surveyPage.addSurvey(nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR, nameEN, nameAR, nameEN, nameAR);
        //   softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));

        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
    }

    // Edit Survey
    // Passed
    @Test(priority = 3)
    public void editSurvey() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSurveyList();
        surveyPage.clickAddBtn();

        surveyPage.editSurvey(nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR, nameEN, nameAR,
                nameEN, nameAR, EditNameEN, EditNameAR, EditNameEN, EditNameAR, EditNameEN, EditNameAR);
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Updated Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(EditNameAR));
    }

    // Search survey
    // Passed
    @Test(priority = 4)
    public void verifySearchByNameEN() throws InterruptedException, AWTException {
        createSurvey();
        commonMethods_page.search(nameEN);
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
    }

    // Check survey details
    // Passed
    @Test(priority = 5)
    public void checkSurveyDetails() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSurveyList();
        surveyPage.clickAddBtn();
        surveyPage.addSurvey(nameEN, nameAR, seoNameEN, seoNameAR, requiredSEONDescEN, requiredSEONDescAR, nameEN, nameAR, nameEN, nameAR);
        //    softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.assertValidationMessage("Added Successfully"));
        softAssert.assertTrue(commonMethods_page.table().contains(nameEN));
        softAssert.assertTrue(commonMethods_page.table().contains(nameAR));
        commonMethods_page.openDetailsScreen();
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Title En ").contains(nameEN));
        softAssert.assertTrue(commonMethods_page.assertValidationText(" Title Ar ").contains(nameAR));
   //     softAssert.assertAll();
    }

    // Check validation messages on all fields
    // Passed
    @Test(priority = 6)
    public void checkSurveyValidationMessages() throws InterruptedException, AWTException {
        defineObjects();
        login();
        sidePanel_page.openSAddSurveySidePanel();
        surveyPage.clickSubmit();
        Assert.assertTrue(commonMethods_page.getValidationText("title_en").contains("The title EN field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("title_ar").contains("The Title AR field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("question-1-en").contains("The Question 1 EN field is required"));
        Assert.assertTrue(commonMethods_page.getValidationText("question-1-ar").contains("The Question 1 AR field is required"));

        softAssert.assertAll();
    }
}
