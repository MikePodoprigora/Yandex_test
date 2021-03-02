package com.example.testtask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class SearchItemTests {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        openSite("https://yandex.ru/");

        click(By.cssSelector("[data-id='market']"));
        click(By.cssSelector("[href*='/kompiuternaia-tekhnika']"));

        click(By.cssSelector("[href*='/catalog--planshety']"));

        type(By.cssSelector("#glpricefrom"), "20000");
        type(By.cssSelector("#glpriceto"), "35000");
        click(By.cssSelector("[name$=Apple]"));
        wd.findElement(By.xpath("//*[@data-autotest-id='product-snippet'][2]"));

    }






    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void openSite(String url) {
        wd.navigate().to(url);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

}
