package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageBase {
    protected WebDriver currentDriver;
    public JavascriptExecutor jse;
    List<WebElement> allChildNodes;
    List<String> allvalues;

    WebElement element;
    WebDriverWait wait;


    Actions action;

    public PageBase(WebDriver driver) {
        this.currentDriver = driver;

    }

    public void Click(By locator) {
        waitElementToBeVisible(locator);
        try {
            currentDriver.findElement(locator).click();
        } catch (Exception e) {
            jse = (JavascriptExecutor) currentDriver;
            jse.executeScript("arguments[0].click();", currentDriver.findElement(locator));
        }
    }

    public void writeOnText(By element, String text) {
        waitElementToBeVisible(element);

        try {
            currentDriver.findElement(element).sendKeys(text);
        } catch (NoSuchElementException e) {
            System.out.println("Cannot find element, check you locators");
        }

    }

    public boolean checkIfElementIsDisplayed(By element) {
        waitElementToBeVisible(element);
        return currentDriver.findElement(element).isDisplayed();
    }

    public String getText(By element) {

        return currentDriver.findElement(element).getText();
    }

    public void selectFromDDLWithoutOptionTags(By parentList, String requiredValue) {

        // allElements = parentList.findElements(By.xpath("//*[contains(@" +
        // attributeName + ",'" + idKey + "')]"));

        allChildNodes = currentDriver.findElement(parentList).findElements(By.cssSelector("*"));
        for (WebElement element : allChildNodes) {
            System.out.println("value is ==>  " + element.getText());
            if (element.getText().contains(requiredValue)) {
                element.click();
                break;
            }
        }
    }


    public boolean checkIfElementExistInTheList(By parentList, String childTagName, String requiredValue) {
        allChildNodes = currentDriver.findElement(parentList).findElements(By.cssSelector("*"));
        allvalues = new ArrayList<String>();

        System.out.println("number of tags is ==> " + allChildNodes.size());
        for (WebElement element : allChildNodes) {

            System.out.println("element content is ==> " + element.getTagName());

            if (element.getText() != null && !element.getText().isEmpty()) {
                System.out.println(element.getText());

                allvalues.add(element.getText());
            }
        }
        return allvalues.contains(requiredValue);
    }

    //Basma
    public void scrollToElement(By locator) {
        jse = (JavascriptExecutor) currentDriver;

        jse.executeScript("arguments[0].scrollIntoView(true);", currentDriver.findElement(locator));

    }

    public void clear(By locator) {
        waitElementToBeVisible(locator);
        try {
            currentDriver.findElement(locator).clear();
        } catch (Exception e) {
            jse = (JavascriptExecutor) currentDriver;
            jse.executeScript("arguments[0].clear();", currentDriver.findElement(locator));
        }
    }

    //    public void waitElement(By locator)
//    {
//        WebDriverWait wait = new WebDriverWait(currentDriver, 20);
//        wait.until(ExpectedConditions.visibilityOf(locator));
//    }
//       public void waitElementToBeVisible(WebDriver currentDriver, By locator, int timeOutInSeconds) {
//        element = currentDriver.findElement(locator);
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }

    //    public boolean waitElementToBeVisible(By locator) {
//        element = currentDriver.findElement(locator);
//        element = wait.until(ExpectedConditions.visibilityOf(element));
//
//        if (element != null)
//            return true;
//        else
//            return false;
//    }
/*
    public boolean waitElementToBeClickable(By locator) {
        wait = new WebDriverWait(currentDriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));

        element = currentDriver.findElement(locator);
        if (element != null) {
            return true;
        }
        else
            {
                return false;
            }
        }
        */
    public void waitElementToBeVisible(By locator) {
        new WebDriverWait(currentDriver, 30).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitElementToBeVisiblee(By locator) {
        new WebDriverWait(currentDriver, 20).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitElementToBeClickable(By locator) {
        new WebDriverWait(currentDriver, 50).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitElementToBeUnVisible(By locator) {
        new WebDriverWait(currentDriver, 120).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void selectByVisibleTXT(By locator, String requiredText) {
        Select selectOption = new Select(currentDriver.findElement(locator));
        selectOption.selectByVisibleText(requiredText);
    }

    public static void clickOn(WebDriver currentDriver, WebElement locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(currentDriver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        locator.click();
    }

    public void implicitYWait() {
        currentDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void uploadFile(String fileName) throws AWTException, InterruptedException {


        String filePath = System.getProperty("user.dir") + "\\Uploads\\" + fileName;

        Robot robot = new Robot();
        StringSelection selection = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   By addCourse = By.xpath("//span[contains(text() , 'Add Course')]");
    By titleEN = By.id("title");
    By titleAR = By.id("title_ar");
    By loader = By.id("loading-logo");
    By category = By.cssSelector("[for='category']");
    By selectCategory = By.cssSelector("#categorySelectOptions ul li .Mobile.Testing");
    By type = By.id("isLiveSelectOptions");
    By selectLiveType = By.cssSelector("#isLiveSelectOptions ul li .live");
    By selectOnlineType = By.cssSelector("#isLiveSelectOptions ul li .online");

    By image = By.cssSelector("[for='image']");

    By thumbnailImage = By.cssSelector("[for='thumbnail']");
    By previewImage = By.cssSelector("[for='preview']");
    By slug = By.id("slug");
    By level = By.cssSelector("[for='level']");
    By selectLevel = By.cssSelector("#levelSelectOptions ul li .All");

    By status = By.id("statusSelectOptions");
    By selectDrafted = By.cssSelector("#statusSelectOptions ul li .Drafted");

    By selectUnPublished = By.cssSelector("#statusSelectOptions ul li .Unpublished");
    By selectPublished = By.cssSelector("#statusSelectOptions ul li .Published");



    By selectInactive = By.cssSelector("#statusSelectOptions ul li .Inactive");
    By selectActive = By.cssSelector("#statusSelectOptions ul li .Active");

    By language = By.cssSelector("[for='language']");
    By selectLanguage = By.cssSelector("#languageSelectOptions ul li .English");
    By survey = By.id("surveySelectOptions");
    By selectSurvey = By.cssSelector("#surveySelectOptions ul li:nth-child(1) span");
    By paid = By.cssSelector("[for='free']");
    By selectFree = By.cssSelector("#freeSelectOptions ul li .Free");
    By selectPaid = By.cssSelector("#freeSelectOptions ul li .Paid");

    By price = By.id("price");
    By currency = By.cssSelector("[for='currency']");
    By selectCurrency = By.cssSelector("#currencySelectOptions ul li .Dollar");
    By certificate = By.cssSelector("[for = 'certificate']");
    By selectCertificate = By.cssSelector("#certificateSelectOptions ul li .testing");
    By descEN = By.id("description");
    By descAR = By.id("description_ar");
    By seoNameENTxt = By.id("seo_name_en");
    By seoNameARTxt = By.id("seo_name_ar");
    By seoDesEN = By.id("seo_description_en");
    By seoDesAR = By.id("seo_description_ar");
    By seoImage = By.cssSelector("[for='image_seo']");
    By submitBtn = By.xpath("//span[contains(text() , 'Submit')]");

    By course = By.id("courseSelectOptions");
    By selectOnlineCourse = By.cssSelector("#courseSelectOptions ul li .AutoOnlineCourse");

    By selectLiveCourse = By.cssSelector("#courseSelectOptions ul li .AutoLiveCourse");

    By section = By.id("sectionSelectOptions");

    By selectOnlineSection = By.cssSelector("#sectionSelectOptions ul li .SectionOnline");

    By selectLiveSection = By.cssSelector("#sectionSelectOptions ul li .SectionLive");



    By introEN = By.id("introPathIdEN");
    By introAR = By.id("introPathIdAR");

    By imageEN = By.id("imageIdEn");
    By imageAR = By.id("imageIdAr");



    By introPath = By.cssSelector("[for='intro_path_type']");
    By introPathParent = By.cssSelector("#introPathSelectOptions ul li");

    By selectImage = By.cssSelector("#introPathSelectOptions ul li .Image");


    By nameENTxt = By.id("name");
    By nameARTxt = By.id("name_ar");
    By imageTracking = By.id("imageId");
    By shortDescriptionENTxt = By.id("short_description");
    By shortDescriptionARTxt = By.id("short_description_ar");
    By longDescriptionENTxt = By.id("long_description");
    By longDescriptionARTxt = By.id("long_description_ar");
    By field = By.cssSelector("[for = 'field']");
    By selectField = By.cssSelector("#fieldsSelectOptions ul li .AutomationField");
    By durationTxt = By.id("duration");

    By searchTxt = By.cssSelector("input.d-inline-block.mr-1.form-control");

    By edit = By.cssSelector(".b-dropdown.show ul li:nth-child(2) span");
    By optionList = By.xpath("(//button[@class = 'btn dropdown-toggle btn-link dropdown-toggle-no-caret'])[1]");
    public void clickOptions() {
        Click(optionList);
    }
    public void openEditScreen() {
        Click(optionList);
        waitElementToBeVisible(edit);
        Click(edit);
    }

    // Validations

    By validationNameEN = By.cssSelector("#name + small");
    By validationNameAR = By.cssSelector("#name_ar+ small");

    By validationShortDesEN = By.cssSelector("#short_description+ small");
    By validationShortDesAR = By.cssSelector("#short_description_ar+ small");
    By validationLongDesEN = By.cssSelector("#long_description+ small");
    By validationLongDesAR = By.cssSelector("#long_description_ar+ small");
    By validationDuration = By.cssSelector("#duration+ small");
    By validationIntroEN = By.cssSelector("[id^='introEn'] + small");
    By validationIntroAR = By.cssSelector("[id^='introAr'] + small");
    By validationImageEN = By.cssSelector("[id^='imageEn'] + small");
    By validationImageAR = By.cssSelector("[id^='imageAr'] + small");

    By validationThumbnail= By.cssSelector("[id^='thumbnail'] + small");
    By validationFile= By.cssSelector("[id^='file'] + small");

    By validationImageENN = By.cssSelector("[id^='image'] + small");
    By validationImageARR = By.cssSelector("[id^='image_ar'] + small");

    By validationQuestionEN = By.cssSelector("[id^='question'] + small");
    By validationQuestionAR = By.cssSelector("[id^='question_ar'] + small");

    By validationAnswerEN = By.cssSelector("[id^='answer'] + small");
    By validationAnswerAR = By.cssSelector("[id^='answer_ar'] + small");


}
