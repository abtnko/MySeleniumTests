package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ValidationTest extends BaseTests{

    private WebDriver driver;

    public ValidationTest (WebDriver driver) {
        this.driver = driver;
    }

    private final static String VALIDATION_PATH = "/Users/annabutenko/IdeaProjects/InsightPortal-DesktopSafari/Validations";

    public void captureScreenShots() throws IOException {
        String folderName=VALIDATION_PATH;
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //create dir with given folder name
        new File(folderName).mkdir();
        //Setting file name
        String fileName = (Thread.currentThread().getStackTrace()[2].getMethodName() + ".png");
        //coppy screenshot file into screenshot folder.
        FileUtils.copyFile(f,new File(folderName + "/" + fileName));
    }
}
