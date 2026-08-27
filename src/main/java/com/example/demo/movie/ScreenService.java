package com.example.demo.movie;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenService(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    public List<Screening> getAll() {
        return screenRepository.findAll();
    }

    public ScreeningDTO findByDay(Date date) {
        Screening screening = screenRepository.findByDate(date);
        if (screening == null) {
            return null;
        }
        return new ScreeningDTO(screening);
    }


}
