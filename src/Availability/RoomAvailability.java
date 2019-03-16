package Availability;

import Domain.AverageRating;
import Domain.Room;
import Repository.RoomRepository;

import java.util.*;

public class RoomAvailability {

    private RoomRepository repository;

    /**
     * ...
     * @param repository;
     */
    public RoomAvailability(RoomRepository repository) {
        this.repository = repository;
    }

    /**
     * ...
     * @param id
     * @param guests
     * @param roomnumber
     * @param days
     */
    public void checkIn(int id, int guests, int roomnumber, int days) {

        Room room = new Room(id, guests, roomnumber, days);
        List<Room> rooms = repository.getAll();
        for (Room r : rooms) {
            if (r.getguests() == guests && !r.isCheckedOut()){
                throw new RuntimeException("Camera e ocupata!");
            }
        }
        repository.add(room);
    }

    /**
     *
     * @param guests
     * @param feedback
     * @param rating
     */
    public void checkOut(int guests, String feedback, int rating) {
        Room roomDependingonguests = null;
        List<Room> rooms = repository.getAll();
        for (Room r : rooms) {
            if (r.getguests() == guests && !r.isCheckedOut()){
                roomDependingonguests = r;
            }
        }

        if (roomDependingonguests != null) {
            roomDependingonguests.setFeedback(feedback);
            roomDependingonguests.setRating(rating);
            roomDependingonguests.setCheckedOut(true);
            repository.update(roomDependingonguests);
        } else {
            throw new RuntimeException("Nu exista oaspeti in aceasta camera!");
        }
    }

    public List<AverageRating> getguestsRatingAverages() {
        List<AverageRating> results = new ArrayList<>();

        Map<Integer, List<Integer>> ratingsforguests = new HashMap<>();
        for (Room r : repository.getAll()) {
            if (r.isCheckedOut()) {
                int guests = r.getguests();
                int rating = r.getRating();

                if (!ratingsforguests.containsKey(guests)) {
                    ratingsforguests.put(guests, new ArrayList<>());
                }
                ratingsforguests.get(guests).add(rating);
            }
        }

        for (Integer guests : ratingsforguests.keySet()) {
            List<Integer> rating = ratingsforguests.get(guests);
            int averageRating = 0;
            for (int p : rating) {
                averageRating += p;
            }
            averageRating /= rating.size();
            results.add(new AverageRating(guests, averageRating));
        }

//        results.sort((r1, r2) -> r1.getAverageRating() > r2.getAverageRating() ? -1 : 1);
        results.sort((r1, r2) -> {
            if (r1.getAverageRating() > r2.getAverageRating())
                return -1;
            else if (r1.getAverageRating() == r2.getAverageRating())
                return 0;
            else
                return 1;
        });
        return results;
    }

    public List<Room> getAll() {
        return repository.getAll();
    }
}