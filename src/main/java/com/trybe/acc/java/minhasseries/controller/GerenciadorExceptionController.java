package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.exception.EpisodioExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GerenciadorExceptionController {

  /** Método que recebe a exceção SerieExistenteException.*/
  @ExceptionHandler(SerieExistenteException.class)
  public ResponseEntity<HashMap<String, String>> handleRecursoNaoEncontradoException(
      SerieExistenteException exception) {
    HashMap<String, String> mensagem = new HashMap<String, String>();
    mensagem.put("error", exception.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(mensagem);
  }

  /** Método que recebe a exceção SerieNaoEncontradaException.*/
  @ExceptionHandler(SerieNaoEncontradaException.class)
  public ResponseEntity<HashMap<String, String>> handleRecursoNaoEncontradoException(
      SerieNaoEncontradaException exception) {
    HashMap<String, String> mensagem = new HashMap<String, String>();
    mensagem.put("error", exception.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
  }

  /** Método que recebe a exceção EpisodioExistenteException.*/
  @ExceptionHandler(EpisodioExistenteException.class)
  public ResponseEntity<HashMap<String, String>> handleRecursoNaoEncontradoException(
      EpisodioExistenteException exception) {
    HashMap<String, String> mensagem = new HashMap<String, String>();
    mensagem.put("error", exception.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(mensagem);
  }

  /** Método que recebe a exceção Fallback.*/
  //@ExceptionHandler(Exception.class)
  //public ResponseEntity<HashMap<String, String>> handleFallback() {
  //  HashMap<String, String> mensagem = new HashMap<String, String>();
  //  mensagem.put("error", "Serviço temporariamente indisponível");
  //  return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(mensagem);
  //}

}
