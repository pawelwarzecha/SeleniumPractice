package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindow {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindow = it.next();
        String childWindows = it.next();
        driver.switchTo().window(childWindows);
        driver.get("https://rahulshettyacademy.com/");
        Thread.sleep(3000);
        String name = driver.findElement(By.xpath("//h2/a[1]")).getText();
        driver.switchTo().window(parentWindow);
        WebElement nameBox = driver.findElement(By.xpath("//div/input[@name='name']"));
        nameBox.sendKeys(name);

        File filename = nameBox.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(filename, new File("logo.png"));

        System.out.println(nameBox.getRect().getDimension().getHeight());
        System.out.println(nameBox.getRect().getDimension().getWidth());
    }
}
