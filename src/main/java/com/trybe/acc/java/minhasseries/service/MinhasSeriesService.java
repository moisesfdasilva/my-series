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

  public void addSerie(String nome) {
    serieRepository.save(null);
  }

  public List<Serie> getAllSeries() {
    List<Serie> allSeries = serieRepository.findAll();
    return allSeries;
  }

  public void delete(Long id) {
    serieRepository.findById(id);
    serieRepository.delete(null);
  }

  public void getById(Long id) {
    serieRepository.findById(id);
  }

  public void getDuracao(Long id) {
    serieRepository.findAll();
    // Buscar todas e somar.
  }

}
