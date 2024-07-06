package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        String username = driver.findElement(By.xpath("//i[contains(text(),'rahulshettyacademy')]")).getText();
        String password = driver.findElement(By.xpath("//i[contains(text(),'learning')]")).getText();

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//span[contains(text(), 'User')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.cssSelector("button[id='okayBtn']")).click();
        driver.findElement(By.xpath("//option[contains(text(), 'Consultant')]")).click();
        driver.findElement(By.cssSelector("input[name='terms']")).click();
        driver.findElement(By.id("signInBtn")).click();

        wait.until(ExpectedConditions.titleIs("ProtoCommerce"));
        List <WebElement> products = driver.findElements(By.cssSelector("button[class='btn btn-info']"));

        for(int j = 0; j < products.size(); j++){
            products.get(j).click();
        }
        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();



    }
}
