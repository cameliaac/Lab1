import UI.Console;
import Domain.RoomValidator;
import Repository.RoomRepository;
import Availability.RoomAvailability;


public class Main {

    public static void main(String[] args) {
        RoomValidator validator = new RoomValidator();
        RoomRepository repository = new RoomRepository(validator);
        RoomAvailability availability = new RoomAvailability(repository);
        Console console = new Console(availability);
        console.run();
    }
}