package com.trybe.acc.java.minhasseries.exception;

/** Classe ArgumentoIlegalException. */
public class SerieExistenteException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**  Método contrutor. */
  public SerieExistenteException() {
    super("Série Existente");
  }

}
