package pages;

import static core.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import core.BasePage;

public class FuncionariosPage extends BasePage {

	private By btnNovoFuncionario = By.xpath("/html/body/nav/div/div/ul/li[2]/a");
	private By campoPesquisar = By.xpath("//input[@type='search']");
	private By btnEditar = By.xpath("/html/body/div/div[2]/div/table/tbody/tr[1]/td[6]/a[2]/button");
	private By btnExcluir = By.xpath("/html/body/div/div[2]/div/table/tbody/tr[1]/td[6]/a[1]/button");
	private By campoNome = By.xpath("//th[@class='text-center sorting_asc']");

	public String validarPageFuncionarios() {
		return obterTexto(campoNome);
	}

	public void clicarEmNovoFuncionario() {
		clicar(btnNovoFuncionario);
	}

	public void pesquisarNome() {
		escrever(campoPesquisar, "Mateus Rodrigues");
	}

	public void clicarEmEditar() {
		clicar(btnEditar);
	}

	public void clicarEmExcluir() {
		clicar(btnExcluir);
	}

	public void obterMsgSucesso() {
		String actualString = getDriver()
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		String expectedString = "SUCESSO";

		assertTrue(actualString.contains(expectedString));
	}

	public void obterMsgDeAlteracao() {
		String actualString = getDriver()
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		String expectedString = "atualizadas com sucesso";

		assertTrue(actualString.contains(expectedString));
	}

	public void obterMsgDeExclusao() {
		String actualString = getDriver()
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		String expectedString = "removido com sucesso";

		assertTrue(actualString.contains(expectedString));
	}
}
