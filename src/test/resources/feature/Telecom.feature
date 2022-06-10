Feature: Registrar Datos de un cliente
  Yo como usuario de la pagina DemoGuru99
  Quiero registrar los datos de un cliente
  Para obtener un plan de telecomunicaciones


  @Pruebita
  Scenario: Cuando registro datos de manera correcta.
    Given la web esta disponible
    When doy clic en telecom project
    And aregamos un nuevo cliente
    And ingreso datos del cliente
      | check | nombre       | apellido     | email           | direccion            | telefono |
      | done  | Marco Antonio | Mamani Chura | marco@gmail.com | Barrio nueva america | 78140596 |
    And capturo el customer del cliente
    And Doy clic en Agregar tarifa de customer
    And ingreso el customer
    Then visualizo el nombre del cliente y el estado
      | nombre        | estado |
      | Marco Antonio | active |
    And doy click en tarifa
    And doy clic en boton tarifa
    Then Valido mensaje de felicitacion "Congratulation Tariff Plan assigned"
    And Regreso al Home

  @Pruebita
  Scenario: Cuando registro datos desde un csv.
    Given la web esta disponible
    When doy clic en telecom project
    And aregamos un nuevo cliente
    And ingreso datos del cliente desde un csv


  @Pruebita
  Scenario: Validar Mensaje de Alerta.
    Given la web esta disponible
    When doy clic en telecom project
    And aregamos un nuevo cliente
    And doy click Agregar Cliente
    Then obtengo el mensaje de alerta























