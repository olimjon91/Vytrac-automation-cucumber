package com.vytrack.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                  "html:target/default-cucumber-reports",
                  "rerun:target/rerun.txt"
        },

        features = "src/test/resources/com/vytrack/features",
        glue = "com/vytrack/step_defenitions",
      tags = {"@login"}
//        dryRun = false

)
public class CukesRunner {

}
