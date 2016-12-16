package appium.tutorial.android.page;

import static appium.tutorial.android.util.Helpers.find;

/** Page object for the home page **/
public abstract class HomePage {

    /** Verify the home page has loaded.
     *  Click the accessibility button.
     *  Verify the accessibility page has loaded. **/
    public static void emailClick() {
        loaded();
        find("Email").click();
        
    }

    /** Verify the home page has loaded.
     *  Click the animation button.
     *  Verify the animation page has loaded. **/
    public static void passwordClick() {
        loaded();
        find("Password").click();
        
    }
    
    /** Verify the home page has loaded.
     *  Click the animation button.
     *  Verify the animation page has loaded. **/
    public static void loginButtonClick() {
        loaded();
        find("SIGN IN OR REGISTER").click();
        
    }

    /** Verify the home page has loaded **/
    public static void loaded() {
        find("QAbify");
    }
}