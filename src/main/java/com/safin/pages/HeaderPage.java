package com.safin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HeaderPage extends BasePage {
  public HeaderPage() {
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(id = "category")
  private WebElement category;

  @FindBy(id = "search")
  private WebElement searchInput;

  @FindBy(css = "div[data-marker='search-form/region']")
  private WebElement selectLocation;

  public HeaderPage selectCategory(String categoryName) {
    Select select = new Select(category);
    select.selectByVisibleText(categoryName);
    return this;
  }

  public HeaderPage suggestSearch(String text) {
    searchInput.sendKeys(text);
    return this;
  }

  public LocationChoosePage clickSelectLocation() {
    selectLocation.click();
    return new LocationChoosePage();
  }
}
