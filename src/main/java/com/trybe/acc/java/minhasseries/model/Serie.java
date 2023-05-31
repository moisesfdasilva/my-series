package com.trybe.acc.java.minhasseries.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Serie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nome;
  private List<Episodio> episodios;

  public Serie(String nome) {
    this.nome = nome;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Episodio> GetEpisodios() {
    return episodios;
  }

  public void SetEpisodios(List<Episodio> episodios) {
    this.episodios = episodios;
  }

}
