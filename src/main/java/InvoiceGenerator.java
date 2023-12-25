public class InvoiceGenerator {

    private static final int MINIMUM_FARE = 5;
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;

    RideRepository rideRepository = new RideRepository();

    /* UC-1 calculate fare */
    public int calculate_fare(int distance, int time){
        return MINIMUM_FARE + (COST_PER_KM*distance)+ (time*COST_PER_MIN);
    }

    /* UC-2 aggregate fare of multiple rides
    * Refactored UC-3 to return invoice*/
    public InvoiceSummary calculate_fare(Ride[] rides){
        int totalFare = 0;
        for(Ride ride: rides){
            totalFare = totalFare + this.calculate_fare(ride.getDistance(), ride.getTime());
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    /* method to add rides to the rideRepository */
    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    /* retrieves Invoice when userId given */
    public InvoiceSummary getInvoiceSummary(String userId) {
        Ride[] rides = rideRepository.getRides(userId);
        System.out.println("The Invoice of user <"+ userId+"> is: ");
        if(rides!=null && rides.length>0){
            return calculate_fare(rides);
        }
        return null;
    }

}