package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import core.BasePage;

public class LoginPage extends BasePage {

	private By nomeUsuario = By.xpath("//input[@class='input100'][@name='username']");
	private By senhaUsuario = By.xpath("//input[@class='input100'][@name='pass']");
	private By btnEntre = By.xpath("//button[@class='login100-form-btn']");
	private By btnCadastrese = By.xpath("//a[@class='txt2 bo1']");
	private By textLogin = By.xpath("//span[@class='login100-form-title p-b-1']");

	public void abrirUrl() {
		getDriver().get("http://www.inmrobo.tk/accounts/login/#");
	}

	public void inserirNomeeSenha(String nome, String senha) {
		aguarda(5000);
		escrever(nomeUsuario, nome);
		escrever(senhaUsuario, senha);
	}

	public void clicarEm(String botao) {
		aguarda(5000);
		switch (botao) {
		case "Cadastre-se":
			clicar(btnCadastrese);
			break;
		case "Entre":
			clicar(btnEntre);
			break;
		}
		aguarda(2000);
	}

	public void clicarEmCadastrese() {
		clicar(btnCadastrese);
	}

	public String obterTextologin() {
		return obterTexto(textLogin);
	}
}
