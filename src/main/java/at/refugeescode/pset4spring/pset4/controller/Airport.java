package at.refugeescode.pset4spring.pset4.controller;


import at.refugeescode.pset4spring.pset4.controller.travelstage.*;
import at.refugeescode.pset4spring.pset4.model.Luggage;
import at.refugeescode.pset4spring.pset4.view.SummaryReporter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Airport {

    private SecurityControl securityControl = new SecurityControl();

    private TravelStage dropOff = new DropOffStand();
    private TravelStage storageArea = new StorageArea();
    private TravelStage transportCart = new TransportCart();
    private TravelStage flight = new Flight();
    private TravelStage luggageClaim = new LuggageClaim();

    private SummaryReporter summaryReporter = new SummaryReporter();

    public List<Luggage> travel(List<Luggage> departureLuggage) {
        // TODO apply airport travel stages per the following order

        summaryReporter.showHeader();
        List<Luggage> allowedToTravel = departureLuggage.stream()
                .filter(luggage -> securityControl.isAllowedToTravel(luggage))
                .collect(Collectors.toList());
        List<Luggage> luggageAfterEdit = allowedToTravel.stream()
                .map(luggage -> dropOff.process(luggage))
                .map(luggage -> storageArea.process(luggage))
                .map(luggage -> transportCart.process(luggage))
                .map(luggage -> flight.process(luggage))
                .map(luggage -> transportCart.process(luggage))
                .map(luggage -> luggageClaim.process(luggage))
                .collect(Collectors.toList());

        // display luggage report summary for rejected luggage
        List<Luggage> rejectedLuggage = securityControl.getRejectedLuggage();
        summaryReporter.reportRejected(rejectedLuggage);

        // display luggage report summary for accepted luggage
        summaryReporter.reportAccepted(allowedToTravel);

        return luggageAfterEdit;
    }


}
