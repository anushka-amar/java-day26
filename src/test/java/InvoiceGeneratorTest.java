import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceGeneratorTest {

    InvoiceGenerator invoiceGenerator;

    @BeforeEach //re-initializing the object before every test case runs
    void init(){
        invoiceGenerator = new InvoiceGenerator();
    }

    /* UC-1 calculate fare */
    @Test
    void givenDistanceAndTime_shouldReturnTotalFare(){
        assertEquals(227, invoiceGenerator.calculate_fare(5, 20));
    }

    /* UC-2 aggregate fare of multiple rides */
    @Test
    void givenMultipleRides_shouldReturnAggregateTotalForAll(){
        Ride[] rides = {
          new Ride(4, 10),
          new Ride(8, 15)
        };
        assertEquals(155, invoiceGenerator.aggregate_fare(rides));
    }

    /* UC-3 enhanced-invoice - average fare per ride */
    @Test
    void givenTotalFare_shouldReturnAvgFarePerRide(){
        Ride[] rides = {
                new Ride(4, 10),
                new Ride(8, 15)
        };
        assertEquals(77.5, invoiceGenerator.average_fare(rides));
    }
}