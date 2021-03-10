Feature: First Tests Feature
  Scenario: First Test of first tests
    Given homepage is opened
    When I click Contact link
    Then Contact Us page is opened

#    Scenario Outline: Second Test
#      Given homepage is opened
#      When I click Contact link
#      Then "<param>" is displayed
#      And <param2> is displayed
#      Examples:
#        | param | param2 |
#        | aaa | bbb |