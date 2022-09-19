package com.github.kondrakov.framework.helpers;

import com.github.kondrakov.framework.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    public static WebElement toBeClickableWait(String xpath, int fluentTimeoutLimit) {
        return new WebDriverWait(
                WebDriverSingleton.getInstance(), Duration.ofSeconds(fluentTimeoutLimit)
        ).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public static WebElement toBeClickableWait(String xpath) {
        return toBeClickableWait(xpath, 10);
    }
}
