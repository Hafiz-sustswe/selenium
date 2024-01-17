package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BookScript {
    WebDriver driver;


    public void getDepurture(List<WebElement> countryElements, String depurtureCity) throws InterruptedException {
        // Extract and print the text of each country
        for (WebElement countryElement : countryElements) {
            String countryText = countryElement.getText();
            System.out.println(countryText);

            if(countryText.equals(depurtureCity)){
                countryElement.click();
            }
        }
    }
    public void getArrival(List<WebElement> countryElements, String arrivalCity) throws InterruptedException {
        for (WebElement countryElement : countryElements) {
            String countryText = countryElement.getText();
            System.out.println(countryText);

            if(countryText.equals(arrivalCity)){
                countryElement.click();
            }
        }
    }

    public void selectDate(int day) throws InterruptedException {
        WebElement dateElement = driver.findElement(By.xpath("//a[@data-date='" + day + "']"));
        dateElement.click();
    }

    public void selectCurrency(String currencyName) throws InterruptedException {
        WebElement currency = driver.findElement(By.xpath("/html/body/div[19]/form/div[2]/div/div[2]/div[3]/div/div[4]/p/select"));
        Select dropdownSelect = new Select(currency);
        dropdownSelect.selectByVisibleText(currencyName);

    }

    public BookScript() throws InterruptedException {
        driver = new ChromeDriver();

        driver.get("https://book.spicejet.com/search.aspx");

        // Locate the dropdown container element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));

        WebElement depurture = driver.findElement(By.name("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT"));
        depurture.click();

        WebElement dropdownContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dropdownGroup1")));
        java.util.List<WebElement> countryElements = dropdownContainer.findElements(By.cssSelector("ul li a"));

        getDepurture(countryElements,"Chennai (MAA)");
        getArrival(countryElements, "Delhi (DEL)");
        selectDate(20);
        selectCurrency("BDT");

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[19]/form/div[2]/div/div[2]/div[3]/div/div[11]/div/span/input"));
        searchButton.click();

        // Close the browser
//        driver.quit();
    }


}