        package UI;

        import Availability.RoomAvailability;
        import Domain.Room;
        import Domain.AverageRating;
        import Repository.RoomRepository;

        import java.util.Scanner;

public class Console {

    private RoomAvailability availability;
    private Scanner scanner;

    public Console(RoomAvailability availability) {
        this.availability = availability;
        scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Intrare in hotel");
        System.out.println("2. Iesire din hotel");
        System.out.println("3. Afisare toate camerele");
        System.out.println("x. Iesire");
    }

    public void run() {

        while (true) {
            showMenu();
            String option = scanner.nextLine();
            if (option.equals("1")) {
                handleCheckin();
            } else if (option.equals("2")) {
                handleCheckOut();
            } else if (option.equals("3")) {
                handleShowAll();
            } else if (option.equals("x")) {
                break;
            }
        }
    }

       private void handleCheckOut() {
        try {
            System.out.println("Dati numarul de persoane:");
            int guests = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati feedback de hotel:");
            String feedback = scanner.nextLine();
            System.out.println("Dati rating-ul:");
            int rating = Integer.parseInt(scanner.nextLine());

            availability.checkOut(guests, feedback, rating);
        } catch (RuntimeException runtimeException) {
            System.out.println("Atentie: " + runtimeException.getMessage());
        }
    }

    private void handleShowAll() {
        for (Room r : availability.getAll())
            System.out.println(r);
    }

    private void handleCheckin() {

        try {
            System.out.println("Dati id-ul:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul de persoane:");
            int guests = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul camerei:");
            int roomnumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul de zile:");
            int days = Integer.parseInt(scanner.nextLine());


            availability.checkIn(id, guests, roomnumber, days);
        } catch (RuntimeException runtimeException) {
            System.out.println("Atentie: " + runtimeException.getMessage());
        }
    }
}
