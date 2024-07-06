package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLoc {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox = driver.findElement(By.xpath("//div/input[@name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
        WebElement dateOfBirth = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
        System.out.println(driver.findElement(with(By.tagName("input")).below(dateOfBirth)).getAttribute("Value"));
        WebElement checkBox = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(checkBox)).click();
        WebElement label = driver.findElement(By.xpath("//label[text()='Student']"));
        driver.findElement(with(By.tagName("input")).toRightOf(label)).click();;
    }
}