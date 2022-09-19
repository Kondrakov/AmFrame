package com.github.kondrakov.framework;

import com.github.kondrakov.framework.helpers.Waits;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    public ElementId getElementDesc(String id) {
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

    public ElementId getElementDesc(Field fieldElement) {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (fieldElement.equals(field)) {
                return field.getAnnotation(ElementId.class);
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
        List<String> tabs2 = new ArrayList<>(WebDriverSingleton.getInstance().getWindowHandles());
        WebDriverSingleton.getInstance().switchTo().window(tabs2.get(1));
    }
}
