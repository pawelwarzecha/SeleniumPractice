package Selenium;

import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class UserBenchmarkTest {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cpu.userbenchmark.com/");
        driver.findElement(By.cssSelector("[class='fc-button-label']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("//th[@data-mhth='MC_MKTSHARE']")).click();
        Thread.sleep(1000);
        int numberOfRows = 1;
        WebElement nextButton = driver.findElement(By.cssSelector("a[id=\"tableDataForm:j_idt277\"]"));
        boolean warunek = nextButton.isDisplayed();
        String pageNumber;
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> names1 = new ArrayList<String>();
        CSVWriter write = new CSVWriter(new FileWriter("TestData//sample1.csv"));



        do {
            pageNumber = driver.findElement(By.xpath("(//nav/ul/li/a)[2]")).getText();
            if (Objects.equals(pageNumber, "Page 29 of 29")) {
                break;
            }
            String number = Integer.toString(numberOfRows);
            names.add(driver.findElement(By
                    .xpath("//table[@class=\"table mh-td table-v-center table-h-center\"]/tbody/tr["
                            + number + "]/td/div/div/span")).getText());
            names1.add(driver.findElement(By
                    .xpath("//table[@class=\"table mh-td table-v-center table-h-center\"]/tbody/tr["
                            + number + "]/td[8]/div")).getText() + " %");
            numberOfRows++;
            if (pageNumber != "Page 29 of 29'") {
                if (numberOfRows == 50) {
                    driver.findElement(By.cssSelector("a[id=\"tableDataForm:j_idt277\"]")).click();
                    Thread.sleep(2000);
                    numberOfRows = 1;
                }
            }

        }
        while (warunek);

        String[] arrayNames = new String[names.size()];
        String[] arrayNames1 = new String[names1.size()];

        for (int i = 0; i < names.size(); i++) {
            arrayNames[i] = names.get(i);
        }
        for (int i = 0; i < names1.size(); i++) {
            arrayNames1[i] = names1.get(i);
        }
        write.writeNext(arrayNames);
        write.writeNext(arrayNames1);

    }
}