Feature: Application Login
  Scenario Outline: Home Page default Login
    Given initialize chrome driver
    And navigate to "http://practice.automationtesting.in/"
    And click on My Account
    When user enter the <username>  and <password>
    Then validate user logged in successfully

    Examples:
    |username               |password   |
    |testingperson@gmail.com|q!w2e#r4   |
    |testing@gmail.com      |1234       |

