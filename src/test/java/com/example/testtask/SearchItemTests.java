package com.example.testtask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchItemTests {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        openSite("https://yandex.ru/");
    }

    @Test
    public void testItem() throws InterruptedException {
        click(By.cssSelector("[data-id='market']"));

        switchToNextTab();

        click(By.cssSelector("[href*='/kompiuternaia-tekhnika']"));


        click(By.cssSelector("[href^='/catalog--planshety/']"));

        type(By.cssSelector("#glpricefrom"), "20000");
        type(By.cssSelector("#glpriceto"), "35000");
        click(By.cssSelector("[name$=Apple]"));

//        WebElement item = wd.findElement(By.xpath("//*[@data-autotest-id='product-snippet'][2]"));
//        String itemName = item.findElement(By.xpath(".//h3")).getText();

        String itemElement = wd.findElement(By.xpath("//*[@data-autotest-id='product-snippet'][2]//h3")).getText();


    }


    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        if (text != null) {
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void openSite(String url) {
        wd.navigate().to(url);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    private void switchToNextTab() {
        List<String> avaliableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!avaliableWindows.isEmpty()){
            wd.switchTo().window(avaliableWindows.get(1));
        }
    }


}
