#1. Необходимо добавить в учебный проект фреймворк bdd (Лекция
#Automation 13 “BDDFramework”)
#2. Необходимо реализовать в bdd сценарий 1 – любой тест из задания
#Automation task1 – Gherkin
#3. Реализовать имплементацию Scenario_Outline (бизнес логика –любая)
#4. Реализовать в bdd индивидуальное задание по автотестированию

#    В EditConfig в Run configurations - Glue прописать путь к папке, где лежат steps (com.stv.bdd.steps)

Feature: FinalTest

  Scenario Outline: 01. Error Message
    Given I am on the home page
    When I enter empty username "<usernameBDD>"
    And I enter password "<passwordBDD>"
    Then I click LogIn
    And I should see Error Message
    Examples:
      | usernameBDD   | passwordBDD     |
      |               | Password123     |

  Scenario: 02. Navigate to About Us page on the website
    Given I am on the home page
    When I click to About Us page
    Then ParaSoft Demo Website appears
    And I should see www.parasoft.com link

  Scenario: 03. Navigate to Home Page on the website
    Given I am on the About Us page
    When I click on ParaSoft Logo
    Then I am exactly on the home page
    And There is no ParaSoft Demo page

  Scenario: 04. Double click on ParaSoft Logo
    Given I am on the home page
    When I click on ParaSoft Logo twice
    Then I am exactly on the home page