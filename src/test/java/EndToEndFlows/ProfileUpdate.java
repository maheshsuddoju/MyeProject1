package EndToEndFlows;

import Base.BaseTest;
import CommonUtils.DataProviderClass;
import CommonUtils.PropertyReader;

import LoginPage.LoginPageActivities;
import Naukri.BaseClass;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static LoginPage.HomePageActivities.clickOnProfile;
import static LoginPage.HomePageActivities.clickOnViewAndUpdateProfile;
import static LoginPage.LoginPageActivities.login;
import static LoginPage.ProfilePageActivities.*;

public class ProfileUpdate {
    static String naukriUrl = PropertyReader.getProperty("baseUrl");
    static String username = PropertyReader.getProperty("username");
    static String password = PropertyReader.getProperty("password");

    BaseClass baseClass = new BaseClass();
    BaseTest baseTest = new BaseTest();


    @BeforeMethod
    public void beforeTest(){
        baseClass.setupDriver();
        baseClass.getUrl(naukriUrl);
    }



    @Test(description="Updating Resume")
    public static void updateNewResume() throws InterruptedException {
        login(username,password);
        clickOnProfile();
        clickOnViewAndUpdateProfile();
        validateProfilePage();
        uploadResume();
        Thread.sleep(5000);
        Assert.assertEquals(getUploadResumeFileName(),"Resume.pdf");

    }

    @AfterMethod
    public void afterTest(ITestResult result){
        baseTest.tearDown(result);
    }
}
