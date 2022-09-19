package com.github.kondrakov.framework.pobjects;

import com.github.kondrakov.framework.BasePage;
import com.github.kondrakov.framework.ElementId;
import org.openqa.selenium.WebElement;

public class AmMainPage extends BasePage {

    @ElementId(id = "hamburgerLink", xpath = "//*[contains(@id, 'nav-hamburger-menu')]")
    public WebElement hamburgerLink;

    @ElementId(id = "tvAppliancesElectronics", xpath = "//div[contains(text(), 'TV, Appliances, Electronics')]/parent::a")
    public WebElement tvAppliancesElectronics;

    @ElementId(id = "televisions", xpath = "//a[contains(text(), 'Televisions')]")
    public WebElement televisions;
}
