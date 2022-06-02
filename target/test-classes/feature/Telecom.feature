Feature: Registrar Datos de un cliente
  Yo como usuario de la pagina DemoGuru99
  Quiero registrar los datos de un cliente
  Para obtener un plan de telecomunicaciones



  Scenario: Cuando registro datos de manera correcta.
    Given la web esta disponible
    When doy clic en telecom project
    And aregamos un nuevo cliente
    And ingreso datos del cliente
      | check | nombre       | apellido     | email           | direccion            | telefono |
      | done  | Marco Antonio | Mamani Chura | marco@gmail.com | Barrio nueva america | 78140596 |

  Scenario: Cuando registro datos desde un csv.
    Given la web esta disponible
    When doy clic en telecom project
    And aregamos un nuevo cliente
    And ingreso datos del cliente desde un csv






















