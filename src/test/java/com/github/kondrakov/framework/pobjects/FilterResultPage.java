package com.github.kondrakov.framework.pobjects;

import com.github.kondrakov.framework.BasePage;
import com.github.kondrakov.framework.ElementId;
import org.openqa.selenium.WebElement;

public class FilterResultPage extends BasePage {

    @ElementId(id = "sortSelector", xpath = "//label[contains(text(), 'Sort') and contains(text(), 'by:')]/parent::span")
    public WebElement sortSelector;

    @ElementId(id = "selectItemFeatured", xpath = "//*[contains(text(), 'Featured')]/parent::li")
    public WebElement selectItemFeatured;

    @ElementId(id = "selectItemPriceLowToHigh", xpath = "//*[contains(text(), 'Price:') and contains(text(), 'Low to High')]/parent::li")
    public WebElement selectItemPriceLowToHigh;

    @ElementId(id = "selectItemPriceHighToLow", xpath = "//*[contains(text(), 'Price:') and contains(text(), 'High to Low')]/parent::li")
    public WebElement selectItemPriceHighToLow;

    @ElementId(id = "selectItemAvgCustomerReview", xpath = "//*[contains(text(), 'Avg.') and contains(text(), 'Customer Review')]/parent::li")
    public WebElement selectItemAvgCustomerReview;

    @ElementId(id = "selectItemAvgCustomerReview", xpath = "//*[contains(text(), 'Newest Arrivals')]/parent::li")
    public WebElement selectItemNewestArrivals;



    @ElementId(id = "itemList", xpath = "//*[contains(@class, 's-card-container')]/div[1]/div[1]/span/a")
    public WebElement itemList;

}
