package com.codebrane.bdd.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	// http://localhost:8080/bdd
	@RequestMapping("/")
	public String root() {
		return "jsp/root";
	}

	// http://localhost:8080/bdd/modeltest?firstAttributeValue=123&secondAttributeValue=abc
	@RequestMapping(value = "/modeltest", method = RequestMethod.GET)
	public String doModelTest(@RequestParam("firstAttributeValue") String firstAttributeValue,
													  @RequestParam("secondAttributeValue") String secondAttributeValue,
													  Model model) {
		model.addAttribute("firstAttributeName", firstAttributeValue);
		model.addAttribute("secondAttributeName", secondAttributeValue);
    model.addAttribute("thirdAttributeName", getInternalAttribute());
		return "jsp/modeltest";
	}

  public String getInternalAttribute() {
    return "internalAttributeValue";
  }
}
