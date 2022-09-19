package com.github.kondrakov.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriver driver;
    public static WebDriver getInstance() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
