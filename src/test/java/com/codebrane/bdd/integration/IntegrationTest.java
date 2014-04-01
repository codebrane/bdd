package com.codebrane.bdd.integration;

import org.junit.BeforeClass;

import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public abstract class IntegrationTest {
  protected static Logger logger;

  @BeforeClass
  public static void initMatrixTest() {
    loadLogger();
  }

  protected static void loadLogger() {
    logger = Logger.getLogger("com.codebrane.bdd");
    StreamHandler sh = new StreamHandler(System.out, new SimpleFormatter());
    logger.addHandler(sh);
  }
}
