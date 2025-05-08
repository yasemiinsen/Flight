package com.Flight.service.concretes;

import com.Flight.core.exception.NotFoundException;
import com.Flight.core.utilies.Msg;
import com.Flight.entity.Flight;
import com.Flight.repository.FlightRepository;
import com.Flight.service.abstracts.FlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service

public class FlightServiceImpl implements FlightService {

    private static final int MAX_DAILY_FLIGHTS = 3;
    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    /*@Override
    public Flight save(Flight flight) {
        return this.flightRepository.save(flight);
    }*/

    @Override
    public Flight get(int id) {
        return this.flightRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Flight update(Flight flight) {
        this.get(flight.getId());
        return this.flightRepository.save(flight);    }

    @Override
    public boolean delete(int id) {
        Flight flight = this.get(id);
        this.flightRepository.delete(flight);
        return true;
    }


    // ekledim
    @Override
    public Flight save(Flight flight) {
        if(flight == null) {
            throw new RuntimeException("Flight cannot be null");
        }

        if(flight.getSourceAirport() == null || flight.getDestinationAirport() == null) {
            throw new RuntimeException("Source and destination airports are required");
        }

        if(flight.getAirline() == null) {
            throw new RuntimeException("Airline is required");
        }

        // Günlük uçuş limiti kontrolü
        LocalDateTime startOfDay = flight.getDateTime().toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1);

        int dailyFlightCount = flightRepository.countDailyFlights(
                flight.getSourceAirport().getId(),
                flight.getDestinationAirport().getId(),
                startOfDay,
                endOfDay
        );

        if(dailyFlightCount >= 3) {
            throw new RuntimeException("Daily flight limit exceeded between these airports");
        }

        return flightRepository.save(flight);
    }











   /* @Override
    @Transactional(readOnly = true)
    public List<Flight> getAllFlights() {
        log.debug("Getting all flights");
        return flightRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Flight> getFlightById(Integer id) {
        log.debug("Getting flight by ID: {}", id);
        return flightRepository.findById(id);
    }

    @Override
    public Flight createFlight(Flight flight) {
        //airlineın eklnemem durumu kontrol edilecek
        log.debug("Creating new flight with number: {}", flight.getFlightNumber());
        validateDailyFlightLimit(flight);
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateFlight(Flight flight) {
        log.debug("Updating flight with ID: {}", flight.getFlightId());
        validateDailyFlightLimit(flight);
        
        if (!flightRepository.existsById(flight.getFlightId())) {
            throw new ResourceNotFoundException("Flight", "id", flight.getFlightId());
        }
        
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Integer id) {
        log.debug("Deleting flight with ID: {}", id);
        if (!flightRepository.existsById(id)) {
            throw new ResourceNotFoundException("Flight", "id", id);
        }
        flightRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Flight> findFlightsByAirlineAndRoute(Integer airlineId, Integer departureId, 
            Integer arrivalId, LocalDateTime startTime, LocalDateTime endTime) {
        return flightRepository.findFlightsByAirlineAndRoute(airlineId, departureId, 
                arrivalId, startTime, endTime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Flight> findFlightsByCities(String departureCity, String arrivalCity, LocalDate date) {
        return flightRepository.findFlightsByCities(departureCity, arrivalCity, date);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Flight> findFlightsByAirlineAndDate(String airlineCode, LocalDate date) {
        return flightRepository.findFlightsByAirlineAndDate(airlineCode, date);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Flight> findFlightsByTimeRange(LocalDateTime startTime, LocalDateTime endTime) {
        return flightRepository.findFlightsByTimeRange(startTime, endTime);
    }

    private void validateDailyFlightLimit(Flight flight) {
        int dailyFlights = flightRepository.countDailyFlightsByAirlineAndRoute(
            flight.getAirline().getAirlineId(),
            flight.getDepartureAirport().getAirportId(),
            flight.getArrivalAirport().getAirportId(),
            flight.getDepartureTime().toLocalDate()
        );

        if (dailyFlights >= MAX_DAILY_FLIGHTS) {
            throw new DailyFlightLimitExceededException();
        }
    }*/
}