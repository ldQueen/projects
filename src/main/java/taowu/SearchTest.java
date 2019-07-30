package taowu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;

public class SearchTest {
    WebDriver driver;
    @BeforeTest
    public void  init(){
        String url = "http://s.sunmoon.me/#/index";
        driver = new Brower().chrome();
        driver.get(url);
    }
    @Test
    public void search(){
        try {
            search1("禹洲");
//            search2("名门");
//            search3("名门");
//            jump();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    //首页二手房查找
    public void search1(String erhouse) throws InterruptedException {
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='找小区'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='找小区'])[1]/following::input[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='找小区'])[1]/following::input[1]")).sendKeys(erhouse);
        Thread.sleep(2000);
        WebElement searchButton = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='找小区'])[1]/following::div[2]"));
        for(int i=0;i<5;i++){
            action.dragAndDropBy(searchButton,10,0).build().perform();
        }
        action.moveToElement(searchButton).perform();
//        searchButton.click();
        Thread.sleep(2000);

    }
    //首页租房查找
    public void search2(String zhouse) throws InterruptedException {
        driver.findElement(By.cssSelector("#second_base > div.head-bg > div > div.head-hover > a:nth-child(1)")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='找二手房'])[1]/following::span[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='找小区'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='找小区'])[1]/following::input[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='找小区'])[1]/following::input[1]")).sendKeys(zhouse);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='找小区'])[1]/following::div[2]")).click();
        Thread.sleep(2000);

    }
    //首页小区查找

    public void search3(String xqhouse) throws InterruptedException {
        driver.findElement(By.cssSelector("#rental_base > div.head-bg > div > div.head-hover > a:nth-child(1)")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='找租房'])[1]/following::span[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='找小区'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='找小区'])[1]/following::input[1]")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='找小区'])[1]/following::input[1]")).sendKeys(xqhouse);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='找小区'])[1]/following::div[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#community_base > div.head-bg > div > div.head-hover > a:nth-child(1)")).click();
    }
    //首页二手房 ，租房 ，小区链接跳转
    public  void jump() throws InterruptedException {
        driver.findElement(By.cssSelector("#app > div > div.index-wrap > div:nth-child(1) > div > div.d-flex.align-items-center.cursor-p.ml-auto > div.d-flex.font22px.c333 > span:nth-child(1)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#second_base > div.head-bg > div > div.head-hover > a:nth-child(1)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#app > div > div.index-wrap > div:nth-child(1) > div > div.d-flex.align-items-center.cursor-p.ml-auto > div.d-flex.font22px.c333 > span:nth-child(2)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#rental_base > div.head-bg > div > div.head-hover > a:nth-child(1)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#app > div > div.index-wrap > div:nth-child(1) > div > div.d-flex.align-items-center.cursor-p.ml-auto > div.d-flex.font22px.c333 > span:nth-child(3)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#community_base > div.head-bg > div > div.head-hover > a:nth-child(1)")).click();
        Thread.sleep(2000);
    }
    //地区定位
    public void loacation() throws InterruptedException {
        driver.findElement(By.cssSelector("#app > div > div.index-wrap > div:nth-child(1) > div > div:nth-child(1) > span")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#app > div > div.index-wrap > div:nth-child(1) > div > div.citylayer > div > ul > li:nth-child(6) > p > a")).click();
        Thread.sleep(2000);
    }
}
