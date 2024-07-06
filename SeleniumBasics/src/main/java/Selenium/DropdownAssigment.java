package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropdownAssigment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("uni");
        Actions a = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='ui-id-7']")));
        a.moveToElement(driver.findElement(By.cssSelector("div[id='ui-id-7']"))).click().build().perform();
        System.out.println(driver.findElement(By.cssSelector("input[id='autocomplete']")).getAttribute("value"));

    }
}
