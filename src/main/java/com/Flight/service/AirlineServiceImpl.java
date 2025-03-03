package com.Flight.service.impl;

import com.Flight.constraints.FlightConstants;
import com.Flight.entity.Airline;
import com.Flight.exception.SourceDestinationException;
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
        return airlineRepository.findAll();
    }

    @Override
    public Airline getAirlineById(Integer id) {
        return airlineRepository.findById(id)
                .orElseThrow(() -> new SourceDestinationException(String.format(FlightConstants.FLIGHT_NOT_FOUND_MESSAGE, id)));
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
