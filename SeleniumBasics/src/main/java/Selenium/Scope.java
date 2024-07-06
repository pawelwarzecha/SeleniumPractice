package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        Actions a = new Actions(driver);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));

        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

        System.out.println(columndriver.findElements(By.tagName("a")).size());

        int links = columndriver.findElements(By.tagName("a")).size();

        for(int i = 1; i < links; i++){

            //Using actions
            a.moveToElement(columndriver.findElements(By.tagName("a")).get(i)).keyDown(Keys.CONTROL).click().build().perform();

            //Using Keys
            //String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            //columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
        }

        Set<String> windows = driver.getWindowHandles();

        //replaced with enhanced for loop
        //Set<String> windows = driver.getWindowHandles();
        //while(it.hasNext()){
        for (String window : windows) {

            driver.switchTo().window(window);
            System.out.println(driver.getTitle());
        }




    }
}
