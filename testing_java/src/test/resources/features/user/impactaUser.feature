@runCrudTestesDaImpacta
Feature: Testes da impacta

  Scenario Outline: Buscar todos os usuários
    Given user would like to see user number <id>
    When user access user page
    Then user should see "<result>" message

    Examples:
      | id | result    |
      | 22 | success   |
      | 1  | not found |

  Scenario Outline: Gravar um usuário
    Given user would like to save a user
      And user informs login with value equal "<login_value>"
      And user informs age with value equal "<age_value>"
      And user informs full_name with value equal "<full_name_value>"
      And user informs email with value equal "<email_value>"
      And user clicks on save button
    When user access user page
    Then user should see "success" message
      And user should see login with value "<login_value>"
      And user should see full_name with value "<full_name_value>"
      And user should see email with value "<email_value>"
      And user should see age with value <age_value>

    Examples:
      | login_value       | age_value | full_name_value   | email_value       |
      | login teste fred  | 99        | nome test fred    | email teste fred  |

