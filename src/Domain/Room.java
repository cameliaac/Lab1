package Domain;

public class Room {
    public boolean isCheckedOut;
    private int id, guests;
    private int roomnumber;
    private int days;
    private boolean CheckedOut;
    private String feedback;
    private int rating;

    @Override
    public String toString() {
        String CheckedOut = null;
        return "Room{" +
                "id=" + id +
                ", guests=" + guests +
                ", roomnumber='" + roomnumber + '\'' +
                ", days=" + days +
                ", CheckedOut=" + CheckedOut +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                '}';
    }

    public Room(int id, int guests, int roomnumber, int days) {
        this.id = id;
        this.guests= guests;
        this.roomnumber = roomnumber;
        this.days = days;
    }

    public Room(int id, int guests, int roomnumber, int days, boolean CheckedOut, String feedback, int rating) {
        this.id = id;
        this.guests = guests;
        this.roomnumber = roomnumber;
        this.days = days;
        this.CheckedOut = CheckedOut;
        this.feedback = feedback;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getguests() {
        return guests;
    }

    public void setguests(int guests) {
        this.guests = guests;
    }

    public int getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isCheckedOut() {
        return CheckedOut;
    }

    public void setCheckedOut(boolean CheckedOut) {
        this.CheckedOut = CheckedOut;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isEmpty() {
        return false;
    }

}