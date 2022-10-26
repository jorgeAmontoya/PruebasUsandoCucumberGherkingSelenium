Feature: (Nombre general) Probar la busqueda en Google (colocar cosas que tengan sentido)
  Scenario: (Titulo del escenario) Busco algo en Google
    Given  I am on the Google search page
    When I enter a search criteria
    And click on the search button
    Then the results match the criteria

