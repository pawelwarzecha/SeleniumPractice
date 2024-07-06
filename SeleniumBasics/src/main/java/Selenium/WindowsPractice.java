package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowsPractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentID = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        String email = driver.findElement(By.xpath("//a[contains(text(), '@')]")).getText();
        System.out.println(email);
        driver.switchTo().window(parentID);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("learning");
        driver.findElement(By.xpath("//span[contains(text(), 'User')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.cssSelector("button[id='okayBtn']")).click();
        driver.findElement(By.xpath("//option[contains(text(), 'Consultant')]")).click();
        driver.findElement(By.cssSelector("input[name='terms']")).click();
        driver.findElement(By.id("signInBtn")).click();

    }
}
