package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(Duration.of(2, ChronoUnit.SECONDS));
        //driver.navigate().to("https://automationstepbystep.coom");

        driver.findElement(new By.ByXPath("//*[@id=\"APjFqb\"]")).sendKeys("hello");
        Thread.sleep(2000);
        //Object html;
        //driver.findElement(By.ByXPath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[3]/div[2]/svg/path[1]")).
        driver.findElement(By.className("goxjub")).click();
        Thread.sleep(2000);
        driver.close();


    }



}