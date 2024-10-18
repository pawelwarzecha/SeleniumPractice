import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ConsoleLogsCapture {
    public static void main(String[] args) {

        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:\\Chrome Driver\\chrome-win64\\chrome.exe");

        ChromeDriver driver = new ChromeDriver(co);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.partialLinkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.linkText("Cart")).click();
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");

        LogEntries entry =  driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = entry.getAll();

        for(LogEntry e : logs){
            System.out.println(e.getMessage());
        }
    }
}
