package taowu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    @BeforeTest
    public void init(){
        String url = "http://s.sunmoon.me/#/index";
        driver = new Brower().chrome();
        driver.get(url);
    }
    @Test
    public  void loginCheck(){
        loginBypass();
        //测试001 账号密码为空
        String red_msg = login("","");

        if(red_msg.equals("请输入账号")){
            System.out.println("001，测试成功");
        }else {
            System.out.println("001,测试不通过");
        }
        //测试002 密码为空
        red_msg = login("1763567962","");
        if(red_msg.equals("请输入密码")){
            System.out.println("002，测试成功");
        }else {
            System.out.println("002,测试不通过");
        }
        //测试003 账号错误
        red_msg = login("1763567962","111111");
        if(red_msg.equals("用户名或密码错误!")){
            System.out.println("003，测试成功");
        }else {
            System.out.println("003,测试不通过");
        }
        //测试004 ，密码错误
        red_msg = login("17635679626","111");
        if(red_msg.equals("用户名或密码错误!")){
            System.out.println("004，测试成功");
        }else {
            System.out.println("004,测试不通过");
        }
        //测试005  账号密码正确
        red_msg = login("17635679626","111111");
        if(red_msg.equals("")){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String msg = driver.findElement(By.cssSelector("#app > div > div.index-wrap > div:nth-child(1) > div > div.d-flex.align-items-center.cursor-p.ml-auto > div.d-flex.justify-content-center.font16px.ml-7.c333 > span.ml-1")).getText();
            if(msg.equals("|  退出")){
                System.out.println("005, 测试成功");
            }else {
                System.out.println("005，测试不通过");
            }
        }

    }
    //输入账号密码
    public String login(String username,String password) {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='账号密码登录'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='账号密码登录'])[1]/following::input[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='账号密码登录'])[1]/following::input[1]")).sendKeys(username);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='账号密码登录'])[1]/following::div[3]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='账号密码登录'])[1]/following::input[2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='账号密码登录'])[1]/following::input[2]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='账号密码登录'])[1]/following::input[2]")).sendKeys(password);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='忘记密码'])[1]/following::span[1]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String red_msg = driver.findElement(By.cssSelector("#dialog_login > div > div.el-dialog__body > form > div:nth-child(3)")).getText();
        return red_msg;
    }
    //选择账号密码登录
    public void loginBypass(){
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='小区'])[1]/following::span[1]")).click();
        driver.findElement(By.linkText("账号密码登录")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
