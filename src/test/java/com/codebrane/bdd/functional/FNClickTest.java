package com.codebrane.bdd.functional;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(
format = {"pretty"},
tags = {"@Click"})
// Executing this class as any JUnit test class will run all features found on the classpath
// in the same package as this class
public class FNClickTest {
}
