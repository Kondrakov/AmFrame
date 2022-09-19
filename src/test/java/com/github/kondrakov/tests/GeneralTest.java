package com.github.kondrakov.tests;

import com.github.kondrakov.framework.BasePage;
import com.github.kondrakov.framework.WebDriverSingleton;
import com.github.kondrakov.framework.pobjects.AmMainPage;
import com.github.kondrakov.framework.pobjects.FilterPage;
import com.github.kondrakov.framework.pobjects.FilterResultPage;
import com.github.kondrakov.framework.pobjects.ItemPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class GeneralTest {


    BasePage currentPage;

    @BeforeClass
    public static void setupDriver() {
        WebDriverSingleton.getInstance().get("https://www.amazon.in");
        WebDriverSingleton.getInstance().manage().window().maximize();
    }

    @AfterClass
    public static void tearDownDriver() {
        WebDriverSingleton.getInstance().close();
    }

    @Test
    public void mainTest() {
        currentPage = new AmMainPage();
        currentPage.clickElement("hamburgerLink");
        currentPage.clickElement("tvAppliancesElectronics");
        currentPage.clickElement("televisions");

        currentPage = new FilterPage();
        currentPage.clickElement("brandSamsung");

        currentPage = new FilterResultPage();
        currentPage.clickElement("sortSelector");
        currentPage.clickElement("selectItemPriceHighToLow");
        currentPage.clickElementsByIndex("itemList", 1);

        currentPage = new ItemPage();
        currentPage.switchTab();
        currentPage.checkElementText("aboutHeader", "About this item");
    }

}
