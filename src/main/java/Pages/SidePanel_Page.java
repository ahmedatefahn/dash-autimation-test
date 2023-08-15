package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SidePanel_Page extends PageBase {


    public SidePanel_Page(WebDriver driver) {
        super(driver);
        //   wait = new WebDriverWait(currentDriver , 20);

    }

    By coursesTabParent = By.id("courses");
    By coursesTab = By.xpath("(//span[contains(text() , 'Courses')])[2]");
    By coursesList = By.id("apps-courses-list");

    By addCourseTabSidePanel = By.id("apps-courses-add");


    By sectionsTab = By.id("sections");
    By sectionsList = By.id("apps-sections-list");
    By addSectionsSidePanel = By.id("apps-sections-add");

    By lessonTab = By.id("lessons");
    By lessonList = By.id("apps-lessons-list");
    By addLessonSidePanel = By.id("apps-lessons-add");

    By quizTab = By.id("quiz");
    By quizList = By.id("apps-quizzes-list");
    By addQuizSidePanel = By.id("apps-quizzes-add");


    By practicalTaskTab = By.id("practical-tasks");
    By practicalTaskList = By.id("apps-practical-tasks-list");
    By addPracticalTaskSidePanel = By.id("apps-practicalTasks-add");


    By consultationTab = By.id("consultation");
    By consultantsTab = By.id("apps-consultation-accepted-list");

    By addConsultantTab = By.id("apps-consultation-add");


    By fieldsConsultationsTab = By.id("fields");
    By fieldsConsultationsList = By.id("apps-fields-list");
    By addFieldsConsultationsSidePanel = By.id("apps-fields-add");

    By specialtyTab = By.id("specialty");
    By specialtyList = By.id("apps-speciality-list");
    By addSpecialtySidePanel = By.id("apps-speciality-add");


    By jobTitleTab = By.id("job-title");
    By jobTitleList = By.id("apps-jobTitle-list");
    By addJobTitleSidePanel = By.id("apps-jobTitle-add");

    By categoriesTab = By.id("categories");
    By categoriesList = By.id("apps-categories-list");
    By addCategoriesSidePanel = By.id("apps-categories-add");

    By surveyTab = By.id("survey");
    By surveyList = By.id("apps-questionnaires-list");

    By addSurveySidePanel = By.id("apps-questionnaires-add");


    By bankQuestionTab = By.id("bank-questions");
    By adminTab = By.id("admin");
    By adminList = By.id("apps-bank-questions-admin-list");
    By addAdminSidePanel = By.id("apps-bank-questions-add");

    By certificatesTab = By.id("certificates");
    By certificatesList = By.id("apps-certificates-list");
    By addCertificatesSidePanel = By.id("apps-certificates-add");

    By currenciesTab = By.id("currencies");
    By currenciesList = By.id("apps-currency-list");
    By addCurrenciesSidePanel = By.id("apps-currency-add");


    By personalityTab = By.id("personality-analysis");
    By personalityCategoryTab = By.id("categories");

    By personalityCategoryList = By.id("apps-personality-categories-list");
    By addPersonalityCategorySidePanel = By.id("apps-personality-categories-add");


    By trackingSysParent = By.id("tracking-system");
    By sidePanel = By.cssSelector("div.main-menu.menu-fixed.menu-accordion.menu-shadow.expanded.menu-light");
    By trackingSysTab = By.xpath("(//span[contains(text() , 'Tracking System')])[2]");
    By listTrackingSysTab = By.id("apps-tracking-system-list");
    By addTrackingSysSidePanel = By.id("apps-tracking-system-add");
    By fields = By.xpath("//*[@id='tracking-system']//*[@id='fields']");
    By listFields = By.id("apps-tracking-system-fields-and-goals-list");
    By addFieldsSidePanel = By.id("apps-tracking-system-fields-and-goals-add");
    By activity = By.id("activity");
    By listActivity = By.id("apps-tracking-system-activity-list");
    By addActivitySidePanel = By.id("apps-tracking-system-activity-add");

    By initiative = By.id("initiative");
    By listInitiative = By.id("apps-tracking-system-initiative-list");
    By addInitiativeSidePanel = By.id("apps-tracking-system-initiative-add");

    By roles = By.id("roles");
    By rolesList = By.id("apps-roles-list");

    By addRoleSidePanel = By.id("apps-roles-add");

    By userModule = By.id("user");
    By adminUserList = By.id("admin-list");
    By userList = By.id("user-list");
    By add = By.id("add");

    By sliderTab = By.id("sliders");
    By sliderList = By.id("apps-sliders-list");
    By addSliderSidePanel = By.id("apps-sliders-add");


    // Coupons
    By couponsTab = By.id("coupons");
    By couponsList = By.id("apps-coupons-list");
    By addCouponsSidePanel = By.id("apps-coupons-add");


    public void openCoursesList() {
        waitElementToBeVisible(coursesTabParent);
        Click(coursesTabParent);
        waitElementToBeVisible(coursesTab);
        Click(coursesTab);
        waitElementToBeVisible(coursesList);
        Click(coursesList);
    }

    public void openAddCourseSidePanel() {
        Click(coursesTabParent);
        Click(coursesTab);
        Click(addCourseTabSidePanel);
    }

    public void openSectionsList() {
        Click(coursesTabParent);
        Click(sectionsTab);
        scrollToElement(sectionsList);
        Click(sectionsList);
    }

    public void openAddSectionsSidePanel() {
        Click(coursesTabParent);
        Click(sectionsTab);
        scrollToElement(addSectionsSidePanel);
        Click(addSectionsSidePanel);
    }

    public void openLessonList() {
        Click(coursesTabParent);
        Click(lessonTab);
        scrollToElement(lessonList);
        Click(lessonList);
    }

    public void openAddLessonSidePanel() {
        Click(coursesTabParent);
        Click(lessonTab);
        scrollToElement(addLessonSidePanel);
        Click(addLessonSidePanel);
    }

    public void openQuizList() {
        Click(coursesTabParent);
        Click(quizTab);
        scrollToElement(quizList);
        Click(quizList);
    }


    public void openAddQuizSidePanel() {
        Click(coursesTabParent);
        Click(quizTab);
        scrollToElement(addQuizSidePanel);
        Click(addQuizSidePanel);
    }

    public void openPracticalTaskList() {
        Click(coursesTabParent);
        Click(practicalTaskTab);
        scrollToElement(practicalTaskList);
        Click(practicalTaskList);
    }

    public void openAddPracticalTaskListSidePanel() {
        Click(coursesTabParent);
        Click(practicalTaskTab);
        scrollToElement(addPracticalTaskSidePanel);
        Click(addPracticalTaskSidePanel);
    }

    public void openFieldsConsultationsList() throws InterruptedException {
        Click(consultationTab);
        Click(fieldsConsultationsTab);
        scrollToElement(fieldsConsultationsList);
        Click(fieldsConsultationsList);
    }

    public void openAddFieldsConsultationsSidePanel() throws InterruptedException {
        Click(consultationTab);
        Click(fieldsConsultationsTab);
        scrollToElement(addFieldsConsultationsSidePanel);
        Click(addFieldsConsultationsSidePanel);
    }

    public void openSpecialityList() throws InterruptedException {
        Click(consultationTab);
        Click(specialtyTab);
        Click(specialtyList);
    }

    public void openAddSpecialitySidePanel() throws InterruptedException {
        Click(consultationTab);
        Click(specialtyTab);
        scrollToElement(addSpecialtySidePanel);
        Click(addSpecialtySidePanel);
    }

    public void openJobTaskList() {
        Click(consultationTab);
        Click(jobTitleTab);
        scrollToElement(jobTitleList);
        Click(jobTitleList);
    }

    public void openAddJobTaskSidePanel() {
        Click(consultationTab);
        Click(jobTitleTab);
        scrollToElement(addJobTitleSidePanel);
        Click(addJobTitleSidePanel);
    }

    public void openCategoriesList() {
        Click(categoriesTab);
        Click(categoriesList);
    }

    public void openAddCategoriesSidePanel() {
        Click(categoriesTab);
        Click(addCategoriesSidePanel);
    }

    public void openSurveyList() {
        Click(surveyTab);
        Click(surveyList);
    }

    public void openSAddSurveySidePanel() {
        Click(surveyTab);
        Click(addSurveySidePanel);
    }

    public void openAdminList() {
        Click(bankQuestionTab);
        Click(adminTab);
        Click(adminList);
    }

    public void openAddAdminSidePanel() {
        Click(bankQuestionTab);
        Click(adminTab);
        Click(addAdminSidePanel);
    }

    public void openCertificatesList() {
        Click(certificatesTab);
        Click(certificatesList);
    }

    public void openAddCertificatesSidePanel() {
        Click(certificatesTab);
        Click(addCertificatesSidePanel);
    }

    public void openCurrenciesList() {
        Click(currenciesTab);
        Click(currenciesList);
    }

    public void openAddCurrenciesSidePanel() {
        Click(currenciesTab);
        Click(addCurrenciesSidePanel);
    }

    public void openSlidersList() {
        waitElementToBeVisible(sliderTab);
        scrollToElement(sliderTab);
        Click(sliderTab);
        Click(sliderList);
    }

    public void OpenAddSlidersSidePanel() {
        //  Click(initiative);
        waitElementToBeVisible(sliderTab);
        scrollToElement(sliderTab);
        Click(sliderTab);
        scrollToElement(addSliderSidePanel);
        Click(addSliderSidePanel);
    }

    public void openPersonalityCategoryList() {
        Click(personalityTab);
        Click(personalityCategoryTab);
        Click(personalityCategoryList);
    }

    public void openAddPersonalityCategorySidePanel() {
        Click(personalityTab);
        Click(personalityCategoryTab);
        Click(addPersonalityCategorySidePanel);
    }

    public void openTrackingList() throws InterruptedException {
        Click(trackingSysParent);
        Click(trackingSysTab);
        Click(listTrackingSysTab);
    }

    public void openAddTrackingSidePanel() throws InterruptedException {
        Click(trackingSysParent);
        Click(trackingSysTab);
        scrollToElement(addTrackingSysSidePanel);
        Click(addTrackingSysSidePanel);
    }

    public void openFieldsList() {
        Click(trackingSysParent);
        scrollToElement(fields);
        Click(fields);
        //  scrollToElement(listFields);
        Click(listFields);
    }

    public void openAddFieldSidePanel() {
        Click(trackingSysParent);
        scrollToElement(fields);
        Click(fields);
        scrollToElement(addFieldsSidePanel);
        Click(addFieldsSidePanel);
    }

    public void openActivityList() {
        Click(trackingSysParent);
        scrollToElement(activity);
        Click(activity);
        scrollToElement(listActivity);
        Click(listActivity);
    }

    public void openAddActivitySidePanel() {
        Click(trackingSysParent);
        scrollToElement(activity);
        Click(activity);
        scrollToElement(addActivitySidePanel);
        Click(addActivitySidePanel);
    }

    public void openInitiativeList() {
        waitElementToBeVisible(initiative);
        Click(initiative);
        scrollToElement(listInitiative);
        Click(listInitiative);
    }

    public void openAddInitiativeSidePanel() {
        Click(initiative);
        scrollToElement(addInitiativeSidePanel);
        Click(addInitiativeSidePanel);
    }

    public void openRolesList() {
        Click(roles);
        Click(rolesList);
    }

    public void openAddRolesSidePanel() {
        Click(roles);
        Click(addRoleSidePanel);
    }


    public void openUserList() {
        Click(userModule);
        Click(userList);
    }

    public void openAdminUserList() {
        Click(userModule);
        Click(adminUserList);
    }

    public void openAddUser() {
        Click(userModule);
        Click(add);
    }

    public void openAddConsultant() {
        Click(consultationTab);
        Click(addConsultantTab);
    }

    public void openConsultantsTab() {
        Click(consultationTab);
        Click(consultantsTab);
    }

    public void openCouponList() {
        waitElementToBeVisible(sliderTab);
        scrollToElement(sliderTab);
        waitElementToBeVisible(couponsTab);
        scrollToElement(couponsTab);
        Click(couponsTab);
        scrollToElement(couponsList);
        Click(couponsList);
    }

    public void openAddCouponSidePanel() {
        waitElementToBeVisible(sliderTab);
        scrollToElement(sliderTab);
        waitElementToBeVisible(couponsTab);
        scrollToElement(couponsTab);
        Click(couponsTab);
        scrollToElement(addCouponsSidePanel);
        Click(addCouponsSidePanel);
    }

    By tasks = By.id("tasks");
    By tasksList = By.id("apps-task-list");
    By myUsersList = By.id("apps-task-enrolled-users-list");
    By addTab = By.id("apps-task-add");

    public void openTasksList() {
        Click(tasks);
        Click(tasksList);

    }

    public void openMyUsersList() {
        Click(tasks);
        Click(myUsersList);

    }

    public void openAddTab() {
        Click(tasks);
        Click(addTab);

    }

    By adsTab = By.id("ads");
    By adsList = By.id("apps-ads-list");
    By adsAdd = By.id("apps-ads-add");

    public void openAdsList()
    {
        waitElementToBeVisible(adsTab);
        Click(adsTab);
        scrollToElement(adsList);
        waitElementToBeVisible(adsList);
        Click(adsList);
    }

    public void openAdsAdd()
    {
        waitElementToBeVisible(adsTab);
        Click(adsTab);
        scrollToElement(adsAdd);
        waitElementToBeVisible(adsAdd);
        Click(adsAdd);
    }

    By storiesTab = By.id("stories");
    By adminListTab = By.id("apps-story-admin-list");
    By usersListTab = By.id("apps-story-users-list");
    By addStoryTab = By.id("apps-story-add");

    public void openAdminListTab()
    {
        waitElementToBeVisible(adsTab);
        scrollToElement(adsTab);
        Click(storiesTab);
        scrollToElement(adminListTab);
        Click(adminListTab);
    }

    public void openAddStoryTab()
    {
        waitElementToBeVisible(adsTab);
        scrollToElement(adsTab);
        Click(storiesTab);
        scrollToElement(adminListTab);
        scrollToElement(usersListTab);

        scrollToElement(addStoryTab);
        Click(addStoryTab);
    }

    public void clickSubmit()
    {
        Click(submitBtn);
    }

}
