import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

public class NetworkSpeed {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:\\Chrome Driver\\chrome-win64\\chrome.exe");

        ChromeDriver driver = new ChromeDriver(co);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET)));

        devTools.addListener(Network.loadingFailed(), loadingFailed ->
        {
            System.out.println("Loading failed: " + loadingFailed.getErrorText());
            System.out.println("Timestamp: " + loadingFailed.getTimestamp());
        });

        long startTime = System.currentTimeMillis();
        driver.get("https://google.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='L2AGLb'] div[role='none']")));
        driver.findElement(By.cssSelector("button[id='L2AGLb'] div[role='none']")).click();
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
        String title = driver.findElement(By.cssSelector("h1[class=' default-ltr-cache-jmnaey euy28770']")).getText();
        System.out.println(title);
//        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
//        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        driver.close();
    }
}
