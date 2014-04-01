package com.codebrane.bdd.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static junit.framework.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/config/spring/applicationContext.xml"})
public class MainControllerTest extends IntegrationTest {
  @Resource
  private WebApplicationContext webApplicationContext;
  private MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void test() {
    try {
      logger.info("MainController Integration Test");
      mockMvc.perform(get("/modeltest").param("firstAttributeValue", "111").param("secondAttributeValue", "222"))
              .andExpect(status().isOk())
              .andExpect(view().name("jsp/modeltest"))
              .andExpect(model().attribute("firstAttributeName", "111"))
              .andExpect(model().attribute("secondAttributeName", "222"))
              .andExpect(model().attribute("thirdAttributeName", "internalAttributeValue"));
    }
    catch(Exception e) {
      fail(e.getMessage());
    }
  }
}
