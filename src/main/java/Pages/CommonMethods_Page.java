package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonMethods_Page extends PageBase {
    public CommonMethods_Page(WebDriver driver) {
        super(driver);
    }

    By searchTxt = By.cssSelector("input.d-inline-block.mr-1.form-control");
    By optionList = By.xpath("(//button[@class = 'btn dropdown-toggle btn-link dropdown-toggle-no-caret'])[1]");

    By details = By.cssSelector(".b-dropdown.show ul li:nth-child(1) span");
    By edit = By.cssSelector(".b-dropdown.show ul li:nth-child(2) span");
    By delete = By.cssSelector(".b-dropdown.show ul li:nth-child(3) span");
    By assignUser = By.cssSelector(".b-dropdown.show ul li:nth-child(4) span");


    By confirmDelete = By.cssSelector(".modal-footer .btn-primary");
    By rejectDelete = By.cssSelector(".modal-footer .btn-outline-secondary");


    public void clickOptions() {
        waitElementToBeVisible(optionList);
        Click(optionList);
    }

    public void openDetailsScreen() {
        clickOptions();
        waitElementToBeVisible(details);
        Click(details);
    }

    public void openEditScreen() {
        Click(optionList);
        waitElementToBeVisible(edit);
        Click(edit);
    }

    public void openAssignUser() {
        Click(optionList);
        waitElementToBeVisible(assignUser);
        Click(assignUser);
    }

    public void delete() throws InterruptedException {
        clickOptions();
        Click(delete);
        Thread.sleep(3000);
        waitElementToBeVisible(confirmDelete);
        Click(confirmDelete);
    }

    public boolean assertValidationMessage(String fullValidationMessage) {

        try {
            waitElementToBeVisible(By.xpath("//*[contains(text() ,'" + fullValidationMessage + "')]"));
            return checkIfElementIsDisplayed(By.xpath("//*[contains(text() ,'" + fullValidationMessage + "')]"));
        } catch (Exception e) {
            System.err.println("The error is ==>  " + e.getMessage());
            return false;
        }
    }

    public String getValidationText(String fullValidationMessage) {


            waitElementToBeVisible(By.cssSelector("#"+fullValidationMessage+" + small"));
            return getText(By.cssSelector("#"+fullValidationMessage+" + small"));

    }

    public String getValidationSelect(String fullValidationMessage) {


        waitElementToBeVisible(By.cssSelector("#"+fullValidationMessage+" .v-select + small"));
        return getText(By.cssSelector("#"+fullValidationMessage+" .v-select + small"));

    }

    public void search(String requiredValue) throws AWTException, InterruptedException {
        waitElementToBeVisible(optionList);
        waitElementToBeVisible(searchTxt);
        writeOnText(searchTxt, requiredValue);
        currentDriver.findElement(searchTxt).sendKeys(Keys.ENTER);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.delay(2000);
    }

    public void waitTillPageIsLoaded() {
        //    new WebDriverWait(currentDriver, 20).until(
        //        webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        WebDriverWait wait = new WebDriverWait(currentDriver, 20);
        wait.until(d -> ((JavascriptExecutor) d).executeScript("return (document.readyState === 'complete' || document.readyState === 'interactive')"));
    }

    public String table() {
        waitElementToBeVisible(optionList);
        WebElement table = currentDriver.findElement(By.cssSelector("[role = 'table']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println("size is " + rows.size());
        int size = rows.size();
        String firstRow = rows.get(1).getText();
        System.out.println("first row name is " + firstRow);

        return firstRow;

    }


    public String assertValidationText(String fullValidationMessage) throws InterruptedException {
        Thread.sleep(4000);
        //   waitElementToBeUnVisible(loader);
//        WebDriverWait wait = new WebDriverWait(currentDriver, 10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text() ,'" + fullValidationMessage + "')]/following-sibling::div")));
        System.out.println(getText(By.xpath("//*[contains(text() ,'" + fullValidationMessage + "')]/following-sibling::div")));
        return getText(By.xpath("//*[contains(text() ,'" + fullValidationMessage + "')]/following-sibling::div"));


   /*         try {


                return checkIfElementIsDisplayed(By.xpath("//*[contains(text() ,'" + fullValidationMessage + "')]/following-sibling::div"));
                //  return checkIfElementIsDisplayed(By.xpath("//*[text()='" + fullValidationMessage + "']"));

            } catch (Exception e) {
                //     System.err.println("The error is ==>  " + e.getMessage());
                return false;
            }
    }*/
    }

    public String getValidationNameEN() {
        System.out.println(getText(validationNameEN));
        return getText(validationNameEN);
    }

    public String getValidationNameAR() {
        System.out.println(getText(validationNameAR));
        return getText(validationNameAR);

    }

    public String getValidationShortDesEN() {
        System.out.println(getText(validationShortDesEN));
        return getText(validationShortDesEN);
    }

    public String getValidationShortDesAR() {
        System.out.println(getText(validationShortDesAR));
        return getText(validationShortDesAR);
    }

    public String getValidationLongDesEN() {
        System.out.println(getText(validationLongDesEN));
        return getText(validationLongDesEN);

    }

    public String getValidationLongDesAR() {
        System.out.println(getText(validationLongDesAR));
        return getText(validationLongDesAR);

    }

    public String getValidationDuration() {
        System.out.println(getText(validationDuration));
        return getText(validationDuration);

    }

    public String getValidationIntroEN() {
        System.out.println(getText(validationIntroEN));
        return getText(validationIntroEN);

    }

    public String getValidationIntroAR() {
        System.out.println(getText(validationIntroAR));
        return getText(validationIntroAR);

    }

    public String getValidationImageEN() {
        System.out.println(getText(validationImageEN));
        return getText(validationImageEN);

    }

    public String getValidationImageAR() {
        System.out.println(getText(validationImageAR));
        return getText(validationImageAR);

    }

    public String getValidationImageENN() {
        System.out.println(getText(validationImageENN));
        return getText(validationImageENN);

    }

    public String getValidationImageARR() {
        System.out.println(getText(validationImageARR));
        return getText(validationImageARR);

    }

    public String getValidationQuestionEN() {
        System.out.println(getText(validationQuestionEN));
        return getText(validationQuestionEN);

    }

    public String getValidationQuestionAR() {
        System.out.println(getText(validationQuestionAR));
        return getText(validationQuestionAR);

    }
    public String getValidationAnswerEN() {
        System.out.println(getText(validationAnswerEN));
        return getText(validationAnswerEN);

    }

    public String getValidationAnswerAR() {
        System.out.println(getText(validationAnswerAR));
        return getText(validationAnswerAR);

    }

    public String getValidationThumbnail() {
        System.out.println(getText(validationThumbnail));
        return getText(validationThumbnail);

    }
    public String getValidationFile() {
        System.out.println(getText(validationFile));
        return getText(validationFile);

    }
}



