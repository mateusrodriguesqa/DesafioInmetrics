package test.java.pages;

import org.openqa.selenium.By;

import test.java.core.BasePage;

public class CadastroPage extends BasePage {

	private By nomeUsuario = By.xpath("//input[@class='input100'][@name='username']");
	private By senhaUsuario = By.xpath("//input[@class='input100'][@name='pass']");
	private By confirmarSenha = By.xpath("//input[@class='input100'][@name='confirmpass']");
	private By btnCadastrar = By.xpath("//button[@class='login100-form-btn']");

	public void inserirDadosCadastro(String nome, String senha) {
		escrever(nomeUsuario, nome);
		escrever(senhaUsuario, senha);
		escrever(confirmarSenha, senha);
	}

	public void clicarEmCadastrar() {
		clicar(btnCadastrar);
		aguarda(200);
	}
}
