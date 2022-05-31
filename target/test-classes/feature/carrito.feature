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


  Scenario: Cuando compro una sola vez
    Given La pagina esta estable
    When doy click en generar tarjeta
    And capturamos datos de la tarjeta
    And Capturo monto del producto
    And Ingreso la cantidad "4" a comprar
    And Doy click en Agregar
    And Validamos los datos de tarjeta
    Then Valido el pago exitoso "Payment successfull!"
    And capturo el numero de orden
    And doy click
    And valido mensaje Home "Mother Elephant With Babies Soft Toy"


  Scenario Outline: Cuando compro varias veces
    Given La pagina esta estable
    When doy click en generar tarjeta
    And capturamos datos de la tarjeta
    And Capturo monto del producto
    And Ingreso la cantidad "<cantidad>" a comprar
    And Doy click en Agregar
    And Validamos los datos de tarjeta
    Then Valido el pago exitoso "Payment successfull!"
    And capturo el numero de orden
    And doy click
    And valido mensaje Home "Mother Elephant With Babies Soft Toy"
    Examples:
    | cantidad |
    | 1        |
    | 9        |
    | 0        |
    | 10       |
    #| 10       |



  Scenario: Validar Saldo de Tarjeta
    Given La pagina esta estable
    When doy click en generar tarjeta
    And capturamos datos de la tarjeta
    And Capturo monto del producto
    And Ingreso la cantidad "4" a comprar
    And Doy click en Agregar
    And Validamos los datos de tarjeta
    And capturo el numero de orden
    And doy click y voy a check credit
    And consultamos datos de limite de la tarjeta

