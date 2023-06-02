package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.service.MinhasSeriesService;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.HashMap;
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

  /** Método addSérie. */
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
  public ResponseEntity<String> removeSerie(@PathVariable("id") Integer id) {
    Integer idRemovido = minhasSeriesService.delete(id);
    return ResponseEntity.ok("Id removido: " + idRemovido);
  }

  //@CircuitBreaker(name = "minhasSeries", fallbackMethod = "fallback")
  @PostMapping("/series/{id}/episodios")
  public ResponseEntity<Serie> addEpisodio(@PathVariable("id") Integer id,
      @RequestBody Episodio episodio) {
    Serie serieExistente = minhasSeriesService.addEpisodio(id, episodio);
    return ResponseEntity.ok(serieExistente);
  }

  @GetMapping("/series/{id}/episodios")
  public ResponseEntity<List<Episodio>> getEpisodios(@PathVariable("id") Integer id) {
    List<Episodio> episodios = minhasSeriesService.getEpisodios(id);
    return ResponseEntity.ok(episodios);
  }

  @GetMapping("/series/tempo")
  public ResponseEntity<HashMap<String, Integer>> getTempo() {
    HashMap<String, Integer> tempo = minhasSeriesService.getTempo();
    return ResponseEntity.ok(tempo);
  }

}
