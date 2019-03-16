package Repository;

import Domain.Room;
import Domain.RoomValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomRepository {

    private Map<Integer, Room > storage = new HashMap<>();

    private RoomValidator validator;

    /**
     * Instantiates a repository for rooms.
     * @param validator the validator used.
     */
    public RoomRepository(RoomValidator validator) {
        this.validator = validator;
     }

      /**
     * ...
     * @param room
     */
    public void add(Room room) {
        if (storage.containsKey(room.getId())) {
            throw new RuntimeException("ID deja existent!");
        }

        validator.validate(room);
        storage.put(room.getId(), room);
    }

    /**
     * ...
     * @param room
     */
    public void update(Room room) {
        if (!storage.containsKey(room.getId())) {
            throw new RuntimeException("Id incorect!");
        }

        validator.validate(room);
        storage.put(room.getId(), room);
    }

    /**
     * @return list of rooms
     */
    public List<Room> getAll() {

        return new ArrayList<>(storage.values());
//        return (List<Room>)storage.values();
        //return storage.values().toArray();
    }
}