package com.trybe.acc.java.minhasseries.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Episodio {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Integer numero;
  private Integer duracaoEmMinutos;

  /** Método construtor. */
  public Episodio(Long id, Integer numero, Integer duracaoEmMinutos) {
    this.id = id;
    this.numero = numero;
    this.duracaoEmMinutos = duracaoEmMinutos;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public Integer getDuracaoEmMinutos() {
    return duracaoEmMinutos;
  }

  public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
    this.duracaoEmMinutos = duracaoEmMinutos;
  }

}
