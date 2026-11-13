
package TravelPlanner.controller;

import TravelPlanner.entity.Trip;
import TravelPlanner.service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public String showTrips(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "all") String status,
            Model model) {

        LocalDate today = LocalDate.now();

        List<Trip> allTrips = tripService.getAllTrips();

        List<Trip> filteredTrips = allTrips.stream()
                .filter(trip -> {
                    String destination = trip.getDestination() == null
                            ? "" : trip.getDestination();

                    String title = trip.getTitle() == null
                            ? "" : trip.getTitle();

                    String text = (title + " " + destination)
                            .toLowerCase(Locale.ROOT);

                    return text.contains(search.toLowerCase(Locale.ROOT));
                })
                .filter(trip -> {
                    if ("upcoming".equals(status)) {
                        return trip.getStartDate() != null
                                && trip.getStartDate().isAfter(today);
                    }

                    if ("ongoing".equals(status)) {
                        return trip.getStartDate() != null
                                && trip.getEndDate() != null
                                && !today.isBefore(trip.getStartDate())
                                && !today.isAfter(trip.getEndDate());
                    }

                    if ("completed".equals(status)) {
                        return trip.getEndDate() != null
                                && trip.getEndDate().isBefore(today);
                    }

                    return true;
                })
                .toList();

        BigDecimal totalBudget = allTrips.stream()
                .map(Trip::getBudget)
                .filter(budget -> budget != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        long upcomingCount = allTrips.stream()
                .filter(trip -> trip.getStartDate() != null
                        && trip.getStartDate().isAfter(today))
                .count();

        long completedCount = allTrips.stream()
                .filter(trip -> trip.getEndDate() != null
                        && trip.getEndDate().isBefore(today))
                .count();

        model.addAttribute("trips", filteredTrips);
        model.addAttribute("totalTrips", allTrips.size());
        model.addAttribute("upcomingCount", upcomingCount);
        model.addAttribute("completedCount", completedCount);
        model.addAttribute("totalBudget", totalBudget);
        model.addAttribute("search", search);
        model.addAttribute("status", status);

        return "trips";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("trip", new Trip());
        model.addAttribute("pageTitle", "Plan a new trip");
        return "trip-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("trip", tripService.getTripById(id));
        model.addAttribute("pageTitle", "Edit your trip");
        return "trip-form";
    }

    @PostMapping("/save")
    public String saveTrip(@ModelAttribute Trip trip) {
        tripService.saveTrip(trip);
        return "redirect:/trips";
    }

    @PostMapping("/delete/{id}")
    public String deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return "redirect:/trips";
    }
}
