package com.trybe.acc.java.minhasseries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;

@Service
public class MinhasSeriesService {

  @Autowired
  private SerieRepository serieRepository;

  public void addSerie(String nome) {
    serieRepository.save(null);
  }

  public void getAllSeries() {
    serieRepository.findAll();
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
