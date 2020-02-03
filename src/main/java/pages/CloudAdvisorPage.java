package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CloudAdvisorPage {

    private WebDriver driver;
    private By manageTab = By.xpath("//span[contains(text(), 'Manage')]");
    private By addSlotButton = By.className("add-slot-buttonq");
    private By dropDownBox = By.xpath("//div[@id='select-box']");
    private By deviceBrand = By.xpath("//*[@title='Alcatel']");
    private By deviceModel = By.xpath("//*[@title='U5']");
    private By os = By.xpath("//*[@title='Android 9.1']");
    private By addSlot = By.xpath("//input[@value='Accept']");
    private By popUp = By.xpath("//button[contains(text(), 'OK')]");
    private By nextPage = By.xpath("//input[@value='>']");
    private By table = By.className("table-parent");
    private By deleteButton = By.xpath("//table/descendant::i[last()]");
    private By tasksTab = By.xpath("//span[contains(text(), 'Task Generator')]");
    private By tasksTable = By.id("task-table-container");
    private By archiveButton = By.xpath("//*[@id='task'][last()]/td[6]/div[1]/div[5]");
    private By archiveTab = By.xpath("//span[contains(text(), 'Archive')]");
    private By showMore = By.id("show-more");
    private By restoreButton = By.xpath("//div[@title='Restore Task']");
    private By firstRow = By.xpath("//tr[@id='task'][1]");
    private By secondRow = By.xpath("//tr[@id='task'][2]");
    private By deprioritiseTask = By.xpath("//div/ancestor::td/div[1]/div[3]");
    private By prioritiseTask = By.xpath("//table/tr[3]/child::td[6]/div[1]/div[2]");
    private By editButton = By.xpath("//div[@title='Edit Task']");
    private By completeTask = By.xpath("//*[@id=\"edit-action\"]/select/option[2]");
    private By delayTask = By.xpath("//*[@id=\"edit-action\"]/select/option[4]");
    private By ignoreTask = By.xpath("//*[@id=\"edit-action\"]/select/option[3]");
    private By saveButton = By.xpath("//button[contains(text(), 'Save')]");
    private By taskStatus = By.className("task-status-default");
    private By calendar = By.xpath("//input[@placeholder='Select start date']");
    private By editSlotButton = By.xpath("//i[@class ='glyphicon glyphicon-pencil']");
    private By okButton = By.xpath("//i[@class ='glyphicon glyphicon-ok']");
    private By newDeviceMode = By.xpath("//*[@title='Galaxy S10']");
    private By oldDeviceModel = By.xpath("//*[@title='Galaxy S9']");
    private By insightPortalLogo = By.xpath("//img[@class='logo']");
    private By allTabs = By.className("span-parent");
    private By chooseFile = By.id("slot-upload-file");
    private By uploadButton = By.xpath("//input[@value='Upload']");
    private By errorMessageOnUpload = By.className("warnings-title");
    private By warningMessage = By.className("warnings-title");
    private By deleteAllButton = By.xpath("//button[contains(text(), ' Delete All')]");
    private By popUpOnDeleteAll = By.xpath("//h2[contains(text(), 'Are you sure?')]");
    private By yesButton = By.xpath("//button[contains(text(), 'Yes')]");
    private By popUpOnUploadFile = By.xpath("//h2[contains(text(), 'Select uploading type')]");
    private By updateButton = By.xpath("//button[contains(text(), 'Update')]");

    public void checkIfPopUpOnUploadFleIsPresent(){
        driver.findElement(popUpOnUploadFile).isDisplayed();
    }

    public void clickOnUpdateButton(){
        driver.findElement(updateButton).click();
    }

    public CloudAdvisorPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnDeleteAllButton(){
        driver.findElement(deleteAllButton).click();
    }
    public void verifyWarningMessageIsPresent(){
        Assert.assertTrue(driver.findElement(warningMessage).getText().contains("Devices that couldn't be recognized:"));
    }

    public void verifyPopUpOnDeleteAllDevices(){
        Assert.assertTrue(driver.findElement(popUpOnDeleteAll).isDisplayed());
    }

    public void agreeOnPopUp(){
        driver.findElement(yesButton).click();
    }

    public void checkIfDevicesAbsentInTable(String deviceName){
        List<WebElement> allArticles = driver.findElements(tasksTable);
        for (WebElement article : allArticles) {
            String taskName = article.getText();
            Assert.assertFalse(taskName.contains(deviceName));
        }
    }

    public void checkIfDevicesPresentInTable(String deviceName){
        List<WebElement> allArticles = driver.findElements(tasksTable);
        for (WebElement article : allArticles) {
            String taskName = article.getText();
            Assert.assertTrue(taskName.contains(deviceName));
        }
    }
    public void clickOnChooseFile(){
        driver.findElement(chooseFile).sendKeys("/Users/annabutenko/IdeaProjects/upload_file_with_wrong_device.csv");
    }

    public void clickOnUpload() {
        driver.findElement(uploadButton).click();
    }

    public void verifyErrorMessageAfterUpload(){
        Assert.assertTrue(driver.findElement(errorMessageOnUpload).isDisplayed());
    }

    public void checkIfAllTabsAreVisible(String tabsNames){
        System.out.println(driver.findElement(allTabs).getText());
        Assert.assertTrue(driver.findElement(allTabs).getText().contains(tabsNames));
    }

    public void clickOnEditSlotButton(){
        driver.findElements(editSlotButton).get(1).click();
    }

    public void changeDeviceModelToNew() throws InterruptedException{
        driver.findElements(dropDownBox).get(2).click();
        Thread.sleep(2000);
        driver.findElement(newDeviceMode).click();
        Thread.sleep(2000);
    }


    public void changeDeviceModelToOld() throws InterruptedException{
        driver.findElements(dropDownBox).get(2).click();
        Thread.sleep(2000);
        driver.findElement(oldDeviceModel).click();
        Thread.sleep(2000);
    }

    public void checkDeviceModelIsChanged(String model){
        List<WebElement> allArticles = driver.findElements(tasksTable);
        for (WebElement article : allArticles) {
            String taskName = article.getText();
            Assert.assertTrue(taskName.contains(model));
        }
    }



    public void saveChangesOnSlot(){
        driver.findElement(okButton).click();
    }

    public void goToManageTab(){
        driver.findElement(manageTab).click();
    }

    public void goToTasksTab(){
        driver.findElement(tasksTab).click();
    }

    public void checkOverviewWithMoreThanFiveDevices(String numberOfDevices){
        List<WebElement> allArticles = driver.findElements(tasksTable);
        for (WebElement article : allArticles) {
            String taskName = article.getText();
            Assert.assertTrue(taskName.contains(numberOfDevices));
        }
    }
    public void setDateInCalendar(){
        driver.findElement(calendar).clear();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentDay = dateFormat.format(date);
        driver.findElement(calendar).sendKeys(currentDay + Keys.ENTER);
    }

    public void checkTaskStatusIsDelayed(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentDay = dateFormat.format(date);
        Assert.assertTrue(driver.findElements(taskStatus).get(3).getText().contains(currentDay));
    }

    public void goToArchiveTab(){
        driver.findElement(archiveTab).click();
    }

    public void clickOnDeprioritiseTask(){
        driver.findElement(deprioritiseTask).click();
    }

    public void clickOnPrioritiseTask(){
        driver.findElement(prioritiseTask).click();
    }

    public void clickOnEditButton(){
        driver.findElements(editButton).get(3).click();
    }
    public void chooseCompleteTask(){
        driver.findElement(completeTask).click();
    }

    public void chooseIgnoreTask(){
        driver.findElement(ignoreTask).click();
    }

    public void chooseDelayTask(){
        driver.findElement(delayTask).click();
    }
    public void checkTaskStatusIsCompleted(){
        Assert.assertTrue(driver.findElements(taskStatus).get(3).getText().contains("COMPLETED"));
    }

    public void checkTaskStatusIsIgnored(){
        Assert.assertTrue(driver.findElements(taskStatus).get(3).getText().contains("IGNORED"));
    }


    public void saveChanges(){
        driver.findElement(saveButton).click();
    }

    public void expandTable(){
        driver.findElement(showMore).click();
    }

    public void checkDeviceInFirstRow(String deviceName){
//        String deviceInFirstRow = driver.findElement(firstRow).getText();
        Assert.assertTrue(driver.findElement(firstRow).getText().contains(deviceName));
    }

    public void checkDeviceInSecondRow(String deviceName){
//        String deviceInSecondRow = driver.findElement(secondRow).getText();
        Assert.assertTrue(driver.findElement(secondRow).getText().contains(deviceName));
    }


    public void checkTasksTableIsDisplayed(){
        Assert.assertTrue(driver.findElement(tasksTable).isDisplayed());
    }

    public void checkTaskIsPresentInTasksTable(String task){
        List<WebElement> allArticles = driver.findElements(tasksTable);
        for (WebElement article : allArticles) {
            String taskName = article.getText();
            System.out.println(taskName);
            Assert.assertTrue(taskName.contains(task));
        }
    }

    public void restoreTask(){
        driver.findElement(restoreButton).click();
    }

    public void archiveTask(){
        driver.findElement(archiveButton).click();
    }

    public void checkArchivedTaskIsNotInTable (String task){
        List<WebElement> allArticles = driver.findElements(tasksTable);
        for (WebElement article : allArticles) {
            article.getText();
            Assert.assertFalse(article.getText().contains(task));
        }
    }

    public void clickOnSlotButton(){
        driver.findElement(addSlotButton).click();
    }

    public void addSlot() throws InterruptedException{
        driver.findElements(dropDownBox).get(1).click();
        Thread.sleep(2000);
        driver.findElement(deviceBrand).click();
        Thread.sleep(2000);
        driver.findElements(dropDownBox).get(2).click();
        Thread.sleep(2000);
        driver.findElement(deviceModel).click();
        Thread.sleep(2000);
        driver.findElements(dropDownBox).get(3).click();
        Thread.sleep(2000);
        driver.findElement(os).click();
        Thread.sleep(2000);
        driver.findElements(dropDownBox).get(4).click();
        Thread.sleep(2000);
        driver.findElement(addSlot).click();
        Thread.sleep(2000);
    }

    public void dismissPopUp()throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(popUp).click();
    }

    public void goToNextPage(){
        driver.findElement(nextPage).click();
    }

    public void checkDeviceIsAdded(String deviceName){
        List<WebElement> allArticles = driver.findElements(table);
        for (WebElement article : allArticles) {
            String name = article.getText();
            System.out.println(name);
            Assert.assertTrue(name.contains(deviceName));
        }

    }

    public void checkDeviceSlotBeforeDelete(String fullDeviceName){
        List<WebElement> allArticles = driver.findElements(table);
        for (WebElement article : allArticles) {
            String name = article.getText();
            Assert.assertTrue(name.contains(fullDeviceName));
        }
    }

    public void deleteSlot() {
        driver.findElement(deleteButton).click();
    }

    public DashboardPage goToDashboard(){
        driver.findElement(insightPortalLogo).click();
        return new DashboardPage(driver);
    }
}
