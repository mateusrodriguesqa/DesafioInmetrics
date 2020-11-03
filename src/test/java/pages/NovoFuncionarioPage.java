package test.java.pages;

import org.openqa.selenium.By;

import test.java.core.BasePage;

public class NovoFuncionarioPage extends BasePage {

	private By nomeFuncionario = By.xpath("//input[@id='inputNome']");
	private By cpf = By.xpath("//input[@id='cpf']");
	private By sexo = By.xpath("//select[@id='slctSexo']");
	private By admissao = By.xpath("//input[@id='inputAdmissao']");
	private By cargo = By.xpath("//input[@id='inputCargo']");
	private By salario = By.xpath("//input[@id='dinheiro']");
	private By tipoContratacaoPj = By.xpath("//input[@id='pj']");
	private By tipoContratacaoClt = By.xpath("//input[@id='clt']");
	private By btnenviar = By.xpath("//input[@class='cadastrar-form-btn'][@type='submit']");

	public void inserirDadosCadastroFuncionario() {
		aguarda(2000);
		escrever(nomeFuncionario, "Mateus Rodrigues");
		escreverSlow(cpf, "46582942069");
		clicar(sexo);
		selecionarcombo(sexo, "Masculino");
		escrever(admissao, "01012020");
		escrever(cargo, "Analista de testes");
		escrever(salario, "700000");
		clicar(tipoContratacaoPj);
	}

	public void clicarEmEnviar() {
		clicar(btnenviar);
	}

	public void realizarAlteracao() {
		aguarda(200);
		clicar(tipoContratacaoClt);
	}
}