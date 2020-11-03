package test.java.core;

import static test.java.core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private static WebDriverWait wait;

	// Metodo para clicar
	public void clicar(By elemento) {
		wait = new WebDriverWait(getDriver(), 10); // espera por dez sengundos
		wait.until(ExpectedConditions.elementToBeClickable(elemento));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
		getDriver().findElement(elemento).click();
	}

	// Metodo para escrever
	public void escrever(By elemento, String texto) {
		getDriver().findElement(elemento).sendKeys(texto);
	}

	//Metodo para escrever devagar 
	public void escreverSlow(By elemento, String texto) {
		WebElement txtValor = getDriver().findElement(elemento);
		List<String> list = Arrays.asList(texto.split(""));
		list.forEach(f -> txtValor.sendKeys(f));
	}
	
	// Metodo para limpar campo
	public void limparCampo(By elemento) {
		getDriver().findElement(elemento).clear();
	}

	// Metodo para selecionar Combo
	public void selecionarcombo(By elemento, String valor) {
		Select selecionar = new Select(getDriver().findElement(elemento));
		selecionar.selectByVisibleText(valor);
	}

	// Metodo para obter texto
	public String obterTexto(By elemento) {
		return getDriver().findElement(elemento).getText();
	}

	// Metodo para aguardar
	public void aguarda(int milissegundos) {
		try {
			Thread.sleep(milissegundos);
		} catch (Exception e) {
			System.out.println("Erro ao aguardar");
		}
	}
}
