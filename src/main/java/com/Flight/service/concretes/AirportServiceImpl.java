package com.Flight.service.concretes;

import com.Flight.core.exception.NotFoundException;
import com.Flight.core.utilies.Msg;
import com.Flight.entity.Airport;
import com.Flight.exception.DuplicateResourceException;
import com.Flight.repository.AirportRepository;
import com.Flight.service.abstracts.AirportService;
import org.springframework.stereotype.Service;



@Service
public class AirportServiceImpl implements AirportService {
    /*private final AirportMapper airportMapper;*/
    private final AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {this.airportRepository = airportRepository;}


    @Override
    public Airport save(Airport airport) {
        if (airportRepository.existsByName(airport.getName())) {
            throw new DuplicateResourceException("Airport name already exists: " + airport.getName());
        }return this.airportRepository.save(airport);}


    @Override
    public Airport get(int id){return this.airportRepository.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Airport update(Airport airport) {
        this.get(airport.getId());
        return this.airportRepository.save(airport);
    }

    @Override
    public boolean delete(int id) {
        Airport airport = this.get(id);
        this.airportRepository.delete(airport);
        return true;
    }

/*

    @Override
    public AirportResponseDto createAirport(AirportSaveRequestDto airportSaveRequestDto) {
        Airport airport = airportMapper.saveRequestToEntity(airportSaveRequestDto);

        if (airportRepository.existsByAirportCode(airport.getAirportCode())) {
            throw new DuplicateResourceException("Airport code already exists: " + airport.getAirportCode());
        }
        return airportMapper.entityToResponse(airport);
    }

    @Override
    public AirportResponseDto updateAirport(AirportUpdateRequestDto airportUpdateRequestDto) {
        Airport airport = airportMapper.updateRequestToEntity(airportUpdateRequestDto);

        if (airportRepository.existsByAirportCodeAndIdNot(
                airport.getAirportCode())) {
            throw new DuplicateResourceException("Airport code already exists: " + airport.getAirportCode());
        }

        if (!airportRepository.existsById(airport.getAirportId())) {
            throw new ResourceNotFoundException("Airport", "id", airport.getAirportId());
        }

        return airportMapper.entityToResponse(airport);
    }

    @Override
    public void deleteAirport(AirportSaveRequestDto airportSaveRequestDto) {
        Airport airport = airportMapper.saveRequestToEntity(airportSaveRequestDto);
        if (!airportRepository.existsById(airport.getAirportId())) {
            throw new ResourceNotFoundException("Airport", "id", airport.getAirportId());
        }
        airportMapper.entityToResponse(airport);
    }
    // burada kaldım

    @Override
    @Transactional(readOnly = true)
    public Optional<Airport> findByAirportCode(String airportCode) {
        return airportRepository.findByAirportCode(airportCode);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Airport> findByCity(String city) {
        return airportRepository.findByCity(city);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Airport> findByCountry(String country) {
        return airportRepository.findByCountry(country);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Airport> searchByNameContaining(String keyword) {
        return airportRepository.searchByNameContaining(keyword);
    }*/
}