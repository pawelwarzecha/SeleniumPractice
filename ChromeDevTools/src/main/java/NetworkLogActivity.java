import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.devtools.v129.network.model.Request;
import org.openqa.selenium.devtools.v129.network.model.Response;

import java.util.Optional;

public class NetworkLogActivity {
    public static void main(String[] args) {

        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:\\Chrome Driver\\chrome-win64\\chrome.exe");

        ChromeDriver driver = new ChromeDriver(co);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), request ->
        {
            Request req = request.getRequest();
            //System.out.println(req.getUrl());
            //req.getHeaders();
        });

        devTools.addListener(Network.responseReceived(), response ->
        {
            Response res = response.getResponse();
            //System.out.println(res.getUrl());
            //System.out.println(res.getStatus());
            if(res.getStatus().toString().startsWith("4")){
                System.out.println(res.getUrl() + "is failing with status code" + res.getStatus());
            }
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();


    }
}
