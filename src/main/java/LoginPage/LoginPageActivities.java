package LoginPage;

import Naukri.BaseClass;
import ObjectRepository.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Naukri.BaseClass.*;
import static ObjectRepository.HomePage.*;
import static ObjectRepository.LoginPage.*;

public class LoginPageActivities  {

    public static String login(String UserName, String Password) throws InterruptedException {
        String profileName;
        try {
            waitAndSendText(loginPage_userName, UserName);
            waitAndSendText(loginPage_password, Password);
            waitAndClick(loginPage_loginBtn);
            profileName = waitAndGetText(homePage_profileName);
            System.out.println(profileName);
            return profileName;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "Login Failed";
    }
}
