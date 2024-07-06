package test;

import org.testng.annotations.Test;

public class day4 {
    @Test
    public void WebLoginHomeLoan() {
        System.out.println("webloginhome");
    }
    @Test(groups={"smoke"})
    public void MobileLoginHomeLoan() {
        System.out.println("mobileloginhome");
    }

    @Test
    public void LoginAPIHomeLoan() {
        System.out.println("webloginhome");
    }
}
