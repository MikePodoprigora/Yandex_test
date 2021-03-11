package com.example.testtask.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketHeaderHelper extends HelperBase{

    public MarketHeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void selectComputersDepartment() {
        click(By.cssSelector("[href*='/kompiuternaia-tekhnika']"));
    }

    public void searchItemFromSearchInputBox(String itemName) {
        type(By.cssSelector("#header-search"), itemName);
        click(By.cssSelector("[type=submit]"));
    }
}
