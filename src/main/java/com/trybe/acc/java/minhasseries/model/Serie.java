package com.trybe.acc.java.minhasseries.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Serie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;

  @JsonManagedReference
  @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL,
      orphanRemoval = true, fetch = FetchType.LAZY)
  private List<Episodio> episodios;
  
  /** Método construtor default. */
  public Serie() { }

  /** Método construtor. */
  public Serie(String nome) {
    this.nome = nome;
    this.episodios = new ArrayList<Episodio>();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Episodio> getEpisodios() {
    return episodios;
  }

  public void setEpisodios(List<Episodio> episodios) {
    this.episodios = episodios;
  }

  public void adicionarEpisodio(Episodio episodio) {
    this.episodios.add(episodio);
  }

}
