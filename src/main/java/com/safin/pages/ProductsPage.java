package com.safin.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {
  public ProductsPage() {
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(css = "label[data-marker='delivery-filter']")
  private WebElement deliveryFilter;

  @FindBy(css = "button[data-marker='search-filters/submit-button']")
  private WebElement submitButton;

  @FindBy(xpath = "//*[contains(text(),'По умолчанию')]")
  private WebElement sortProductsSelect;

  @FindBy(css = "h3[itemprop='name']")
  private List<WebElement> productList;

  public ProductsPage selectDeliveryFilter() {
    JavascriptExecutor js = (JavascriptExecutor) webDriver;
    js.executeScript("arguments[0].scrollIntoView(true);", deliveryFilter);
    if (!deliveryFilter.isSelected()) {
      wait.clickableElement(deliveryFilter);
      deliveryFilter.click();
    }
    return this;
  }

  public ProductsPage clickSubmitButton() {
    submitButton.click();
    return this;
  }

  public ProductsPage sortProductsInOrder(String value) {
    JavascriptExecutor js = (JavascriptExecutor) webDriver;
    WebElement webElementSelect = (WebElement) js.executeScript("return arguments[0].parentNode", sortProductsSelect);
    Select select = new Select(webElementSelect);
    select.selectByVisibleText(value);
    return this;
  }

  public void outputTheNamesOfThreeProducts() {
    for (int i = 0; i < 3; i++) {
      String productName = productList.get(i).getText();
      System.out.println(productName);
    }
  }
}
