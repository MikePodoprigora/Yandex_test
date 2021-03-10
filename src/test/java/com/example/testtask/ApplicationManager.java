package com.example.testtask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ApplicationManager {

    WebDriver wd;

    protected void init() {
        wd = new ChromeDriver();
//        wd = new InternetExplorerDriver();
        wd.manage().window().maximize();

        openSite("https://yandex.ru/");
    }

    protected void stop() {
        wd.quit();
    }

    public void filterItem(Item item) {
        click(By.cssSelector("[href^='/catalog--"+ item.getItemType() +"']"));

        type(By.cssSelector("#glpricefrom"), item.getPriceFrom());
        type(By.cssSelector("#glpriceto"), item.getPriceTo());

        click(By.xpath("//span[text()='"+ item.getBrand() +"']"));
    }

    public void selectComputersDepartment() {
        click(By.cssSelector("[href*='/kompiuternaia-tekhnika']"));
    }

    public void goToMarket() {
        click(By.cssSelector("[data-id='market']"));
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

    public void switchToNextTab() {
        List<String> avaliableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!avaliableWindows.isEmpty()) {
            wd.switchTo().window(avaliableWindows.get(1));
        }
    }

    public void searchItemFromSearchInputBox(String itemName) {
        type(By.cssSelector("#header-search"), itemName);
        click(By.cssSelector("[type=submit]"));
    }

    public String getItemNameFromListByOrder(int number) {
        return wd.findElement(By.xpath("//*[@data-autotest-id='product-snippet']["+number+"]//h3")).getText();
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}
