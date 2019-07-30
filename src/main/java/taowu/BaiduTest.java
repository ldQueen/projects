package taowu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaiduTest {
    WebDriver driver;
    @BeforeTest
    public void init(){
        String url = "http://www.baidu.com";
        //新建一个浏览器句柄
        driver = new Brower().chrome();
        //打开url
        driver.get(url);
    }
    @Test
    @Parameters("searchWord")
    public void search(String searchWord) throws InterruptedException {
        //输入搜索字符串
        driver.findElement(By.cssSelector("#kw")).sendKeys(searchWord);
        //点击按钮
        driver.findElement(By.cssSelector("#su")).click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
