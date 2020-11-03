package test.java.execute;

import java.io.File;
import java.time.LocalDateTime;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import test.java.utils.Utilitarios;

public class HookAfter {

	@After(order = 1)
	public void screenshot(Scenario scenario) {

		String nome = scenario.getName().replace(" ", "_") + "_" + Utilitarios.formatter().format(LocalDateTime.now());
		String evidencia;

		if (!scenario.isFailed()) {
			evidencia = "sucesso";
		} else {
			evidencia = "erro";
		}
		String caminho = Utilitarios.caminhoScreenshot() + evidencia + File.separator;

		Utilitarios.fullPageScreenshot(caminho, nome);
	}
}
