package com.application.inventApp.Exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.application.inventApp.Enums.Severity;
import com.auth0.jwt.exceptions.JWTVerificationException;

@ControllerAdvice
public class ControlllerAdvice {

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<ExceptionDetails> dataIntegrityViolationException(DataIntegrityViolationException e) {
    if (e.getMostSpecificCause().getMessage().contains("Ya existe la llave")
        && e.getMostSpecificCause().getMessage().contains("uk35t4wyxqrevf09uwx9e9p6o75")) {
      return new ResponseEntity<>(
          new ExceptionDetails("Ya existe una categoria con el nombre proporcionado", Severity.ERROR),
          HttpStatus.BAD_REQUEST);

    }
    return new ResponseEntity<>(
        new ExceptionDetails("Violación de integridad de datos: " + e.getMostSpecificCause().getMessage(),
            Severity.ERROR),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UsernameNotFoundException.class)
  public ResponseEntity<ExceptionDetails> usernameNotFoundException(UserNotFountException e) {
    return new ResponseEntity<>(new ExceptionDetails("EL usuario ", Severity.ERROR), HttpStatus.NOT_FOUND);

  }

  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity<ExceptionDetails> badCredentialsException(BadCredentialsException e) {
    return new ResponseEntity<>(new ExceptionDetails("El usuario o contraseña son incorrectos", Severity.ERROR),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(JWTVerificationException.class)
  public ResponseEntity<ExceptionDetails> tokenInvalid(JWTVerificationException e) {
    return new ResponseEntity<>(new ExceptionDetails("Token invalido o expirado", Severity.ERROR),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ExceptionDetails> notFoundException(NotFoundException e) {
    return new ResponseEntity<>(new ExceptionDetails(e.getMessage(), Severity.ERROR),
        HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionDetails> globalExceptions(Exception e) {
    return new ResponseEntity<>(new ExceptionDetails("Internal Server Error", Severity.ERROR),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
