public class InvoiceGenerator {

    private static final int MINIMUM_NORMAL_FARE = 5;
    private static final int COST_PER_KM_NORMAL = 10;
    private static final int COST_PER_MIN_NORMAL = 1;

    private static final int MINIMUM_PREMIUM_FARE = 20;
    private static final int COST_PER_KM_PREMIUM = 15;
    private static final int COST_PER_MIN_PREMIUM = 2;

    RideRepository rideRepository = new RideRepository();

    /* UC-1 calculate fare */
    public int calculate_fare(int distance, int time, RideType type) {
        if (type == RideType.NORMAL) {
            return Math.max(MINIMUM_NORMAL_FARE, COST_PER_KM_NORMAL * distance + COST_PER_MIN_NORMAL * time);
        } else{
            return Math.max(MINIMUM_PREMIUM_FARE, COST_PER_KM_PREMIUM * distance + COST_PER_MIN_PREMIUM * time);
        }
    }

    /* UC-2 aggregate fare of multiple rides
    * Refactored UC-3 to return invoice*/
    public InvoiceSummary calculate_fare(Ride[] rides){
        int totalFare = 0;
        for(Ride ride: rides){
            totalFare = totalFare + this.calculate_fare(ride.getDistance(), ride.getTime(), ride.getType());
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