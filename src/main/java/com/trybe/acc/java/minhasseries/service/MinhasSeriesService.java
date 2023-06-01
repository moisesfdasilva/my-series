package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.exception.EpisodioExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;
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

  /** Método addSérie.*/
  public Serie addSerie(String name) {
    List<Serie> serieExistente = serieRepository.findAll().stream()
        .filter(serie -> serie.getNome().equals(name))
        .collect(Collectors.toList());
    if (serieExistente.size() == 0) {
      Serie serieAdicionada = serieRepository.save(new Serie(name));
      return serieAdicionada;      
    } else {
      throw new SerieExistenteException();
    }
  }

  /** Método getAllSeries.*/
  public List<Serie> getAllSeries() {
    List<Serie> allSeries = serieRepository.findAll();
    return allSeries;
  }

  /** Método delete.*/
  public Integer delete(Integer id) {
    Serie serieExistente = serieRepository.findById(id).orElse(null);
    Integer result = id;
    if (serieExistente != null) {
      serieRepository.delete(serieExistente);      
    } else {
      throw new SerieNaoEncontradaException();
    }
    return result;
  }

  /** Método addEpisodio.*/
  public Serie addEpisodio(Integer id, Episodio episodio) {
    Serie serieExistente = serieRepository.findById(id).orElse(null);
    if (serieExistente != null) {
      List<Episodio> episodioExistente = serieExistente.getEpisodios().stream()
          .filter(ep -> ep.getNumero().equals(episodio.getNumero()))
          .collect(Collectors.toList());
      if (episodioExistente.size() > 0) {
        throw new EpisodioExistenteException();
      } else {
        episodio.setSerie(serieExistente);
        serieExistente.adicionarEpisodio(episodio);
        Serie serieAtualizada = serieRepository.save(serieExistente);
        return serieAtualizada;
      }
    } else {
      throw new SerieNaoEncontradaException();
    }
  }

  /** Método getEpisodios.*/
  public List<Episodio> getEpisodios(Integer id) {
    Serie serieExistente = serieRepository.findById(id).orElse(null);
    if (serieExistente != null) {
      List<Episodio> episodios = serieExistente.getEpisodios();
      return episodios;
    } else {
      return null;
    }
  }

  /** Método getTempo.*/
  public HashMap<String, Integer> getTempo() {
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
