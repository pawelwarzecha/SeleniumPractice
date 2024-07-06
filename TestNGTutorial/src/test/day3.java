package test;

import jdk.jfr.DataAmount;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {

    @Parameters({"URL"})
    @Test
    public void WebLoginCarLoan(String urlname) {
        System.out.println("weblogincar");
        System.out.println(urlname);
    }

    @Test(groups = {"smoke"})
    public void MobileLoginCarLoan() {
        System.out.println("mobilelogincar");
    }

    @Test(enabled = false)
    public void MobileSignInCarLoan() {
        System.out.println("mobilesignincar");
    }

    @Test(dataProvider = "getData")
    public void MobileSignOutCarLoan(String username, String password) {
        System.out.println("mobilesignoutcar");
        System.out.println(username);
        System.out.println(password);
    }

    @Test(dependsOnMethods = {"WebLoginCarLoan"})
    public void APICarLoan() {
        System.out.println("APIlogincar");
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[3][2];
        data[0][0] = "firstsetusername";
        data[0][1] = "password";

        data[1][0] = "secondsetusername";
        data[1][1] = "secondpassword";

        data[2][0] = "thirdsetusername";
        data[2][1] = "thirdpassword";
        return data;
    }
}
