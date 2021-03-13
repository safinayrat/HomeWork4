package com.safin.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

  private final WebDriver driver;

  public Wait(WebDriver driver) {
    this.driver = driver;
  }

  private void waitUntilCondition(ExpectedCondition condition) {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(condition);
  }

  public void clickableElement(WebElement webElement) {
    ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(webElement);
    waitUntilCondition(condition);
  }

  public void textToBePresentInElement(WebElement webElement, String location) {
    ExpectedCondition<Boolean> condition = ExpectedConditions.textToBePresentInElement(webElement, location);
    waitUntilCondition(condition);
  }

}
