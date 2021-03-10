package com.example.testtask;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTests extends TestBase{


    @Test
    public void testItem() throws InterruptedException {
        app.goToMarket();
        app.switchToNextTab();
        app.selectComputersDepartment();
        app.filterItem(new Item()
                .setItemType("planshety")
                .setPriceFrom("20000")
                .setPriceTo("35000")
                .setBrand("Apple"));

        app.pause(2000);

        String itemName = app.getItemNameFromListByOrder(2);

        app.searchItemFromSearchInputBox(itemName);
        app.pause(2000);

        String foundItemName = app.getItemNameFromListByOrder(1);
        Assert.assertEquals(foundItemName, itemName);
        
    }

}
