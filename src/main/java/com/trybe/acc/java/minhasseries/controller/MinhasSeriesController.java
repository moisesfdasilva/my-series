package com.trybe.acc.java.minhasseries.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.service.MinhasSeriesService;

@RestController
public class MinhasSeriesController {

  @Autowired
  private MinhasSeriesService minhasSeriesService;
  
  @GetMapping("/series")
  public ResponseEntity<List<Serie>> getAllSeries() {
    List<Serie> allSeries = minhasSeriesService.getAllSeries();
    return ResponseEntity.ok(allSeries);
  }

}
