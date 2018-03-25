package at.refugeescode.pset4spring.pset4.controller.travelstage;


import at.refugeescode.pset4spring.pset4.model.Luggage;

import java.time.Duration;

public class DropOffStand implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add 10 minutes to the processing time
        Duration duration = luggage.getWaitingDuration().plusMinutes(10);
        luggage.setWaitingDuration(duration);
        return luggage;
    }
}
