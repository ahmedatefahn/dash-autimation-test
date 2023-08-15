package Tests;

import Pages.*;

import com.github.javafaker.Faker;


import com.github.javafaker.Number;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TestBase {
    public static WebDriver driver;

    public static ExtentReports extent;

    public static ExtentTest logger;

    public SoftAssert softAssert = new SoftAssert();

    TrackingSystem_Page trackingSystem_page;
    Login_Page loginPage;
    SidePanel_Page sidePanel_page;
    Fields_Page fields_page;
    Activity_Page activity_page;
    CommonMethods_Page commonMethods_page;

    Initiative_Page initiativePage;
    Courses_Page coursesPage;
    Sections_Page sectionsPage;
    Quiz_Page quizPage;
    Lesson_Page lessonPage;

    PracticalTask_Page practicalTaskPage;

    JobTitle_Page jobTitlePage;

    Fields_Consultations_Page fieldsConsultationsPage;

    Categories_Page categoriesPage;

    Survey_Page surveyPage;

    BankQuestion_Page bankQuestionPage;
    Certificate_Page certificatePage;

    Currencies_Page currenciesPage;
    Slider_Page addSliderPage;
    Personality_Category_Page personalityCategoryPage;

    Logout_Page logoutPage;
    Roles_Page rolesPage;
    User_Page userPage;
    Add_Consultant_Page addConsultantPage ;

    Speciality_Page specialityPage ;
    Coupons_Page couponsPage ;

    Tasks_Page tasksPage;

    Ads_Page adsPage;
    Stories_Page storiesPage;

    Faker fakeData = new Faker();
    String nameEN = fakeData.name().name();
    String nameAR = fakeData.name().name();
    String slugName = fakeData.name().name();

    String seoNameEN = fakeData.name().name();
    String seoNameAR = fakeData.name().name();

    Number fakeCode = fakeData.number();

    String fakeMail = fakeData.internet().emailAddress();

    String EditNameEN = "Edit" + new Random().nextInt(9999);
    String EditNameAR = "Edit" + new Random().nextInt(9999);

    String slugNameEdit = "Edit" + new Random().nextInt(9999);

    String PriceEdit = "1";


    ////
    String Email = "momen@nurabi.net";
    String Password = "19821120Mm";

    String requiredNameEN = "Tracking NameEN Automation";
    String requiredNameAR = "Tracking NameAR Automation";
    String requiredShortDesEN = "Tracking ShortDesEN Automation";
    String requiredShortDesAR = "Tracking ShortDesAR Automation";
    String requiredLongDesEN = "Tracking LongDesEN Automation";
    String requiredLongDesAR = "Tracking LongDesAR Automation";
    String requiredDuration = "5";
    String requiredSEONameEN = "Tracking SEOEN Automation";
    String requiredSEONameAR = "Tracking SEOAR Automation";
    String requiredSEONDescEN = "Tracking SEODescEN Automation";
    String requiredSEONDescAR = "Tracking SEODescAR Automation";
    String imagePath = "D:\\Photos\\ISTQB.png";
    String videoPath = "D:\\Courses\\Appium\\Find Elements by Accessibility ID.mp4";
    String price = "requiredPrice";


    @BeforeMethod
    public void startDriver(Method method) {
        logger = extent.startTest(method.getName());
       // WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//Driver//chromedriver.exe" );
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("use-fake-device-for-media-stream");
        options.addArguments("use-fake-ui-for-media-stream");*/
         driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        driver.navigate().to("https://dashboard.nurabi.live/");
        extent = new ExtentReports("D:\\Nurabi\\Nurabi_Dashboard1\\TestReport\\index.html", true);
        extent.addSystemInfo("OS", "Windows");
        extent.addSystemInfo("Owner", "Basma");
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("document.body.style.zoom = '80%';");


     //   driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void takeScreenShot(ITestResult result, Method method) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, result.getThrowable());
            logger.log(LogStatus.FAIL, "<a href = '" + result.getName() + ".png" + "' > <span class='label info'>Download Snapshot</span></a>");

            System.out.println("Failed");
            // Create reference for screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./TestReport/" + result.getName() + ".png"));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "Test Pass");
            logger.log(LogStatus.PASS, "<a href = '" + result.getName() + ".png" + "' > <span class='label info'>Download Snapshot</span></a>");
            System.out.println("Passed");
            // Create reference for screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./TestReport/" + result.getName() + ".png"));
        } else {
            logger.log(LogStatus.SKIP, " Test Skipped");
        }
        logoutPage.logout();
     //   driver.close();
    }

    //    @AfterSuite
//    public void stopDriver(){
//        driver.quit();
//    }
    public void defineObjects() {
        trackingSystem_page = new TrackingSystem_Page(driver);
        loginPage = new Login_Page(driver);
        sidePanel_page = new SidePanel_Page(driver);
        fields_page = new Fields_Page(driver);
        activity_page = new Activity_Page(driver);
        commonMethods_page = new CommonMethods_Page(driver);
        initiativePage = new Initiative_Page(driver);
        coursesPage = new Courses_Page(driver);
        sectionsPage = new Sections_Page(driver);
        quizPage = new Quiz_Page(driver);
        lessonPage = new Lesson_Page(driver);
        practicalTaskPage = new PracticalTask_Page(driver);
        jobTitlePage = new JobTitle_Page(driver);
        fieldsConsultationsPage = new Fields_Consultations_Page(driver);
        categoriesPage = new Categories_Page(driver);
        surveyPage = new Survey_Page(driver);
        bankQuestionPage = new BankQuestion_Page(driver);
        certificatePage = new Certificate_Page(driver);
        currenciesPage = new Currencies_Page(driver);
        addSliderPage = new Slider_Page(driver);
        personalityCategoryPage = new Personality_Category_Page(driver);
        logoutPage = new Logout_Page(driver);
        rolesPage = new Roles_Page(driver);
        userPage = new User_Page(driver);
        addConsultantPage =new Add_Consultant_Page(driver);
        specialityPage = new Speciality_Page(driver);
        couponsPage = new Coupons_Page(driver);
        tasksPage = new Tasks_Page(driver);
        adsPage = new Ads_Page(driver);
        storiesPage =new Stories_Page(driver);
    }

    @BeforeClass
    public void start() {
        extent = new ExtentReports("D:\\Nurabi\\Nurabi_Dashboard1\\TestReport\\index.html", true);
        extent.addSystemInfo("OS", "Windows");
        extent.addSystemInfo("Owner", "Basma");

    }

    @AfterClass
    public void flush() {
        extent.flush();

    }


    public String[] getTimeAMPM() {

        DateFormat dateFormat = new SimpleDateFormat("hh:mm:aa");
        String dateString = dateFormat.format(new Date());
        return dateString.split(":");
    }

    public void login() throws InterruptedException {
        loginPage.loginWithValidData(Email, Password);
    }

    public void loginWithConsultant() throws InterruptedException {
        loginPage.loginWithValidData("Mm@mm.eee", "155355555");
    }

}
