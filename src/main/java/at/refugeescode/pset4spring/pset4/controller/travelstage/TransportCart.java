package at.refugeescode.pset4spring.pset4.controller.travelstage;



import at.refugeescode.pset4spring.pset4.model.Luggage;

import java.time.Duration;

public class TransportCart implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add 25 minutes to the processing time
        Duration duration = luggage.getWaitingDuration().plusMinutes(25);
        luggage.setWaitingDuration(duration);
        return luggage;
    }
}
