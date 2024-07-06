package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeActions {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        Actions a = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Smile"));

        WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("laptop").doubleClick().build().perform();

        a.moveToElement(move).contextClick().build().perform();


    }
}