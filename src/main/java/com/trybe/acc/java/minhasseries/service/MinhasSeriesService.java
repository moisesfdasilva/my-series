package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinhasSeriesService {

  @Autowired
  private SerieRepository serieRepository;

  public Serie addSerie(String name) {
    Serie serieAdicionada = serieRepository.save(new Serie(name));
    return serieAdicionada;
  }

  public List<Serie> getAllSeries() {
    List<Serie> allSeries = serieRepository.findAll();
    return allSeries;
  }

  public Long delete(Long id) {
    Serie serieExistente = serieRepository.findById(id).orElse(null);
    Long result = id;
    if (serieExistente != null) {
      serieRepository.delete(serieExistente);      
    } else {
      result = null;
    }
    return result;
  }

  public Serie addEpisodio(Long id, Episodio episodio) {
    Serie serieExistente = serieRepository.findById(id).orElse(null);
    if (serieExistente != null) {
      episodio.setSerie(serieExistente);
      serieExistente.adicionarEpisodio(episodio);
      Serie serieAtualizada = serieRepository.save(serieExistente);
      return serieAtualizada;
    } else {
      return serieExistente;
    }
  }

  public List<Episodio> getEpisodios(Long id) {
    Serie serieExistente = serieRepository.findById(id).orElse(null);
    if (serieExistente != null) {
      List<Episodio> episodios = serieExistente.getEpisodios();
      return episodios;
    } else {
      return null;
    }
  }
  
  public HashMap<String, Integer> getTempo() {
    serieRepository.findAll();
    List<Serie> allSeries = serieRepository.findAll();
    List<Episodio> allEpisodios = allSeries.stream()
        .flatMap(serie -> serie.getEpisodios().stream())
        .collect(Collectors.toList());
    Integer duracao = allEpisodios.stream()
        .map(episodio -> episodio.getDuracaoEmMinutos())
        .reduce(0, (acc, num) -> acc + num);
    HashMap<String, Integer> tempo = new HashMap<String, Integer>();
    tempo.put("tempoEmMinutos", duracao);
    return tempo;
  }

}
