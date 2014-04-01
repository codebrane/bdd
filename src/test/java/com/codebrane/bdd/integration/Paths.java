package com.codebrane.bdd.integration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Paths {
  private static HashMap<String, String> paths = null;

  static {
    paths = new HashMap<String, String>();
    try {
      // Spring needs file:// prepended...
      paths.put("servlet.context.home", "file:///" + new File("src/main/webapp").getCanonicalPath());
      paths.put("applicationContext.xml", "file:///" + new File("src/main/webapp/WEB-INF/config/spring/applicationContext.xml").getCanonicalPath());
    }
    catch(IOException ioe) {
    }
  }

  public static String path(String fileName) {
    return paths.get(fileName);
  }
}
