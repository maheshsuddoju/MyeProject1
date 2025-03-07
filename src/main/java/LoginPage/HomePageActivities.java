package LoginPage;

import static Naukri.BaseClass.*;
import static ObjectRepository.HomePage.homePage_profileIcon;
import static ObjectRepository.HomePage.homePage_profileName;
import static ObjectRepository.LoginPage.*;
import static ObjectRepository.ProfileSidePanel.sidePanel_profileName;

public class HomePageActivities {

    public static String clickOnProfile() throws InterruptedException {

        try {

            waitAndClick(homePage_profileIcon);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "Haven't clicked on profile icon - Failed";
    }
    public static String clickOnViewAndUpdateProfile() throws InterruptedException {

        try {

            waitAndClick(sidePanel_profileName);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "Haven't clicked on profile icon - Failed";
    }
}
