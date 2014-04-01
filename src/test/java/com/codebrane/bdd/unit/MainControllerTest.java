package com.codebrane.bdd.unit;

import com.codebrane.bdd.spring.controller.MainController;
import org.junit.Assert;
import org.junit.Test;

public class MainControllerTest extends UnitTest {
  @Test
  public void test() {
    logger.info("MainControllerTest Unit Test");
    MainController mainController = new MainController();
    Assert.assertEquals("internalAttributeValue", mainController.getInternalAttribute());
  }
}
