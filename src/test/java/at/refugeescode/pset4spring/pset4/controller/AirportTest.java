package at.refugeescode.pset4spring.pset4.controller;

import at.refugeescode.pset4spring.pset4.model.Luggage;
import at.refugeescode.pset4spring.pset4.parse.LuggageParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    private Airport airport;
    private LuggageParser luggageParser;

    @Test
    void travel() {
        airport = new Airport();
        luggageParser = new LuggageParser();
        List<Luggage> luggages = luggageParser.asList("src/test/java/at/refugeescode/pset4spring/pset4/controller/test.csv");
        List<Luggage> travel = airport.travel(luggages);

        List<String> peopleInfo = travel.stream()
                .map(luggage -> luggage.getOwner() + " "+luggage.getDestination() +" "+luggage.getArrivalTime())
                .collect(Collectors.toList());
        Assertions.assertEquals("Hosam Athens 2018-03-26T23:00",peopleInfo.get(0));
        Assertions.assertEquals("Mohamed Dahman Ljubljana 2018-03-26T21:15",peopleInfo.get(2));
    }
}