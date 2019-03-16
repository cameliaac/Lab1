package Domain;

public class RoomValidator {

    /**
     * Validates a room.
     *
     * @param room the room to validate.
     * @throws RuntimeException if there are validation errors.
     */
    public void validate(Room room) {

        if (room.getDays() <= 0) {
            throw new RuntimeException("Numarul de zile trebuie sa fie mai mare decat 0!");
        }

        if (room.isEmpty()) {
            if (room.getRating() <= 5) {
                throw new RuntimeException("Ratingul trebuie sa fie pozitiv!");
            }
        }
    }

}