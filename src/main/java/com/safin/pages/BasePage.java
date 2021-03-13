package com.safin.pages;

import com.safin.setup.Setup;
import com.safin.setup.Wait;
import org.openqa.selenium.WebDriver;


public class BasePage {
  protected WebDriver webDriver;
  protected Wait wait;

  public BasePage() {
    this.webDriver = Setup.getWebDriver();
    this.wait = new Wait(webDriver);
  }
}
