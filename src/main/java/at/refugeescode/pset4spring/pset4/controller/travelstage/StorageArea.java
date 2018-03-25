package at.refugeescode.pset4spring.pset4.controller.travelstage;


import at.refugeescode.pset4spring.pset4.model.Luggage;

import java.time.Duration;
import java.time.LocalDateTime;

public class StorageArea implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add as much duration to the processing time as the departure time minus 30 minutes
        // if 30 minutes is not possible, the luggage won't be stored at all, which means that
        // no waiting time will be added at all
        LocalDateTime afterDroppingOff = luggage.getDropOffTime().plusMinutes(10);
        LocalDateTime deadline = luggage.getDepartureTime().minusMinutes(30);
        if (deadline.isBefore(afterDroppingOff)){
            return luggage;
        }
        luggage.setWaitingDuration(luggage.getWaitingDuration().plus(Duration.between(afterDroppingOff, deadline)));

        // if 30 minutes is not possible, the luggage won't be stored at all, which means that
        // no waiting time will be added at all
        return luggage;
    }
}
