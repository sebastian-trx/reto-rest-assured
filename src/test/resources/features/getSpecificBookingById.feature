#language: es

  Característica: obtener una reserva especifica por medio del id proporcionado



  Escenario: el usuario quiere obtener una reserva especifica por medio del id
    Dado que el usuario posee un id de una reserva existente
    Cuando el usuario realiza una peticion para obtener la informacion de una reserva id = 90
    Entonces el sistema responde con un status code exitoso y la informacion de la reserva en formato JSON
