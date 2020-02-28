@runCrudProcessos
Feature: Making a simple crud to Processos API

  Background:
    Given that the user is in the processos page

  Scenario: Simple POST
    And user informs value "5" in the field "vara"
    And user informs value "666" in the field "numero_processo"
    And user informs value "Guarda" in the field "natureza"
    And user informs value "Joséfa x Mario" in the field "partes"
    And user informs value "S" in the field "urgente"
    And user informs value "N" in the field "arbitramento"
    And user informs value "Frederico Monteiro" in the field "assistente_social"
    And user informs value "2020-02-12" in the field "data_entrada"
    And user informs value "2020-02-20" in the field "data_saida"
    And user informs value "2020-02-13" in the field "data_agendamento"
    And user informs value "Aguardando" in the field "status"
    And user informs value "Nada a Declarar" in the field "observacao"
    When the user clicks in the add button
    Then the user should see the message "Created"
    And the user should see the field "vara" with the value "5"

  Scenario Outline: Simple GET of existing processo
    And the user would like to see the processo with the id <id>
    When the user clicks in the load button
    Then the user should see the message "<message>"

    Examples:
      | id | message       |
      | 7  | OK             |
      | 666| Not Found      |

  Scenario: Simple PUT in existing processo
    And the user would like to see the processo with the id 7
    And user informs value "8" in the field "vara"
    And user informs value "666" in the field "numero_processo"
    And user informs value "Guarda" in the field "natureza"
    And user informs value "Joséfa x Mario" in the field "partes"
    And user informs value "S" in the field "urgente"
    And user informs value "N" in the field "arbitramento"
    And user informs value "Frederico Monteiro" in the field "assistente_social"
    And user informs value "2020-02-12" in the field "data_entrada"
    And user informs value "2020-02-20" in the field "data_saida"
    And user informs value "2020-02-13" in the field "data_agendamento"
    And user informs value "Aguardando" in the field "status"
    And user informs value "Nada a Declarar" in the field "observacao"
    When the user clicks in the save button
    Then the user should see the message "OK"
    And the user should see the field "vara" with the value "8"

  Scenario: Simple DELETE after simple POST
    And user informs value "5" in the field "vara"
    And user informs value "999" in the field "numero_processo"
    And user informs value "Guarda" in the field "natureza"
    And user informs value "Joséfa x Mario" in the field "partes"
    And user informs value "S" in the field "urgente"
    And user informs value "N" in the field "arbitramento"
    And user informs value "Frederico Monteiro" in the field "assistente_social"
    And user informs value "2020-02-12" in the field "data_entrada"
    And user informs value "2020-02-20" in the field "data_saida"
    And user informs value "2020-02-13" in the field "data_agendamento"
    And user informs value "Aguardando" in the field "status"
    And user informs value "Nada a Declarar" in the field "observacao"
    And the user clicks in the add button
    When the user clicks in the delete button
    Then the user should see the message "No Content"