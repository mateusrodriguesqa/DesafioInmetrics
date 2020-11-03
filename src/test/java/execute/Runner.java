package execute;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import utils.Utilitarios;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/SiteInmetrics.feature", 
      glue = "",
      tags = { "@TestesInmetrics" }, 
      plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
    			 "json:src/test/resources/evidencias/json/report.json", },
      monochrome = true, 
      snippets = SnippetType.CAMELCASE, 
      dryRun = false, 
      strict = true)

public class Runner {
	
	@BeforeClass
	public static void screenshotFileCheck() {
		Utilitarios.screenshotsCriarFiles();
		Utilitarios.deletandoScreenshotsFile();
	}
}
