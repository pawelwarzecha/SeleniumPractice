package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        Actions a = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        a.dragAndDrop(source, target).build().perform();
        driver.switchTo().defaultContent();


    }

}