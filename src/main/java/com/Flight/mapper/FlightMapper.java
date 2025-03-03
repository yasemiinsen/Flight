package com.Flight.mapper;

import com.Flight.dto.FlightDto;
import com.Flight.entity.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FlightMapper {

    @Mapping(source = "airlineId", target = "airlineId")  // airline objesinden id'yi al
    @Mapping(source = "source.id", target = "sourceId")     // source objesinden id'yi al
    @Mapping(source = "destination.id", target = "destinationId") // destination objesinden id'yi al
    FlightDto toDto(Flight flight);

    @Mapping(source = "airlineId", target = "airlineId")  // dto'dan airlineId'yi al ve airline objesine set et
    @Mapping(source = "sourceId", target = "source.id")    // dto'dan sourceId'yi al ve source objesine set et
    @Mapping(source = "destinationId", target = "destination.id") // dto'dan destinationId'yi al ve destination objesine set et
    Flight toEntity(FlightDto flightDto);
}
