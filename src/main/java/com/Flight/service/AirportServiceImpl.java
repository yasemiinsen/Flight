package com.Flight.service.impl;

import com.Flight.entity.Airport;
import com.Flight.exception.SourceDestinationException;
import com.Flight.repository.AirportRepository;
import com.Flight.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Airport getAirportById(Integer id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new SourceDestinationException(String.format(FlightConstants.SOURCE_DEST_ERROR_MESSAGE, id)));
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
    public void deleteAirport(Integer id) {
        airportRepository.deleteById(id);
    }
}
