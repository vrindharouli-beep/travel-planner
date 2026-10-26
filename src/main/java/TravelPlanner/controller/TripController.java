
package TravelPlanner.controller;

import TravelPlanner.entity.Trip;
import TravelPlanner.service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/trips")
    public String showTrips(Model model) {
        model.addAttribute("trips", tripService.getAllTrips());
        return "trips";
    }

    @GetMapping("/trips/new")
    public String showTripForm(Model model) {
        model.addAttribute("trip", new Trip());
        return "trip-form";
    }

    @PostMapping("/trips/save")
    public String saveTrip(@ModelAttribute Trip trip) {
        tripService.saveTrip(trip);
        return "redirect:/trips";
    }

    @GetMapping("/trips/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Trip trip = tripService.getTripById(id);

        if (trip == null) {
            return "redirect:/trips";
        }

        model.addAttribute("trip", trip);
        return "trip-edit-form";
    }

    @PostMapping("/trips/update/{id}")
    public String updateTrip(@PathVariable Long id,
                             @ModelAttribute Trip updatedTrip) {
        Trip existingTrip = tripService.getTripById(id);

        if (existingTrip == null) {
            return "redirect:/trips";
        }

        existingTrip.setTitle(updatedTrip.getTitle());
        existingTrip.setDestination(updatedTrip.getDestination());
        existingTrip.setStartDate(updatedTrip.getStartDate());
        existingTrip.setEndDate(updatedTrip.getEndDate());
        existingTrip.setBudget(updatedTrip.getBudget());

        tripService.saveTrip(existingTrip);

        return "redirect:/trips";
    }

    @PostMapping("/trips/delete/{id}")
    public String deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return "redirect:/trips";
    }
}
