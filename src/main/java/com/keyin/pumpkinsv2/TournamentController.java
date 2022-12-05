package com.keyin.pumpkinsv2;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class TournamentController {

    @Autowired
    public TournamentRepository tournamentRepository;

    @GetMapping("/tour_sequence")
    public List<Tournament> getAllTours() {
        return tournamentRepository.findAll();
    }

    @GetMapping("/tour_sequence/{id}")
    public Tournament getTourById(@PathVariable String id) {
        int tourId = Integer.parseInt(id);
        return tournamentRepository.getReferenceById(tourId);
    }

    @PostMapping("/tour_sequence")
    public Tournament createTour(@RequestBody Map<String, String> tour) {
        String start = tour.get("start_date");
        String end = tour.get("end_date");
        String location = tour.get("location");
        String entry = tour.get("entry_fee");
        String prize = tour.get("cash_prize");
        return tournamentRepository.save(new Tournament(start, end, location, entry, prize));
    }

    @PutMapping("/tour_sequence/{id}")
    public void updateTour(@PathVariable String id, @RequestBody Map<String, String> tour, HttpServletResponse response) {
        Optional<Tournament> returnValue = tournamentRepository.findById(Integer.parseInt(id));
        Tournament tourToUpdate;

        if (returnValue.isPresent()) {
            tourToUpdate = returnValue.get();

            tourToUpdate.setStartDate(tour.get("start_date"));
            tourToUpdate.setEndDate(tour.get("end_date"));
            tourToUpdate.setLocation(tour.get("location"));
            tourToUpdate.setEntryFee(tour.get("entry_fee"));
            tourToUpdate.setCashPrize(tour.get("cash_prize"));


            tournamentRepository.save(tourToUpdate);
            response.setStatus(200);
        } else {
            try {
                response.sendError(404, "tour with id: " + tour.get("id") + "not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
    @DeleteMapping("/tour_sequence/{id}")
    public void deleteTour(@PathVariable String id, @RequestBody Map<String, String> tour, HttpServletResponse response) {
        Optional<Tournament> returnValue = tournamentRepository.findById(Integer.parseInt(id));
        Tournament tourToDelete;

        if (returnValue.isPresent()) {
            tourToDelete = returnValue.get();

            tourToDelete.setStartDate(tour.get("start_date"));
            tourToDelete.setEndDate(tour.get("end_date"));
            tourToDelete.setLocation(tour.get("location"));
            tourToDelete.setEntryFee(tour.get("entry_fee"));
            tourToDelete.setCashPrize(tour.get("cash_prize"));

            tournamentRepository.delete(tourToDelete);
            response.setStatus(200);
        } else {
            try {
                response.sendError(404, "tour with id: " + tour.get("id") + "not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
