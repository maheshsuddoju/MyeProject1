package CommonUtils;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenShot {

        public static String captureScreenshot(WebDriver driver, String screenshotName) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = "src/test/resources/screenshots/" + screenshotName + "_" + timestamp + ".jpeg";
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileHandler.copy(srcFile, new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return filePath;
        }

    public static String captureElementScreenshot(WebDriver driver, WebElement webElement, String screenshotName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = "src/test/resources/screenshots/" + screenshotName + "_" + timestamp + ".jpeg";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Point point = webElement.getLocation();
            int elementWidth = webElement.getSize().getWidth();
            int elementHeight = webElement.getSize().getHeight();
            
            // Crop the full-page screenshot to the element's size
            BufferedImage fullImg = ImageIO.read(screenshot);
            BufferedImage elementScreenshot = fullImg.getSubimage(point.getX(), point.getY(), elementWidth, elementHeight);
            ImageIO.write(elementScreenshot, "png", screenshot);
            FileHandler.copy(screenshot, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
    }


