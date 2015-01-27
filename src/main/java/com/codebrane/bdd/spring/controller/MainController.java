package com.codebrane.bdd.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class MainController {

	private static final Logger logger = Logger.getLogger(MainController.class);

	// http://localhost:8080/bdd
	@RequestMapping("/")
	public String root() {
		return "jsp/root";
	}

	// http://localhost:8080/bdd/modeltest?firstAttributeValue=123&secondAttributeValue=abc
	@RequestMapping(value = "/modeltest", method = RequestMethod.GET)
	public String doModelTest(Locale locale,
														@RequestParam("firstAttributeValue") String firstAttributeValue,
													  @RequestParam("secondAttributeValue") String secondAttributeValue,
													  Model model) {
		logger.info("modeltest requested with locale : " + locale.getLanguage());
		model.addAttribute("firstAttributeName", firstAttributeValue);
		model.addAttribute("secondAttributeName", secondAttributeValue);
    model.addAttribute("thirdAttributeName", getInternalAttribute());
		return "jsp/modeltest";
	}

  public String getInternalAttribute() {
    return "internalAttributeValue";
  }
}
