import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v128.network.Network;

import java.util.Optional;

public class BlockNetworkRequests {
    public static void main(String[] args) {

        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:\\Chrome Driver\\chrome-win64\\chrome.exe");

        ChromeDriver driver = new ChromeDriver(co);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));
        long startTime = System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector(".nav-link[routerlink='/products']")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        System.out.println(driver.findElement(By.cssSelector("p")).getText());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

    }
}
