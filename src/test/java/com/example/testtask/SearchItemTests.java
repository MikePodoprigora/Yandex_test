package com.example.testtask;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SearchItemTests extends TestBase{


    @Test
    public void testItem() throws InterruptedException {
        goToMarket();

        switchToNextTab();

        selectComputersDepartment();

        filterItem(new Item("planshety", "20000", "35000", "Apple"));


        String itemElement = wd.findElement(By.xpath("//*[@data-autotest-id='product-snippet'][2]//h3")).getText();


    }


}
