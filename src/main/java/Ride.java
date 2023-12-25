public class Ride {
    private int distance;
    private int time;

    private static int count_rides;

    public Ride(int distance, int time) {
        count_rides++;
        this.distance = distance;
        this.time = time;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public static void print_count(){
        System.out.println("The total number of rides are: "+count_rides);
    }
}
