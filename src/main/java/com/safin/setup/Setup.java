package com.safin.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
  private static WebDriver webDriver;

  private Setup() {}

  public static WebDriver getWebDriver() {
    if(webDriver == null) {
      webDriver = new ChromeDriver();
    }
    return webDriver;
  }
}