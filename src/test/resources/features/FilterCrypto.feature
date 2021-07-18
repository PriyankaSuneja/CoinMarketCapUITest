Feature: Filter crypto currencies on Coin Market Cap
  As a user of the coinmarketcap
  I should be able to filter the currencies based on Market Cap and Price
  And verify the filters are working properly

  @uiTest @filterTest
  Scenario Outline: User filter crypto currencies on Coin Market Cap
    Given the user visit coin market cap home page
    When the user add filter for Market Cap between <Min_MCap> and <Max_MCap>
    And the user add filter for price between <Min_Price> and <Max_Price>
    And the user click show results
    Then verify that the page should display crypto currencies matching the criteria i.e. <Min_MCap> <Max_MCap> and <Min_Price> <Max_Price>
    Examples:
      | Min_MCap             |  Max_MCap         | Min_Price | Max_Price |
      |  1000000000          |  10000000000      | 101       |  1000     |
      |  10000000000         |  100000000000     | 101      |  10000    |