package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesPractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
        System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
        driver.switchTo().defaultContent();
    }
}
