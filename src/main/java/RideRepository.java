import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {

    private Map<String, List<Ride>> user_rides;
    public RideRepository(){
        this.user_rides = new HashMap<>();
    }

    /* method to add a user and their corresponding rides in K-V pairs */
    public void addRides(String user_id, Ride[] rides){
        if(!user_rides.containsKey(user_id)){
            user_rides.put(user_id, new ArrayList<>());
        }
        List<Ride> userRideList = user_rides.get(user_id);
        for (Ride ride : rides){
            userRideList.add(ride);
        }
    }

    public Ride[] getRides(String user_id){
        if(user_rides.containsKey(user_id)){
            List<Ride> userRideList = user_rides.get(user_id);
            return userRideList.toArray(new Ride[0]); // a new array is created and list items are assigned to it
        }
        System.out.println("User doesn't exist");
        return null;
    }
}
