package Selenium;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SSLCheck {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        //Maven project dependency
        //Proxy proxy = new Proxy();
        //proxy.setHttpProxy("");
        //options.setCapability("proxy", proxy);
        //Map<String, Object> prefs = new HashMap<String, Object>();
        //prefs.put("download_default_directory". "directory/path");
        //options.setExperimentalOption("prefs", prefs);
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\HP Compat\\Pictures"));

    }
}