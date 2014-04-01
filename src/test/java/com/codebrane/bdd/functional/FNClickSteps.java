package com.codebrane.bdd.functional;

import com.thoughtworks.selenium.DefaultSelenium;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FNClickSteps extends FNTest {
  @Before
  public void initSelenium() throws Exception {
    LOGGER.info("starting selenium driver");
    seleniumClient = new DefaultSelenium(SELENIUM_SERVER_HOST, SELENIUM_PORT, BROWSER, ROOT);
    seleniumClient.start();
    webDriver = new HtmlUnitDriver();
  }

  @Given("^I navigate to the test application$")
  public void given_I_navigate_to_the_test_application() {
    LOGGER.info("I navigate to the test application");
    seleniumClient.open("bdd/");
    seleniumClient.waitForPageToLoad("2000");
    webDriver.get(APP_ROOT);
    webElement = webDriver.findElement(By.id("pageLink"));
    Assert.assertEquals("pageLink", webElement.getAttribute("id"));
    Assert.assertEquals(APP_ROOT +"modeltest?firstAttributeValue=123&secondAttributeValue=abc", webElement.getAttribute("href"));
    Assert.assertEquals("Click here", webElement.getText());
  }

  @When("^I click on the link$")
  public void when_I_click_on_the_link() {
    LOGGER.info("I click on the link");
    webElement.click();
  }

  @Then("^I should see an expression test page$")
  public void then_I_should_see_an_expression_test_page() {
    LOGGER.info("I should see an expression test page");
    Assert.assertEquals("/bdd/modeltest", webDriver.getTitle());
    assertThat(webDriver.findElement(By.id("intro")).getText(), equalTo("Testing expression language support"));
    assertThat(webDriver.findElement(By.id("firstAttribute")).getText(), equalTo("firstAttributeValue = 123"));
    assertThat(webDriver.findElement(By.id("secondAttribute")).getText(), equalTo("secondAttributeValue = abc"));
    assertThat(webDriver.findElement(By.id("thirdAttribute")).getText(), equalTo("thirdAttributeValue = internalAttributeValue"));
  }

  @After
  public void destroySelenium() {
    LOGGER.info("stopping selenium driver");
    webDriver.close();
    seleniumClient.stop();
  }
}
