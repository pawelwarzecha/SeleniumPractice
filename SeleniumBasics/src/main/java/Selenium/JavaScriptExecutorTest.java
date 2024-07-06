package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class JavaScriptExecutorTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript(("document.querySelector(\".tableFixHead\").scrollTop=5000\n"));
        List< WebElement> elementsList = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;
        //for(int i = 0; i<elementsList.size(); i++)
        for (WebElement webElement : elementsList) {

            sum = sum + Integer.parseInt(webElement.getText());

        }
        System.out.println(sum);


    }
}