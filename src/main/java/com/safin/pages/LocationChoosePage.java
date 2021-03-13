package com.safin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocationChoosePage extends BasePage {
  public LocationChoosePage() {
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(css = "input[data-marker='popup-location/region/input']")
  private WebElement locationSearchInput;

  @FindBy(css = "button[data-marker='popup-location/save-button']")
  private WebElement locationButtonSave;

  public ProductsPage selectLocation(String location) {
    locationSearchInput.sendKeys(location);
    WebElement firstLi = webDriver.findElement(By.cssSelector("li[data-marker='suggest(0)']"));
    if (firstLi.isDisplayed()) {
        wait.textToBePresentInElement(firstLi, location);
        firstLi.click();
        locationButtonSave.click();
        return new ProductsPage();
      }
    throw new IllegalArgumentException("location is not exist");
  }

}
