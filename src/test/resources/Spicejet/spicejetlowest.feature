Feature: Spicejet lowestfare

  Scenario Outline: 
    Given open chrome browser
    And launch site using "https://www.spicejet.com"
    Then select roundtrip
    When fill departure city "<x>"
    Then clear destination
    Then fill destination city "<y>"
    When select a departure year <dy> departure month "<dm>" and departure day <dd>
    # Then select Students from passengers drop down
    And click on arrival year <ay> arrival month "<am>" and arrival day <ad>
    Then click on Search Flight button
    And select lowest fare flight for departure
    And select lowest fare flight for return
    Then click continu

    Examples: 
      | x     | y         | dy   | dm  | dd | ay   | am  | ad |
      | Delhi | Kolkata| 2022 | May |  1 | 2022 | May |  5 |
