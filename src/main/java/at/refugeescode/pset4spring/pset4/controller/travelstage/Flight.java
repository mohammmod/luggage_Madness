package at.refugeescode.pset4spring.pset4.controller.travelstage;


import at.refugeescode.pset4spring.pset4.model.Luggage;

import java.time.Duration;


public class Flight implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add travel duration to the processing time
        // Update arrival time
        Duration flightDuration = luggage.getFlightDuration();
        luggage.setWaitingDuration(luggage.getWaitingDuration().plus(flightDuration));

        luggage.setArrivalTime(luggage.getDepartureTime().plus(luggage.getFlightDuration()));
        return luggage;
    }
}
