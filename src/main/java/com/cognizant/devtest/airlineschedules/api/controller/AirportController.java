package com.cognizant.devtest.airlineschedules.api.controller;

import com.cognizant.devtest.airlineschedules.domain.entity.Airport;
import com.cognizant.devtest.airlineschedules.domain.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
@CrossOrigin(origins = "http://localhost:4200")
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Airport addAirport(@RequestBody Airport airport) {

        Airport newAirport = airportRepository.save(airport);

        return newAirport;
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public Airport modifyAirport(@RequestBody Airport airport) {

        Airport modifiedAirport = airportRepository.save(airport);

        return modifiedAirport;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public Airport getAirportById(@PathVariable("id") final Long id) throws Exception {

        Airport airport = airportRepository.findById(id).orElseThrow(() -> new Exception("Airport not found"));

        return airport;
    }


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Airport> getAllAirports() {

        return airportRepository.findAll();

    }

}
