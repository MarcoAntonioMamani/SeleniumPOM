Feature: Comprar articulo con una tarjeta de credito
  Yo como usuario de la pagina DemoGuru99
  Quiero comprar un articulo con una tarjeta de credito
  Para ahorrar tiempo en hacer tramite personal



  Scenario: Cuando no hay transacciones de Tarjeta
    Given La pagina esta estable
    When doy click en generar tarjeta
    And capturamos datos de la tarjeta
    And doy click en ver limite de la tarjeta
    And consultamos datos de limite de la tarjeta
    Then puedo capturar los mensajes del balance de tarjeta "Check Credit Balance"
    And capturo el mensaje de "This Card Not Any Transactions"


  Scenario: Cuando compro varios productos
    Given La pagina esta estable
    When doy click en generar tarjeta
    And capturamos datos de la tarjeta
    