package com.example.testtask.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        if (text != null) {
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void switchToNextTab() {
        List<String> avaliableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!avaliableWindows.isEmpty()) {
            wd.switchTo().window(avaliableWindows.get(1));
        }
    }
}
