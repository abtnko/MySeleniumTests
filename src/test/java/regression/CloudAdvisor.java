package regression;

import base.BaseTests;
import base.User;
import net.bytebuddy.pool.TypePool;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import pages.CloudAdvisorPage;
import pages.DashboardPage;
import pages.LoginPage;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CloudAdvisor extends BaseTests {

    final String DEVICE_ON_MANAGE = "Alcatel";
    final String DEVICE_ON_OVERVIEW = "Alcatel U5";
    final String FULL_DEVICE_NAME = "6 Alcatel U5 Android 9.1  63";
    final String TASK = "6. Alcatel U5 6 Replace with Samsung Galaxy S3 on Android 9.0 2020-02-25";
    final String DEVICE_NAME = "Apple iPhone XS Max";
    final String NEW_DEVICE_MODEL = "Galaxy S10";
    final String TABS_NAMES = "Overview\n" +
            "          Manage\n" +
            "          Task Generator\n" +
            "          Archive";
    final String CHECK_DEVICE = "1 Samsung Galaxy S10 Android 8.1";


    @Test
    public void A_addNewDeviceManuallyAndCheck() throws InterruptedException{
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        homePage.clickOnTools();
        delay(2);
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(3);
        cloudAdvisorPage.goToManageTab();
        cloudAdvisorPage.clickOnSlotButton();
        cloudAdvisorPage.addSlot();
        delay(3);
        cloudAdvisorPage.dismissPopUp();
        delay(3);
        cloudAdvisorPage.goToNextPage();
        delay(3);
        cloudAdvisorPage.checkDeviceIsAdded(DEVICE_ON_MANAGE);
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        delay(1);
        dashboardPage.logOut();
    }


    @Test
    public void B_checkDeviceOnOverviewScreen (){
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        homePage.clickOnTools();
        delay(2);
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(2);
        cloudAdvisorPage.goToNextPage();
        delay(2);
        cloudAdvisorPage.checkDeviceIsAdded(DEVICE_ON_OVERVIEW);
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        dashboardPage.logOut();
    }

    @Test
    public void E_deleteDevice() throws InterruptedException {
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        homePage.clickOnTools();
        delay(2);
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(2);
        cloudAdvisorPage.goToManageTab();
        delay(2);
        cloudAdvisorPage.goToNextPage();
        delay(2);
        cloudAdvisorPage.checkDeviceSlotBeforeDelete(FULL_DEVICE_NAME);
        cloudAdvisorPage.deleteSlot();
        delay(2);
        cloudAdvisorPage.dismissPopUp();
        delay(2);
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        dashboardPage.logOut();
    }

    @Test
    public void tasksArePresent(){
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        homePage.clickOnTools();
        delay(2);
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(2);
        cloudAdvisorPage.goToTasksTab();
        delay(2);
        cloudAdvisorPage.checkTasksTableIsDisplayed();
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        dashboardPage.logOut();
    }

    @Test
    public void C_archiveTask(){
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        homePage.clickOnTools();
        delay(2);
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(2);
        cloudAdvisorPage.goToTasksTab();
        delay(2);
//        cloudAdvisorPage.expandTable();
        cloudAdvisorPage.checkTaskIsPresentInTasksTable(TASK);
        cloudAdvisorPage.archiveTask();
        delay(2);
        cloudAdvisorPage.checkArchivedTaskIsNotInTable(TASK);
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        dashboardPage.logOut();
    }

    @Test
    public void D_restoreTask() {
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        homePage.clickOnTools();
        delay(2);
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(2);
        cloudAdvisorPage.goToArchiveTab();
        delay(2);
        cloudAdvisorPage.restoreTask();
        cloudAdvisorPage.goToTasksTab();
        delay(2);
//        cloudAdvisorPage.expandTable();
        cloudAdvisorPage.checkTaskIsPresentInTasksTable(TASK);
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        dashboardPage.logOut();

    }


    @Test
    public void prioritizeTask(){
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        homePage.clickOnTools();
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(2);
        cloudAdvisorPage.goToTasksTab();
        delay(2);
        cloudAdvisorPage.checkDeviceInFirstRow(DEVICE_NAME);
        cloudAdvisorPage.clickOnDeprioritiseTask();
        delay(2);
        cloudAdvisorPage.checkDeviceInSecondRow(DEVICE_NAME);
        cloudAdvisorPage.clickOnPrioritiseTask();
        delay(2);
        cloudAdvisorPage.checkDeviceInFirstRow(DEVICE_NAME);
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        dashboardPage.logOut();
    }

    @Test
    public void E_completeTask() {
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        homePage.clickOnTools();
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(2);
        cloudAdvisorPage.goToTasksTab();
        delay(2);
        cloudAdvisorPage.clickOnEditButton();
        delay(2);
        cloudAdvisorPage.chooseCompleteTask();
        cloudAdvisorPage.saveChanges();
        delay(2);
        cloudAdvisorPage.checkTaskStatusIsCompleted();
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        dashboardPage.logOut();
    }

    @Test
    public void F_ignoreTask() {
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        homePage.clickOnTools();
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(2);
        cloudAdvisorPage.goToTasksTab();
        delay(2);
        cloudAdvisorPage.clickOnEditButton();
        delay(2);
        cloudAdvisorPage.chooseIgnoreTask();
        delay(2);
        cloudAdvisorPage.saveChanges();
        delay(2);
        cloudAdvisorPage.checkTaskStatusIsIgnored();
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        dashboardPage.logOut();
    }

    @Test
    public void G_delayTask() {
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        homePage.clickOnTools();
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(2);
        cloudAdvisorPage.goToTasksTab();
        delay(2);
        cloudAdvisorPage.clickOnEditButton();
        cloudAdvisorPage.chooseDelayTask();
        delay(2);
        cloudAdvisorPage.setDateInCalendar();
        cloudAdvisorPage.saveChanges();
        delay(2);
        cloudAdvisorPage.checkTaskStatusIsDelayed();
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        dashboardPage.logOut();
    }


    @Test
    public void checkWhenMoreThanFiveDevices(){
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        homePage.clickOnTools();
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(2);
        cloudAdvisorPage.checkOverviewWithMoreThanFiveDevices("5");
        cloudAdvisorPage.goToNextPage();
        delay(2);
        cloudAdvisorPage.checkOverviewWithMoreThanFiveDevices("6");
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        dashboardPage.logOut();
    }

    @Test
    public void editSlot() throws InterruptedException{
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        homePage.clickOnTools();
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(2);
        cloudAdvisorPage.goToManageTab();
        delay(2);
        cloudAdvisorPage.clickOnEditSlotButton();
        delay(2);
        cloudAdvisorPage.changeDeviceModelToNew();
        delay(2);
        cloudAdvisorPage.saveChangesOnSlot();
        delay(2);
        cloudAdvisorPage.dismissPopUp();
        delay(2);
        cloudAdvisorPage.checkDeviceModelIsChanged(NEW_DEVICE_MODEL);
        delay(2);
        cloudAdvisorPage.clickOnEditSlotButton();
        delay(2);
        cloudAdvisorPage.changeDeviceModelToOld();
        delay(2);
        cloudAdvisorPage.saveChangesOnSlot();
        delay(2);
        cloudAdvisorPage.dismissPopUp();
        delay(2);
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        dashboardPage.logOut();
    }

    @Test
    public void checkVisibilityOfAllTabs(){
        User user = User.Tom;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        homePage.clickOnTools();
        delay(2);
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(2);
        cloudAdvisorPage.checkIfAllTabsAreVisible(TABS_NAMES);
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        dashboardPage.logOut();
    }

    @Test
    public void H_uploadFileWithDevices() throws InterruptedException {
        User user = User.Ben;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        delay(2);
        homePage.clickOnTools();
        delay(2);
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(2);
        cloudAdvisorPage.goToManageTab();
        delay(2);
        cloudAdvisorPage.clickOnChooseFile();
        delay(2);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_RIGHT);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        delay(2);
        cloudAdvisorPage.clickOnUpload();
        delay(3);
        cloudAdvisorPage.verifyPopUpAfterUpload();
        cloudAdvisorPage.dismissPopUp();
        delay(2);
        cloudAdvisorPage.checkIfDevicesPresentInTable(CHECK_DEVICE);
        cloudAdvisorPage.verifyWarningMessageIsPresent();
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        dashboardPage.logOut();
    }

    @Test
    public void I_deleteAllDevices(){
        User user = User.Ben;
        homePage.dismissCookiesBanner();
        LoginPage loginPage = homePage.clickOnLoginIcon();
        loginPage.setCorrectLogin(user);
        delay(1);
        loginPage.setCorrectPassword(user);
        delay(1);
        loginPage.clickLoginButton();
        delay(2);
        homePage.openMenu();
        homePage.clickOnTools();
        CloudAdvisorPage cloudAdvisorPage = homePage.clickOnCloudAdvisor();
        delay(2);
        cloudAdvisorPage.goToManageTab();
        delay(2);
        cloudAdvisorPage.clickOnDeleteAllButton();
        delay(2);
        cloudAdvisorPage.verifyPopUpOnDeleteAllDevices();
        delay(2);
        cloudAdvisorPage.agreeOnPopUp();
        delay(2);
        cloudAdvisorPage.checkIfDevicesAbsentInTable(CHECK_DEVICE);
        delay(2);
        DashboardPage dashboardPage = cloudAdvisorPage.goToDashboard();
        dashboardPage.logOut();
    }

 }
