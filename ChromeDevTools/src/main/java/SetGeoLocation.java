import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

import java.util.*;

public class SetGeoLocation {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:\\Chrome Driver\\chrome-win64\\chrome.exe");

        ChromeDriver driver = new ChromeDriver(co);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> coordinates = new HashMap<>();
        coordinates.put("latitude", 40);
        coordinates.put("longitude", 3);
        coordinates.put("accuracy", 1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

        driver.get("https://google.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div[class='QS5gu sy4vM']")).click();
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
        String title = driver.findElement(By.cssSelector("h1[class=' default-ltr-cache-jmnaey euy28770']")).getText();
        System.out.println(title);

        driver.close();
    }
}
