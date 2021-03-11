package com.example.testtask.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {

    WebDriver wd;
    MainPageHelper mainPage;
    MarketHeaderHelper marketHeader;
    MarketItemHelper marketItem;


    public void init() {
        wd = new ChromeDriver();
//        wd = new InternetExplorerDriver();
        wd.manage().window().maximize();

        openSite("https://yandex.ru/");

        mainPage = new MainPageHelper(wd);
        marketHeader = new MarketHeaderHelper(wd);
        marketItem = new MarketItemHelper(wd);

    }

    public void stop() {
        wd.quit();
    }

    public void openSite(String url) {
        wd.navigate().to(url);
    }



    public MainPageHelper getMainPage() {
        return mainPage;
    }

    public MarketHeaderHelper getMarketHeader() {
        return marketHeader;
    }

    public MarketItemHelper getMarketItem() {
        return marketItem;
    }
}
