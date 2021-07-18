Feature: Viewing crypto currencies on Coin Market Cap home page
  As a user of the coinmarketcap
  I should be able to view cyrpto currenices based on number of selected rows
  And confirm the results are displaying appropriately

  @uiTest @viewTest
  Scenario Outline: User viewing crypto currencies on Coin Market Cap home page
    Given the user visit coin market cap home page
    When the user select <Row_Count> from show rows dropdown
    Then verify that the page should display <Row_Count> crypto currencies
    Examples:
      | Row_Count |
      |   100     |
      |   20      |