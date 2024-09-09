import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class RSATest {

    @Test
    public void HomePageCheck() throws MalformedURLException, URISyntaxException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        //caps.setPlatform(Platform);
        //caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        //caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");

        WebDriver driver = new RemoteWebDriver(new URI("http://10.19.111.16:4444").toURL(), caps);
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
