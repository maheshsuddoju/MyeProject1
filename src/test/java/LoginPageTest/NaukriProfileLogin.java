//package LoginPageTest;
//
//import Base.BaseTest;
//import CommonUtils.DataProviderClass;
//import CommonUtils.PropertyReader;
//import CommonUtils.TakeScreenShot;
//import LoginPage.LoginPageActivities;
//import Naukri.BaseClass;
//import io.qameta.allure.Attachment;
//import junit.runner.BaseTestRunner;
//import org.testng.Assert;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//
//import static Naukri.BaseClass.driver;
//
//
//
//public class NaukriProfileLogin  {
//
//    static String naukriUrl =PropertyReader.getProperty("baseUrl");
//    BaseClass baseClass = new BaseClass();
//    BaseTest baseTest = new BaseTest();
//
//    @BeforeTest
//    public void beforeTest(){
//        baseClass.setupDriver();
//        baseClass.getUrl(naukriUrl);
//    }
//
//
//    @Test(dataProvider = "csvDataProvider", dataProviderClass = DataProviderClass.class)
//    public static void LoginToNaukri(String username,String password) throws InterruptedException {
//        Assert.assertEquals(LoginPageActivities.login(username.replaceAll("^\"|\"$", "").trim(), password.replaceAll("^\"|\"$", "").trim()),"Mahesh Suddoju");
//
//    }
//
//    @AfterMethod
//    public void afterTest(ITestResult result){
//        baseTest.tearDown(result);
//    }
//
//
//
//
//}
