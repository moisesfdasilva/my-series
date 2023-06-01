package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;
import java.util.List;
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

  public void getById(Long id) {
    serieRepository.findById(id);
  }

  public void getDuracao(Long id) {
    serieRepository.findAll();
    // Buscar todas e somar.
  }

}
