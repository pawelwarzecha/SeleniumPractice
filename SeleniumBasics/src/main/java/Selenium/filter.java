package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class filter {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String name = ("Rice");
        driver.findElement(By.cssSelector("input[type='search']")).sendKeys(name);
        List<WebElement> vegetables = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> filteredList = vegetables.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
        Assert.assertEquals(vegetables.size(), filteredList.size());
    }
}
