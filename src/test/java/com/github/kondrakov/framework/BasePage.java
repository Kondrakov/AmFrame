package com.github.kondrakov.framework;

import com.github.kondrakov.framework.helpers.Waits;
import com.github.kondrakov.framework.pobjects.subobjects.SubPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.*;

public class BasePage {

    public BasePage() {
        subPages = new HashSet<>();
    }

    Set<SubPage> subPages;
    public Set<SubPage> getSubPages() {
        return subPages;
    }
    public void setSubPages(Set<SubPage> subPages) {
        this.subPages = subPages;
    }

    public ElementId getElementDesc(String id) {
        for (SubPage subPage: getSubPages()) {
            if (subPage.contains(id)) {
                return subPage.getElementDesc(id);
            }
        }
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ElementId.class)) {
                ElementId elementId = field.getAnnotation(ElementId.class);
                if (id.equals(elementId.id())) {
                    return elementId;
                }
            }
        }
        return null;
    }

    public void clickElement(String id) {
        ElementId elementId = getElementDesc(id);
        WebElement webElement = Waits.toBeClickableWait(elementId.xpath());

        webElement.click();
    }

    public void clickElementsByIndex(String id, int index) {
        ElementId elementId = getElementDesc(id);
        Waits.toBeClickableWait(elementId.xpath());

        List<WebElement> elements = WebDriverSingleton.getInstance().findElements(By.xpath(elementId.xpath()));

        elements.get(index).click();
    }

    public void checkElementText(String id, String text) {
        ElementId elementId = getElementDesc(id);
        WebElement webElement = Waits.toBeClickableWait(elementId.xpath());

        Assert.assertEquals(String.format("Expected text is %s but actual is %s", text, webElement.getText()),
                text, webElement.getText());
    }

    public void switchTab() {
        List<String> tabs = new ArrayList<>(WebDriverSingleton.getInstance().getWindowHandles());
        WebDriverSingleton.getInstance().switchTo().window(tabs.get(0));
        WebDriverSingleton.getInstance().close();
        WebDriverSingleton.getInstance().switchTo().window(tabs.get(1));
    }
}
