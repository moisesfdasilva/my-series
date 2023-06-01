package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.service.MinhasSeriesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MinhasSeriesController {

  @Autowired
  private MinhasSeriesService minhasSeriesService;

  @PostMapping("/series")
  public ResponseEntity<Serie> addSerie(@RequestBody Serie serie) {
    String name = serie.getNome();
    Serie serieAdicionada = minhasSeriesService.addSerie(name);
    return ResponseEntity.ok(serieAdicionada);
  }

  @GetMapping("/series")
  public ResponseEntity<List<Serie>> getAllSeries() {
    List<Serie> allSeries = minhasSeriesService.getAllSeries();
    return ResponseEntity.ok(allSeries);
  }

  @DeleteMapping("/series/{id}")
  public ResponseEntity<String> removeSerie(@PathVariable("id") Long id) {
    Long idRemovido = minhasSeriesService.delete(id);
    return ResponseEntity.ok("Id removido: " + idRemovido);
  }

  @PostMapping("/series/{id}/episodios")
  public ResponseEntity<String> addEpisodios(@PathVariable("id") Long id,
      @RequestBody List<Episodio> episodios) {

    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    System.out.println(id);
    System.out.println(episodios);
    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

    return ResponseEntity.ok("serieAdicionada");
  }

}
