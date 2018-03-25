package at.refugeescode.pset4spring.pset4;


import at.refugeescode.pset4spring.pset4.controller.Airport;
import at.refugeescode.pset4spring.pset4.model.Luggage;
import at.refugeescode.pset4spring.pset4.parse.LuggageParser;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Pset4Main {
    @Bean
    public ApplicationRunner mainProgramm(LuggageParser luggageParser, Airport airport) {

        return args -> {
            List<Luggage> departureLuggage = luggageParser.asList("src/main/java/at/refugeescode/pset4spring/pset4/data/luggage.csv");

            airport.travel(departureLuggage);
        };
    }
}
