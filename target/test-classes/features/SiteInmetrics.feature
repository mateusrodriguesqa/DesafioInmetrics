@TestesInmetrics
Feature: Testes Funcionais Site Inmetrics

  @CadastrarUsuario
  Scenario Outline: Cadastrar usuario
    Given que o usuario acesse o site Inmetrics
    When clique em "Cadastre-se"
    And insira o nome <nome> e senha <senha>
    And clique em Cadastrar
    Then o usuario sera direcionado para a pagina de Login

    Examples: 
      | nome              | senha      |
      | "TesteMateusOito" | "teste123" |

  @LoginUsuario
  Scenario Outline: Login de usuario
    Given que o usuario acesse o site Inmetrics
    When insira os dados de usuario <usuario> e senha <senha>
    And clique em "Entre"
    Then o usuario sera direcionado para a pagina de Funcionarios

    Examples: 
      | usuario            | senha      |
      | "TesteMateusCinco" | "teste123" |

  @CadastrarFuncionario
  Scenario Outline: Cadastrar funcionario
    Given que o usuario acesse o site Inmetrics
    When insira os dados de usuario <usuario> e senha <senha>
    And clique em "Entre"
    And clique em Novo Funcionario
    And insira os dados para cadastro
    And clique em Enviar
    Then o usuario sera cadastrado com sucesso

    Examples: 
      | usuario            | senha      |
      | "TesteMateusCinco" | "teste123" |

  @EditarFuncionario
  Scenario: Editar funcionario
    Given que o usuario esteja na pagina de Funcionarios
    And insira o nome do funcionario cadastrado no campo de pesquisa
    And clique no botao Editar
    And realize uma alteracao
    And clique em Enviar
    Then a alteracao sera enviada com sucesso

  @ExcluirFuncionario
  Scenario: Excluir funcionario
    Given que o usuario esteja na pagina de Funcionarios
    And insira o nome do funcionario cadastrado no campo de pesquisa
    And clique no botao Excluir
    Then o funcionario sera excluido com sucesso
