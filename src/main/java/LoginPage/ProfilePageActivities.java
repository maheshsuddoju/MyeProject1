package LoginPage;

import static Naukri.BaseClass.*;
import static ObjectRepository.ProfilePage.*;

public class ProfilePageActivities {

    public static String validateProfilePage() throws InterruptedException {
        try {
            String profileName = waitAndGetText(profile_fullname);;
            System.out.println(profileName);
            return profileName;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "Full Name Not found";
    }


    public static void uploadResume() throws InterruptedException {
        try {
            waitAndScrollToElement(profile_ResumeUpdateBtn);
            waitAndSendText(profile_ResumeUpdateBtn,"src/main/resources/Resume.pdf");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String getUploadResumeFileName() throws InterruptedException {
        try {
            String result = waitAndGetText(profile_ResumeUploadTitle);
            System.out.println(result);
            return result;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "no text found";
    }
}
