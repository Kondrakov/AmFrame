package com.github.kondrakov.framework.pobjects;

import com.github.kondrakov.framework.BasePage;
import com.github.kondrakov.framework.ElementId;
import org.openqa.selenium.WebElement;

public class FilterPage extends BasePage {

    @ElementId(id = "brandSamsung", xpath = "//span[contains(text(), 'Brands')]/parent::div/following-sibling::ul//*[contains(text(), 'Samsung')]")
    public WebElement brandSamsung;
}
