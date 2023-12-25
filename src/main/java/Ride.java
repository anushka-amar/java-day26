public class Ride {
    private int distance;
    private int time;

    private RideType type;

    public Ride(int distance, int time, RideType type) {
        this.distance = distance;
        this.time = time;
        this.type = type;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public RideType getType(){
        return type;
    }
}