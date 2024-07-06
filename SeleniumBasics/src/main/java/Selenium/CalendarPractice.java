package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CalendarPractice {

    public static void main(String[] args) {

        String monthNumber = "6";
        String day = "15";
        String year = "2027";
        String[] fullDate = {monthNumber, day, year};

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("div.react-date-picker")).click();
        driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)- 1).click();
        driver.findElement(By.xpath("//abbr[text()='" + day + "']")).click();

        List< WebElement> date = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

        for(int i = 0; i < date.size(); i++) {
            System.out.println(date.get(i).getAttribute("value"));
            //Assert.assertEquals(date.get(i).getAttribute("value")), fullDate[i]);
        }



    }
}