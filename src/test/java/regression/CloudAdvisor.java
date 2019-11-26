package regression;

import base.TestBase;
import model.User;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CloudAdvisor extends TestBase {

    @Test
    public void A_addNewDeviceManually(){
        User user = User.Tom;
        logIn(user);
        driver.findElement(By.className("tools")).click();
        delay(5);
        driver.findElement(By.xpath("//div[contains(text(), 'CloudAdvisor')]")).click();
        delay(3);
        driver.findElement(By.xpath("//span[contains(text(), 'Manage')]")).click();
        delay(1);
        driver.findElement(By.className("add-slot-buttonq")).click();
        driver.findElements(By.id("over-select")).get(1).click();
        delay(1);
        driver.findElement(By.xpath("//*[@title='Alcatel']")).click();
        driver.findElements(By.id("over-select")).get(2).click();
        delay(1);
        driver.findElement(By.xpath("//*[@title='U5']")).click();
        driver.findElements(By.id("over-select")).get(3).click();
        delay(1);
        driver.findElement(By.xpath("//*[@title='Android 9.1']")).click();
        driver.findElements(By.id("over-select")).get(4).click();
        delay(1);
        driver.findElement(By.xpath("//*[@title='Opera 63']")).click();
        driver.findElement(By.className("add-slot-button")).click();
        driver.findElement(By.className("add-slot-button")).click();
        delay(2);
        driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
        System.out.println("Device is added");
        delay(3);
    }

    @Test
    public void B_checkDeviceOnManageScreen (){
        User user = User.Tom;
        logIn(user);
        driver.findElement(By.className("tools")).click();
        delay(3);
        driver.findElement(By.xpath("//div[contains(text(), 'CloudAdvisor')]")).click();
        delay(3);
        driver.findElement(By.xpath("//span[contains(text(), 'Manage')]")).click();
        delay(3);
        driver.findElement(By.xpath("//*[@id=\"cloudadvisor-container\"]/div[2]/div/div[3]/input[2]")).click();
        delay(2);
        String device = "Alcatel";
        List<WebElement> allArticles2 = driver.findElements(By.className("table-parent"));
        for (WebElement article : allArticles2) {
            String name = article.getText();
            System.out.println(name);
            Assert.assertTrue(name.contains(device));
        }
        delay(3);
    }

    @Test
    public void C_checkDeviceOnOverviewScreen (){
        User user = User.Tom;
        logIn(user);
        driver.findElement(By.className("tools")).click();
        delay(3);
        driver.findElement(By.xpath("//div[contains(text(), 'CloudAdvisor')]")).click();
        delay(3);
        driver.findElement(By.xpath("//*[@id=\"cloudadvisor-container\"]/div[2]/div[2]/div[2]/input[2]")).click();
        delay(2);
        String device = "Alcatel U5";
        List<WebElement> allArticles2 = driver.findElements(By.className("table-parent"));
        for (WebElement article : allArticles2) {
            String name = article.getText();
            System.out.println(name);
            Assert.assertTrue(name.contains(device));
        }
        delay(3);
    }

    @Test
    public void D_deleteDevice() {
        User user = User.Tom;
        logIn(user);
        driver.findElement(By.className("tools")).click();
        delay(2);
        driver.findElement(By.xpath("//div[contains(text(), 'CloudAdvisor')]")).click();
        delay(2);
        driver.findElement(By.xpath("//span[contains(text(), 'Manage')]")).click();
        delay(2);
        driver.findElement(By.xpath("//*[@id=\"cloudadvisor-container\"]/div[2]/div/div[3]/input[2]")).click();
        delay(3);
//        Deleting device, but before checking if deleting correct row
        String device = "7 Alcatel U5 Android 9.1  63";
        List<WebElement> allArticles = driver.findElements(By.xpath("//*[@id=\"cloudadvisor-container\"]/div[2]/div/div[2]/table/tr[2]"));
        for (WebElement article : allArticles) {
            String name = article.getText();
            Assert.assertTrue(name.contains(device));
        }
        driver.findElement(By.xpath("//*[@id=\"cloudadvisor-container\"]/div[2]/div/div[2]/table/tr[2]/td[6]/tr[2]/button")).click();
        delay(3);
        driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
        String device2 = "Alcatel";
        List<WebElement> allArticles2 = driver.findElements(By.className("table-parent"));
        for (WebElement article : allArticles2) {
            String name = article.getText();
            Assert.assertFalse(name.contains(device2));
        }
        delay(3);
    }

    @Test
    public void tasksArePresent(){
        User user = User.Tom;
        logIn(user);
        driver.findElement(By.className("tools")).click();
        delay(2);
        driver.findElement(By.xpath("//div[contains(text(), 'CloudAdvisor')]")).click();
        delay(2);
        driver.findElement(By.xpath("//div[contains(text(), 'Task Generator')]")).click();
        delay(2);
        Assert.assertTrue(driver.findElement(By.className("task-table-container")).isDisplayed());

    }

    @Test
    public void archiveAndRestoreTask(){
        User user = User.Tom;
        logIn(user);
        driver.findElement(By.className("tools")).click();
        delay(2);
        driver.findElement(By.xpath("//div[contains(text(), 'CloudAdvisor')]")).click();
        delay(2);
        driver.findElement(By.xpath("//span[contains(text(), 'Task Generator')]")).click();
        delay(2);
        String device = "LG Q7 1 Replace with Huawei P20 on Android 8.1 2019-12-19";
        List<WebElement> allArticles = driver.findElements(By.id("task-table-container"));
        for (WebElement article : allArticles) {
            String name = article.getText();
            Assert.assertTrue(name.contains(device));
        }
        driver.findElement(By.xpath("//div[@title='Archive Task']")).click();
        delay(2);
        for (WebElement article : allArticles) {
            String name = article.getText();
            Assert.assertFalse(name.contains(device));
        }
        driver.findElement(By.xpath("//span[contains(text(), 'Archive')]")).click();
        delay(2);
        driver.findElement(By.xpath("//div[@title='Restore Task']")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Task Generator')]")).click();
        delay(2);
        List<WebElement> allArticles2 = driver.findElements(By.id("task-table-container"));
        for (WebElement article : allArticles2) {
            String name = article.getText();
            Assert.assertTrue(name.contains(device));
        }
    }

    @Test
    public void prioritizeTask(){
        User user = User.Tom;
        logIn(user);
        driver.findElement(By.className("tools")).click();
        delay(2);
        driver.findElement(By.xpath("//div[contains(text(), 'CloudAdvisor')]")).click();
        delay(2);
        driver.findElement(By.xpath("//span[contains(text(), 'Task Generator')]")).click();
        delay(2);
        String exp1 = "1. LG Q7 1 Replace with Huawei P20 on Android 8.1 2019-12-19";
        String act = driver.findElements(By.id("task")).get(0).getText();
        System.out.println(act);
        Assert.assertTrue(driver.findElements(By.id("task")).get(0).getText().equals(exp1));
        driver.findElement(By.xpath("//div[@title='Deprioritise Task']")).click();
        String exp2 = "1. ZTE T6 2 Replace with Huawei P20 on Android 8.1 2019-12-19";
        Assert.assertTrue(driver.findElements(By.id("task")).get(0).getText().equals(exp2));
        driver.findElements(By.xpath("//div[@title='Prioritise Task']")).get(1).click();
        Assert.assertTrue(driver.findElements(By.id("task")).get(0).getText().equals(exp1));
    }

    @Test
    public void E_completeTask() {
        User user = User.Tom;
        logIn(user);
        driver.findElement(By.className("tools")).click();
        delay(2);
        driver.findElement(By.xpath("//div[contains(text(), 'CloudAdvisor')]")).click();
        delay(2);
        driver.findElement(By.xpath("//span[contains(text(), 'Task Generator')]")).click();
        delay(2);
        System.out.println("Before Complete: " + driver.findElements(By.id("task")).get(0).getText());
        driver.findElements(By.xpath("//div[@title='Edit Task']")).get(0).click();
        delay(2);
        driver.findElement(By.xpath("//*[@id=\"edit-action\"]/select/option[2]")).click();
        delay(2);
        driver.findElement(By.xpath("//button[contains(text(), 'Save')]")).click();
        delay(3);
        System.out.println("After Complete: " + driver.findElements(By.id("task")).get(0).getText());
        Assert.assertTrue(driver.findElements(By.id("task")).get(0).getText().equals("1. Huawei P20 2 Replace with Huawei P20 on Android 8.1 COMPLETED      "));

    }

    @Test
    public void F_ignoreTask() {
        User user = User.Tom;
        logIn(user);
        driver.findElement(By.className("tools")).click();
        delay(2);
        driver.findElement(By.xpath("//div[contains(text(), 'CloudAdvisor')]")).click();
        delay(2);
        driver.findElement(By.xpath("//span[contains(text(), 'Task Generator')]")).click();
        delay(2);
        System.out.println("Before ignore: " + driver.findElements(By.id("task")).get(0).getText());
        driver.findElements(By.xpath("//div[@title='Edit Task']")).get(0).click();
        delay(2);
        driver.findElement(By.xpath("//*[@id=\"edit-action\"]/select/option[3]")).click();
        delay(2);
        driver.findElement(By.xpath("//input[@placeholder='Enter a comment...']")).sendKeys("Postponed");
        driver.findElement(By.xpath("//button[contains(text(), 'Save')]")).click();
        delay(2);
        System.out.println("After ignore: " + driver.findElements(By.id("task")).get(0).getText());
        Assert.assertTrue(driver.findElements(By.id("task")).get(0).getText().equals("1. Huawei P20 2 Replace with Huawei P20 on Android 8.1 IGNORED      "));
    }

    @Test
    public void G_delayTask() {
        User user = User.Tom;
        logIn(user);
        driver.findElement(By.className("tools")).click();
        delay(2);
        driver.findElement(By.xpath("//div[contains(text(), 'CloudAdvisor')]")).click();
        delay(2);
        driver.findElement(By.xpath("//span[contains(text(), 'Task Generator')]")).click();
        delay(2);
        System.out.println("Before delay: " + driver.findElements(By.id("task")).get(0).getText());
        driver.findElements(By.xpath("//div[@title='Edit Task']")).get(0).click();
        delay(2);
        driver.findElement(By.xpath("//*[@id=\"edit-action\"]/select/option[4]")).click();
        delay(2);
        WebElement selectDate = driver.findElement(By.xpath("//input[@placeholder='Select start date']"));
        selectDate.clear();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentDay = dateFormat.format(date);
        System.out.println(currentDay);
        selectDate.sendKeys(currentDay + Keys.ENTER);
        delay(2);
        driver.findElement(By.xpath("//button[contains(text(), 'Save')]")).click();
        delay(2);
        System.out.println("After delay: " + driver.findElements(By.id("task")).get(0).getText());
        Assert.assertTrue(driver.findElements(By.id("task")).get(0).getText().equals("1. Huawei P20 2 Replace with Huawei P20 on Android 8.1 " + currentDay + "      "));
    }


    @Test
    public void checkWhenMoreThanFiveDevices(){
        User user = User.Tom;
        logIn(user);
        driver.findElement(By.className("tools")).click();
        delay(2);
        driver.findElement(By.xpath("//div[contains(text(), 'CloudAdvisor')]")).click();
        delay(2);
        String allDevicesOnPageOne = "SlotDeviceMarket share 1  LG Q7 Android 8.1 0.06%2  ZTE T6 Android 6.1 no data3  SonyEricsson Xperia X10 Android 9.0 no data4  BlackBerry Evolve X Android 9.0 no data5  Samsung Galaxy S7 Android 7.1 no data";
        List<WebElement> allArticles = driver.findElements(By.className("slots-data-table"));
        for (WebElement article : allArticles) {
            String name = article.getText();
            System.out.println(name);
            Assert.assertTrue(name.contains(allDevicesOnPageOne));
        }
        driver.findElement(By.xpath("//*[@id=\"cloudadvisor-container\"]/div[2]/div[2]/div[2]/input[2]")).click();
        delay(3);
        String allDevicesOnPageTwo = "SlotDeviceMarket share 6  BlackBerry Key 2 Android 9.0 no data";
        for (WebElement article : allArticles) {
            String name = article.getText();
            System.out.println(name);
            Assert.assertTrue(name.contains(allDevicesOnPageTwo));
        }
    }

    @Test
    public void editSlot(){
        User user = User.Tom;
        logIn(user);
        driver.findElement(By.className("tools")).click();
        delay(2);
        driver.findElement(By.xpath("//div[contains(text(), 'CloudAdvisor')]")).click();
        delay(2);
        driver.findElement(By.xpath("//span[contains(text(), 'Manage')]")).click();
        delay(2);
        Assert.assertTrue(driver.findElements(By.className("model-table")).get(0).getText().equals("Q7"));
        driver.findElement(By.xpath("//*[@id=\"cloudadvisor-container\"]/div[2]/div/div[2]/table/tr[1]/td[6]/tr[1]/button")).click();
        delay(2);
        driver.findElements(By.id("over-select")).get(2).click();
        delay(1);
        driver.findElement(By.xpath("//*[@title='X4']")).click();
        driver.findElement(By.xpath("//*[@id=\"cloudadvisor-container\"]/div[2]/div/div[2]/table/tr[1]/td[6]/tr[1]/button")).click();
        delay(2);
        driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
        Assert.assertTrue(driver.findElements(By.className("model-table")).get(0).getText().equals("X4"));
        delay(2);
        driver.findElement(By.xpath("//*[@id=\"cloudadvisor-container\"]/div[2]/div/div[2]/table/tr[1]/td[6]/tr[1]/button")).click();
        delay(2);
        driver.findElements(By.id("over-select")).get(2).click();
        delay(1);
        driver.findElement(By.xpath("//*[@title='Q7']")).click();
        driver.findElement(By.xpath("//*[@id=\"cloudadvisor-container\"]/div[2]/div/div[2]/table/tr[1]/td[6]/tr[1]/button")).click();
        delay(2);
        driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();

    }


 }
