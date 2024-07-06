package Selenium;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        addItems(driver, itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        driver.findElement(By.cssSelector("button.promoBtn")).click();

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {

        int j = 0;

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {

            String[] name = products.get(i).getText().split("-");

            String formattedName = name[0].trim();


            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {

                j++;

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (j == itemsNeeded.length) {

                    break;

                }

            }

        }

    }


}