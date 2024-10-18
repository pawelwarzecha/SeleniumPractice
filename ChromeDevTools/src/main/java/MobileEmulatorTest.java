import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.Optional;

public class MobileEmulatorTest {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:\\Chrome Driver\\chrome-win64\\chrome.exe");

        ChromeDriver driver = new ChromeDriver(co);

        DevTools devTools = driver.getDevTools();

        devTools.createSession();

        devTools.send(Emulation.setDeviceMetricsOverride(768, 1024, 50, true,
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Library")).click();
    }
}
