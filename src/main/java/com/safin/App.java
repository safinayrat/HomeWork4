package com.safin;

import com.safin.pages.HeaderPage;
import com.safin.setup.Setup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class App {
  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver webDriver = Setup.getWebDriver();
    webDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    webDriver.get("https://m.avito.ru");

    HeaderPage headerPage = PageFactory.initElements(webDriver, HeaderPage.class);

    headerPage
            .selectCategory("Оргтехника и расходники")
            .suggestSearch("Принтер")
            .clickSelectLocation()
            .selectLocation("Владивосток")
            .selectDeliveryFilter()
            .clickSubmitButton()
            .sortProductsInOrder("Дороже")
            .outputTheNamesOfThreeProducts();
  }
}
