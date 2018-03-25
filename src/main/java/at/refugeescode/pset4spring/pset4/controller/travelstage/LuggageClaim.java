package at.refugeescode.pset4spring.pset4.controller.travelstage;



import at.refugeescode.pset4spring.pset4.model.Luggage;

import java.time.Duration;

public class LuggageClaim implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add 15 minutes to the processing time
        Duration duration = luggage.getWaitingDuration().plusMinutes(15);
        luggage.setWaitingDuration(duration);

        return luggage;

    }
}
