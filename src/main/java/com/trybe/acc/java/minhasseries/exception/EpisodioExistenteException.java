package com.trybe.acc.java.minhasseries.exception;

public class EpisodioExistenteException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**  Método contrutor. */
  public EpisodioExistenteException() {
    super("Episódio Existente");
  }

}
