package com.github.kondrakov.framework.pobjects;

import com.github.kondrakov.framework.BasePage;
import com.github.kondrakov.framework.ElementId;
import com.github.kondrakov.framework.pobjects.subobjects.SortSelectorSubPage;
import com.github.kondrakov.framework.pobjects.subobjects.SubPage;
import org.openqa.selenium.WebElement;

import java.util.HashSet;

public class FilterResultPage extends BasePage {

    public FilterResultPage() {
        super();

        setSubPages(
                new HashSet<SubPage>() {{
                    add(new SortSelectorSubPage());
                }}
        );
    }

    @ElementId(id = "sortSelector", xpath = "//label[contains(text(), 'Sort') and contains(text(), 'by:')]/parent::span")
    public WebElement sortSelector;

    @ElementId(id = "itemList", xpath = "//*[contains(@class, 's-card-container')]/div[1]/div[1]/span/a")
    public WebElement itemList;

}
