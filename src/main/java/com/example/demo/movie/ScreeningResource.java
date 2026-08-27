package com.example.demo.movie;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class ScreeningResource {

    private final ScreenService screenService;
    private final MovieService movieService;

    public ScreeningResource(ScreenService screenService, MovieService movieService, ScreenRepository screenRepository) {
        this.screenService = screenService;
        this.movieService = movieService;
    }

    @GetMapping("/all/{date}")
    public ResponseEntity<List<ScreeningDTO>> getAllByDay(@PathVariable String date) {
        List<ScreeningDTO> screeningDTO = screenService.findByDay(date);
        if (screeningDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(screeningDTO);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable Long id) {
       MovieDTO movieDTO = movieService.findById(id);
       if (movieDTO == null) {
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(movieDTO);
    }


    @GetMapping("/screenings/{id}")
    public ResponseEntity<ScreeningDTO> getScreeningById(@PathVariable Long id) {
        ScreeningDTO dto = screenService.findById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

}