package com.github.kondrakov.framework.pobjects;

import com.github.kondrakov.framework.BasePage;
import com.github.kondrakov.framework.ElementId;
import org.openqa.selenium.WebElement;

public class ItemPage extends BasePage {

    @ElementId(id = "aboutHeader", xpath = "//div[contains(@id, 'feature-bullets')]/h1")
    public WebElement aboutHeader;
}
