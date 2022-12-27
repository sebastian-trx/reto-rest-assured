#language: es
  Característica: crear un token de autorizacion


    Escenario: el usuario envia un userName y una password validos
      Dado que el usuario posee un username: "admin" y password: "password123"
      Cuando el usuario realiza una peticion para crear un token de autorizacion
      Entonces el sistema responde con un status code exitoso y un token de autorizacion


