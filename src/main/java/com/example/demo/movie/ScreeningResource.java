package com.example.demo.movie;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cinema")
public class ScreeningResource {

    private final ScreenService screenService;

    public ScreeningResource(ScreenService screenService) {
        this.screenService = screenService;
    }

    /**
     * @TODO
     * lista seansów dla danego dnia
     * seans miał infomracje: - rozpoczęcie , zakończenie, tytuł filmu, lista aktorów, reżyser, nazwa sali
     *
     * szczegóły filmu /movie/id
     */

    // stworzyc DTO??


    // lista seasnow dla danego dnia

    // seans musi posiadac infor- rozpoaczecie, zakonczenie, tytul filmu, lista aktorow, rezyser, nazwa sali

    // szczegoly filmu movie/id


    @GetMapping("/all/{date}")
    public List<Screening> getAllByDay(@PathVariable Date date) {
        Date data = screenService.findByDay(date).orElse(null);
        return ResponseEntity.ok().build();
    }



}