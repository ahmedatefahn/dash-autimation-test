package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonElements extends PageBase{
    public CommonElements(WebDriver driver) {
        super(driver);
    }

    By fieldNameEN = By.id("name");
    By fieldNameAR = By.id("name_ar");
    By seoNameEN = By.id("seo_name_en");
    By seoNameAR = By.id("seo_name_ar");
    By seoDescEN = By.id("seo_description_en");
    By seoDescAR = By.id("seo_description_ar");
    By seoImage = By.id("image_seo");
    By submitBtn = By.xpath("//button[@type = 'submit']");
}
