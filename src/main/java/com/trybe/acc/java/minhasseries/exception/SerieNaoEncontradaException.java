package com.trybe.acc.java.minhasseries.exception;

public class SerieNaoEncontradaException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**  Método contrutor. */
  public SerieNaoEncontradaException() {
    super("Série não encontrada");
  }

}
