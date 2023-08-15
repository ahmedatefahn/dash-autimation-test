package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Currencies_Page extends PageBase{
    public Currencies_Page(WebDriver driver) {
        super(driver);
    }

    By addCurrencyBTN = By.xpath("//span[contains(text() , 'Add Currency')]");

    By codeTXT = By.id("code");
    By symbolTXT = By.id("symbol");

    By edit = By.cssSelector(".b-dropdown.show ul li:nth-child(1) span");
    By delete = By.cssSelector(".b-dropdown.show ul li:nth-child(2) span");

    By confirmDelete = By.cssSelector(".modal-footer .btn-primary");





    public void clickAddBtn()
    {
        Click(addCurrencyBTN);

    }
    public void clickSubmit()
    {
        Click(submitBtn);

    }
    public void addCurrency(String Name ,String code , String symbol)
    {
        writeOnText(nameENTxt , Name+new Random().nextInt(9999));
        writeOnText(codeTXT , code+new Random().nextInt(9999));
        writeOnText(symbolTXT , symbol);
        Click(submitBtn);
    }

    public void editCurrency(String Name ,String code , String symbol,String NameEdit, String codeEdit, String symbolEdit) throws InterruptedException {
        addCurrency(Name,code,symbol);
        openEditScreen();
        waitElementToBeUnVisible(loader);
        Thread.sleep(2000);
        clear(nameENTxt);
        writeOnText(nameENTxt , NameEdit);
        clear(codeTXT);
        writeOnText(codeTXT , codeEdit);
        clear(symbolTXT);
        writeOnText(symbolTXT , symbolEdit);
        Click(submitBtn);

    }

    public void openEditScreen() {
        Click(optionList);
        waitElementToBeVisible(edit);
        Click(edit);
    }

    public void delete() throws InterruptedException {
        clickOptions();
        Click(delete);
        Thread.sleep(3000);
        waitElementToBeVisible(confirmDelete);
        Click(confirmDelete);
    }
}
