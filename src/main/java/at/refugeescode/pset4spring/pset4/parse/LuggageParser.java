package at.refugeescode.pset4spring.pset4.parse;

import at.refugeescode.pset4spring.pset4.model.Luggage;
import at.refugeescode.pset4spring.pset4.util.TimeUtils;
import org.springframework.stereotype.Component;


import java.time.Duration;
import java.util.Optional;
@Component
public class LuggageParser extends AbstractParser<Luggage> {

    @Override
    protected Optional<Luggage> toObject(String[] columns) {
        if (columns.length != 6) {
            return Optional.empty();
        }
        return Optional.of(toTravelReport(columns));
    }

    private Luggage toTravelReport(String[] columns) {
        Luggage luggage = new Luggage();
        luggage.setOwner(columns[0]);
        luggage.setDestination(columns[1]);
        luggage.setType(columns[2]);
        luggage.setDropOffTime(TimeUtils.todayAt(columns[3]));
        luggage.setDepartureTime(TimeUtils.todayAt(columns[4]));
        luggage.setFlightDuration(TimeUtils.durationOfHours(columns[5]));
        luggage.setWaitingDuration(Duration.ofSeconds(0));
        return luggage;
    }
}
