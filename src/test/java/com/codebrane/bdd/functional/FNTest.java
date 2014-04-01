package com.codebrane.bdd.functional;

import com.thoughtworks.selenium.DefaultSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public abstract class FNTest {
  protected static final Logger LOGGER = Logger.getLogger(FNTest.class.getName());

  // Selenium settings
  protected static final String SELENIUM_SERVER_HOST = "localhost";
  protected final int SELENIUM_PORT = 4444;

  // HtmlUnitDriver settings
  protected static final String BROWSER = "*mock";
  protected static final String ROOT = "http://localhost:8999";
  protected static final String APP_ROOT = ROOT + "/bdd/";

  protected DefaultSelenium seleniumClient;
  protected WebDriver webDriver;
  protected WebElement webElement;
}
