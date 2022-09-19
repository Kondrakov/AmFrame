package com.github.kondrakov.tests;

import com.github.kondrakov.framework.BasePage;
import com.github.kondrakov.framework.ElementId;
import com.github.kondrakov.framework.WebDriverSingleton;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameworkTests {

    @Test
    public void singletonTest() {
        WebDriver webDriver0 = WebDriverSingleton.getInstance();
        WebDriver webDriver1 = WebDriverSingleton.getInstance();
        Assert.assertEquals("WebDriver is not singleton", webDriver0, webDriver1);
        WebDriverSingleton.getInstance().close();
    }

    @Test
    public void basePageTest() {
        BasePage basePage = new BasePageTest();
        ElementId elementDesc = basePage.getElementDesc("testElement");
        Assert.assertEquals(String.format("xpath is: %s but expected: %s", TEST_XPATH, elementDesc.xpath()),
                TEST_XPATH, elementDesc.xpath());
    }

    public final String TEST_XPATH =  "//*['contains(@id, 'test xpath')']";

    class BasePageTest extends BasePage {
        @ElementId(id = "testElement", xpath = TEST_XPATH)
        public WebElement testElement;
    }


}
