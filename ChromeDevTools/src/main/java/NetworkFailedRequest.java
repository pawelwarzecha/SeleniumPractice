import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v127.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v127.fetch.Fetch;
import org.openqa.selenium.devtools.v127.network.model.ErrorReason;

import java.util.List;
import java.util.Optional;

public class NetworkFailedRequest {
    public static void main(String[] args) {

        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:\\Chrome Driver\\chrome-win64\\chrome.exe");

        ChromeDriver driver = new ChromeDriver(co);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Optional<List<RequestPattern>> patterns = Optional.of(List.of(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));

        devTools.send(Fetch.enable(patterns, Optional.empty()));

        devTools.addListener(Fetch.requestPaused(), request ->
        {
            devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

    }
}
