package com.example.demo.movie;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenService(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    public List<ScreeningDTO> getAll() {
        return screenRepository.findAll()
                .stream()
                .map(ScreeningDTO::new)
                .collect(Collectors.toList());
    }

    public ScreeningDTO findByDay(Date date) {
        Screening screening = screenRepository.findByDate(date);
        if (screening == null) {
            return null;
        }
        return new ScreeningDTO(screening);
    }

    public ScreeningDTO findById(Long id) {
        Screening screening = screenRepository.findById(id).orElse(null);

        if (screening == null) {
            return  null;
        }

        return new ScreeningDTO(screening);
    }

}
