package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class sortingWebTables {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//thead/tr[1]/th[1]")).click();
        List<WebElement> names = driver.findElements(By.xpath("//tr//td[1]"));
        List<String> originalList = names.stream().map(s->s.getText()).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(originalList.equals(sortedList));
        List<String> price;
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPrice(s)).collect(Collectors.toList());
            price.forEach(s -> System.out.println(s));
            if (price.isEmpty()) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }
        while(price.isEmpty());
    }

    private static String getPrice(WebElement s) {
        String value = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return value;
    }
}
