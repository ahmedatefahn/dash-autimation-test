package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class Coupons_Page extends PageBase {
    public Coupons_Page(WebDriver driver) {
        super(driver);
    }

    By addCouponBtn = By.xpath("//span[contains(text(), 'Add Coupon')]");
    By descriptionENTxt = By.id("description_en");
    By status = By.id("statusSelectOptions");
    By statusActive = By.cssSelector("#statusSelectOptions ul li .Active");
    By statusInActive = By.cssSelector("#statusSelectOptions ul li .Inactive");
    By datePicker = By.id("expiration_date_picker");
    By selectCurrentDate = By.cssSelector("span.btn.border-0.rounded-circle.text-nowrap.btn-outline-primary.font-weight-bold");
    By codeTxt = By.id("code");
    By type = By.id("typeSelectOptions");
    By percentType = By.cssSelector("#typeSelectOptions ul li .Percent");
    By amountType = By.cssSelector("#typeSelectOptions ul li .Amount");

    By valueTxt = By.id("value");
    By numberUsagePerUser = By.id("number_of_usage_per_user");
    By numberUsage = By.id("number_of_usage");


    public void clickAddCoupon() {
        Click(addCouponBtn);
    }
    public void clickSubmit() {
        Click(submitBtn);
    }

    public void createCoupon(String nameEN, String descTXT,boolean active,boolean amount) throws InterruptedException {
        writeOnText(nameENTxt, nameEN + new Random().nextInt(9999));
        writeOnText(descriptionENTxt, descTXT);
        if (active) {
            Thread.sleep(3000);
            Click(status);
            Click(statusActive);
        }
        Click(datePicker);
        Click(selectCurrentDate);
        writeOnText(codeTxt , "1" +new Random().nextInt(9999));

        if (amount)
        {
            Click(type);
            Click(amountType);
        }
        writeOnText(valueTxt , "1" +new Random().nextInt(9999));
        writeOnText(numberUsagePerUser , "1" +new Random().nextInt(9999));
        writeOnText(numberUsage , "1" +new Random().nextInt(9999));
        Click(submitBtn);

    }

    public void editCoupon(String nameEN, String descTXT,boolean active,boolean amount
    , String nameENEdit , String descTXTEdit , boolean activeEdit,boolean amountEdit) throws InterruptedException {
        clickAddCoupon();
        createCoupon(nameEN,descTXT,active,amount);
        openEditScreen();
        Thread.sleep(2000);
        clear(nameENTxt);
        writeOnText(nameENTxt, nameENEdit + new Random().nextInt(9999));
        writeOnText(descriptionENTxt, descTXTEdit);
        if (activeEdit) {
            Click(status);
            Click(statusActive);
        }
        else {
            Click(status);
            Click(statusInActive);
        }
    /*    Click(datePicker);
        Click(selectCurrentDate);*/
        clear(codeTxt);
        writeOnText(codeTxt , "1" +new Random().nextInt(9999));

        if (amountEdit)
        {
            Click(type);
            Click(amountType);
        }
        else {
            Click(type);
            Click(percentType);
        }
        writeOnText(valueTxt , "1" + new Random().nextInt(9999));
        writeOnText(numberUsagePerUser , "1" +new Random().nextInt(9999));
        writeOnText(numberUsage , "1" +new Random().nextInt(9999));
        Click(submitBtn);

    }
}
