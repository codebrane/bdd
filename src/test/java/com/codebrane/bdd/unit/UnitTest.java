package com.codebrane.bdd.unit;

import org.junit.BeforeClass;

import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public abstract class UnitTest {
  protected static Logger logger;

  @BeforeClass
  public static void initUserTest() {
    loadLogger();
  }

  protected static void loadLogger() {
    logger = Logger.getLogger("com.codebrane.bdd");
    StreamHandler sh = new StreamHandler(System.out, new SimpleFormatter());
    logger.addHandler(sh);
  }
}
