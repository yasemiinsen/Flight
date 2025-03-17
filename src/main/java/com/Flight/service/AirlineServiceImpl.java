package com.Flight.service;


import com.Flight.entity.Airline;

import com.Flight.repository.AirlineRepository;
import com.Flight.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirlineServiceImpl implements AirlineService {

    private final AirlineRepository airlineRepository;

    @Override
    public List<Airline> getAllAirlines() {
        return airlineRepository .findAll();
    }

    @Override
    public Airline getAirlineById(Integer id) {
        return airlineRepository.findById(id).orElse(null);
    }

    @Override
    public Airline createAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public Airline updateAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public void deleteAirline(Integer id) {
        airlineRepository.deleteById(id);
    }
}
