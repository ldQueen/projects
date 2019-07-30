package taowu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Brower {
    WebDriver driver;
    public WebDriver chrome(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-extensions");
        Map<String,Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enable",false);
        options.setExperimentalOption("prefs",prefs);//禁用保存密码提示框
        driver = new ChromeDriver(options);
        //设置寻找一个元素的时间
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}
