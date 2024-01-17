package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookScriptTest {

    @Mock
    private WebDriver mockDriver;

    @Mock
    private WebElement mockWebElement;

    @Mock
    private Select mockSelect;

    @InjectMocks
    private BookScript bookScript;

    @BeforeEach
    void setUp() {
        when(mockDriver.findElement(any(By.class))).thenReturn(mockWebElement);
    }

    @Test
    void testGetDeparture() throws InterruptedException {
        List<WebElement> countryElements = new ArrayList<>();
        WebElement mockCountryElement = mock(WebElement.class);
        when(mockCountryElement.getText()).thenReturn("Chennai (MAA)");
        countryElements.add(mockCountryElement);

        bookScript.getDepurture(countryElements, "Chennai (MAA)");

        verify(mockCountryElement, times(1)).click();
    }

    @Test
    void testGetArrival() throws InterruptedException {
        List<WebElement> countryElements = new ArrayList<>();
        WebElement mockCountryElement = mock(WebElement.class);
        when(mockCountryElement.getText()).thenReturn("Delhi (DEL)");
        countryElements.add(mockCountryElement);

        bookScript.getArrival(countryElements, "Delhi (DEL)");

        verify(mockCountryElement, times(1)).click();
    }

    @Test
    void testSelectDate() throws InterruptedException {
        bookScript.selectDate(20);

        verify(mockDriver, times(1)).findElement(By.xpath("//a[@data-date='20']"));
        verify(mockWebElement, times(1)).click();
    }

    @Test
    void testSelectCurrency() throws InterruptedException {
        when(mockDriver.findElement(By.xpath("/html/body/div[19]/form/div[2]/div/div[2]/div[3]/div/div[4]/p/select"))).thenReturn(mockWebElement);
        whenNew(Select.class).withArguments(mockWebElement).thenReturn(mockSelect);

        bookScript.selectCurrency("BDT");

        verify(mockSelect, times(1)).selectByVisibleText("BDT");
    }
}
