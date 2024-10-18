import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class CdpCommands {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:\\Chrome Driver\\chrome-win64\\chrome.exe");

        ChromeDriver driver = new ChromeDriver(co);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        Map deviceMetrics = new HashMap();
        deviceMetrics.put("width", 768);
        deviceMetrics.put("height", 1024);
        deviceMetrics.put("deviceScaleFactor", 50);
        deviceMetrics.put("mobile", true);

        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Library")).click();
    }
}
