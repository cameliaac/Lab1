package Domain;

public class AverageRating {

    private int guests;
    private int averageRating;

    @Override       public String toString(){
        return "averageRating{" +
                "guests=" + guests +
                ", averageRating=" + averageRating +
                '}';
    }

    public int getguests() {
        return guests;
    }

    public void setGuests (int guests){
        this.guests = guests;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public AverageRating(int guests, int averageRating){
        this.guests = guests;
        this.averageRating = averageRating;
    }
}