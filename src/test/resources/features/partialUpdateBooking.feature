#language: es

  Característica: actualizar una parte de una reserva

    Escenario: el usuario quiere actualizar una parte de una reserva
      Dado que el usuario posee un token por estar registrado
      Cuando el usuario actualiza los datos de la reserva
      Entonces en la respuesta del sistema se observa los datos que fueron actualizados