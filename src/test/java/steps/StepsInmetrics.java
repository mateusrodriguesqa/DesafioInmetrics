package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CadastroPage;
import pages.FuncionariosPage;
import pages.LoginPage;
import pages.NovoFuncionarioPage;

public class StepsInmetrics {

	private CadastroPage cadastroPage = new CadastroPage();
	private FuncionariosPage funcionariosPage = new FuncionariosPage();
	private LoginPage loginPage = new LoginPage();
	private NovoFuncionarioPage novoFuncionarioPage = new NovoFuncionarioPage();

	@Given("que o usuario acesse o site Inmetrics")
	public void queOUsuarioAcesseOSiteInmetrics() {
		loginPage.abrirUrl();
	}

	@When("clique em {string}")
	public void cliqueEm(String btn) {
		loginPage.clicarEm(btn);
	}

	@When("insira o nome {string} e senha {string}")
	public void insiraONomeESenha(String nome, String senha) {
		cadastroPage.inserirDadosCadastro(nome, senha);
	}

	@Then("o usuario sera direcionado para a pagina de Login")
	public void oUsuarioSeraDirecionadoParaAPaginaDeLogin() {
		assertEquals("Login", loginPage.obterTextologin());
	}

	@When("insira os dados de usuario {string} e senha {string}")
	public void insiraOsDadosDeUsuarioESenha(String nome, String senha) {
		loginPage.inserirNomeeSenha(nome, senha);
	}

	@Then("o usuario sera direcionado para a pagina de Funcionarios")
	public void oUsuarioSeraDirecionadoParaAPaginaDeFuncionarios() {
		assertEquals("Nome", funcionariosPage.validarPageFuncionarios());
	}

	@When("realize o login")
	public void realizeOLogin(String nome, String senha) {
		loginPage.inserirNomeeSenha(nome, senha);
	}

	@When("insira os dados para cadastro")
	public void insiraOsDadosParaCadastro() {
		novoFuncionarioPage.inserirDadosCadastroFuncionario();
	}

	@Then("o usuario sera cadastrado com sucesso")
	public void oUsuarioSeraCadastradoComSucesso() {
		funcionariosPage.obterMsgSucesso();
	}

	@When("insira o nome do funcionario cadastrado no campo de pesquisa")
	public void insiraONomeDoFuncionarioCadastradoNoCampoDePesquisa() {
		funcionariosPage.pesquisarNome();
	}

	@When("clique no botao Editar")
	public void cliqueNoBotaoEditar() {
		funcionariosPage.clicarEmEditar();
	}

	@When("realize uma alteracao")
	public void realizeUmaAlteracao() {
		novoFuncionarioPage.realizarAlteracao();
	}

	@Then("a alteracao sera enviada com sucesso")
	public void aAlteracaoSeraEnviadaComSucesso() {
		funcionariosPage.obterMsgDeAlteracao();
	}

	@When("clique no botao Excluir")
	public void cliqueNoBotaoExcluir() {
		funcionariosPage.clicarEmExcluir();
	}

	@Then("o funcionario sera excluido com sucesso")
	public void oFuncionarioSeraExcluidoComSucesso() {
		funcionariosPage.obterMsgDeExclusao();
	}

	@When("clique em Cadastrar")
	public void cliqueEmCadastrar() {
		cadastroPage.clicarEmCadastrar();
	}

	@When("clique em Novo Funcionario")
	public void cliqueEmNovoFuncionario() {
		funcionariosPage.clicarEmNovoFuncionario();
	}

	@Given("que o usuario esteja na pagina de Funcionarios")
	public void queOUsuarioEstejaNaPaginaDeFuncionarios() {
		assertEquals("Nome", funcionariosPage.validarPageFuncionarios());
	}

	@When("clique em Enviar")
	public void cliqueEmEnviar() {
		novoFuncionarioPage.clicarEmEnviar();
	}
}
