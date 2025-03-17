package com.Flight.service;
import com.Flight.entity.Airport;
import com.Flight.repository.AirportRepository;
import com.Flight.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Optional<Airport> getAirportById(Integer airportId) {
        return airportRepository.findById(airportId);
    }

    @Override
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public void deleteAirport(Integer airportId) {
        airportRepository.deleteById(airportId);
    }
}
