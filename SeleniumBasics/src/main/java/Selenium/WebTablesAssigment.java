package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTablesAssigment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> columns = driver.findElements(By.cssSelector(".table-display th"));
        System.out.println(columns.size());
        List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr "));
        System.out.println(rows.size());
        System.out.println(rows.get(2).getText());
    }
}
