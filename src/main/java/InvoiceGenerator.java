public class InvoiceGenerator {

    private static final int MINIMUM_FARE = 5;
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;

    /* UC-1 calculate fare */
    public double calculate_fare(int distance, int time){
        double cost =(double) MINIMUM_FARE + (COST_PER_KM*distance)+ (time*COST_PER_MIN);
        return cost;
    }

    /* UC-2 aggregate fare of multiple rides */
    public double aggregate_fare(Ride[] rides){
        double totalFare = 0;
        for(Ride ride: rides){
            totalFare = totalFare + calculate_fare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }

    /* UC-3 enhanced-invoice - average fare per ride*/
    public double average_fare(Ride[] rides){
        double total_fare = aggregate_fare(rides);
        return total_fare/rides.length;
    }
}