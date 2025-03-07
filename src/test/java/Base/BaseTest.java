package Base;

import CommonUtils.TakeScreenShot;
import LoginPage.LoginPageActivities;
import Naukri.BaseClass;
import io.qameta.allure.Attachment;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static Naukri.BaseClass.driver;

public class BaseTest {



    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            String screenshotPath = TakeScreenShot.captureScreenshot(driver, result.getName());
            attachScreenshotToAllure(screenshotPath);

        }
        if (driver != null) {
            driver.quit();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshotToAllure(String path) {
        try {
            return Files.readAllBytes(new File(path).toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Attachment(value = "Element Screenshot", type = "image/png")
    public byte[] attachElementScreenshotToAllure(String path) {
        try {
            return Files.readAllBytes(new File(path).toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
