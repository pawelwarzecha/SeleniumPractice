package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeExercise {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
        String string = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
        System.out.println(string);
        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select s = new Select(dropdown);
        s.selectByVisibleText(string);
        driver.findElement(By.cssSelector("input[name='enter-name']")).sendKeys(string);
        driver.findElement(By.id("alertbtn")).click();
        String alert = driver.switchTo().alert().getText();
        if(alert.contains(string)){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }
        driver.switchTo().alert().accept();


    }
}
