Feature: Prueba en Spotify

  Scenario: 1
    Given Ingresar al sitio de Spotify
    When Ingresar a a la seccion premium.
    And validos que se encuentre los nombres de los planes: individual, premium y familiar


  Scenario Outline:2
    Given Ingresar al sitio de Spotify
    When Ingresar a la seccion de registro
    And Completo el campo email con <email>
    Then Se muestra el mensaje <mensaje>


    Examples:
      | email         | mensaje                                                                                              |
      |               | Es necesario que introduzcas tu correo electronico                                                   |
      | fff           | Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com |
      | test@test.com | Este correo electrónico ya está conectado a una cuenta. Inicia sesión.                               |

  Scenario: 3
    Given Me cambio al sitio de Terminos y condiciones "https://www.spotify.com/uy/legal/end-user-agreement/"
    When Validar que encuentro los link
    Then  validar que se encuentre "Disfrutando Spotify"
    And  validar que se encuentre "Pagos, cancelaciones y periodo de reflexión"
    And validar que se encuentre "Uso de nuestros servicios"


