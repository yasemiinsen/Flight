package com.Flight.api;

import com.Flight.core.config.modelMapper.IModelMapperService;
import com.Flight.core.utilies.ResultHelper;
import com.Flight.core.result.ResultData;
import com.Flight.core.result.Result;
import com.Flight.dto.request.AirportSaveRequestDto;
import com.Flight.dto.request.AirportUpdateRequestDto;
import com.Flight.dto.response.AirportResponseDto;
import com.Flight.entity.Airport;
import com.Flight.service.abstracts.AirportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;
    private final IModelMapperService modelMapper;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AirportResponseDto> save(@Valid @RequestBody AirportSaveRequestDto airportSaveRequestDto) {
        Airport saveAirport =this.modelMapper.forRequest().map(airportSaveRequestDto,Airport.class);
        this.airportService.save(saveAirport);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveAirport,AirportResponseDto.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AirportResponseDto> get(@PathVariable("id") int id){
        Airport airport = this.airportService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(airport, AirportResponseDto.class));
    }



    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AirportResponseDto> update (@Valid @RequestBody AirportUpdateRequestDto airportUpdateRequestDto) {
        Airport updateAirport = this.modelMapper.forRequest().map(airportUpdateRequestDto, Airport.class);
        this.airportService.update(updateAirport);
        return ResultHelper.success(this.modelMapper.forResponse().map(updateAirport,AirportResponseDto.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.airportService.delete(id);
        return ResultHelper.ok();
    }



}
